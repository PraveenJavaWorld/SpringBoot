package org.pc.service;

import javax.mail.internet.MimeMessage;

import org.pc.model.MailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MailMgmtServiceImpl implements IMailMgmtService {
	
	@Autowired
	private JavaMailSender sender;
	

	@Override
	public String sendMail(MailModel model,MultipartFile file) throws Exception {
		//create MimeMessage obj
		MimeMessage message = sender.createMimeMessage();
		//create MimeMessageHelper obj
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		//set values
		helper.setTo(model.getTo());
		helper.setFrom(model.getFrom());
		helper.setSubject(model.getSubject());
		helper.setText(model.getBody());
		if(file!=null) {
			helper.addAttachment(model.getFile().getOriginalFilename(),file);
		}
		
		//send message
		sender.send(message);
		return "Mail has been delivered to :: "+model.getTo();
	}

}
