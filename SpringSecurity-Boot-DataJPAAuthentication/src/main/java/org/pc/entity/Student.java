package org.pc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Student_Info")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String branch;
	@Column(length = 10)
	private String username;
	@Column(length = 60)
	private String password;
	@Column(length = 15)
	private String role;
	private Integer status;

}
