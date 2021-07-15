package org.pc.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MailModel {
	
	private String to;
	private String from;
	private String subject;
	private String body;
	private MultipartFile file;

}
