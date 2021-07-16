/*package org.pc.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pc.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component("pdfReport")
public class PDFReport extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read Model Data
		List<Employee> listEmps = (List<Employee>) model.get("listEmps");
		//add paragraph
		Paragraph para = new Paragraph("Employee Report",new Font(Font.BOLDITALIC));
		document.add(para);
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

	}

}
*/