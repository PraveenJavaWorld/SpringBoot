package org.pc.service;

import org.pc.model.MailModel;
import org.springframework.web.multipart.MultipartFile;

public interface IMailMgmtService {
	
	public String sendMail(MailModel model,MultipartFile file) throws Exception;

}
