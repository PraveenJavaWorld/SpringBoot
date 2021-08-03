package org.pc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMP")
public class Employee {
	
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;

}
