package org.pc.model;

import lombok.Data;

@Data
public class MailModel {
	
	private String to;
	private String from;
	private String subject;
	private String body;

}
