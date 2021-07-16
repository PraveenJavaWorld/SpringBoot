package org.pc.service;

import java.io.OutputStream;

import org.pc.model.MailModel;

public interface IMailMgmtService {
	
	public String sendMail(MailModel model) throws Exception;
	public void writePdf(OutputStream outputstream) throws Exception;

}
