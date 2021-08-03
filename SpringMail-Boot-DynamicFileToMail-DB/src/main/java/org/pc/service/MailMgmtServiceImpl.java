package org.pc.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.pc.entity.Employee;
import org.pc.model.MailModel;
import org.pc.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class MailMgmtServiceImpl implements IMailMgmtService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private IEmployeeRepo repo; 
		
	ByteArrayOutputStream outputStream = null;

	@Override
	public String sendMail(MailModel model) throws Exception {
		
		//now write the PDF content to the output stream
		outputStream = new ByteArrayOutputStream();
		writePdf(outputStream);
		byte[] bytes = outputStream.toByteArray();
		
		//construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("test.pdf");
        
        //construct the mime multi part
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(pdfBodyPart);
        
		//create MimeMessage obj
		MimeMessage message = sender.createMimeMessage();
		//create MimeMessageHelper obj
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		//set values
		helper.setTo(model.getTo());
		helper.setFrom(model.getFrom());
		helper.setSubject(model.getSubject());
		helper.setText(model.getBody());
		
		message.setContent(mimeMultipart);
		
		
		//send message
		sender.send(message);
		return "Mail has been delivered to :: "+model.getTo();
	}
	
	@Override
	public void writePdf(OutputStream outputStream) throws Exception{
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        
        List<Employee> listEmps = repo.findAll();
         
        document.open();
         
        document.addTitle("Title PDF");
        document.addSubject("Testing email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("Praveen");
        document.addCreator("Rocky");
        
        //add paragraph
        Paragraph paragraph = new Paragraph("Employee Report",new Font(Font.BOLD));
        document.add(paragraph);
        
        //add table
        Table table = new Table(5,listEmps.size());
		for(Employee emp:listEmps) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		document.add(table);
         
        document.close();
    }


}
