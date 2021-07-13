package org.pc.service;

import java.util.List;

import org.pc.entity.Student;

public interface IStudentMgmtService {
	
	public String insertStudent(Student stud);
	public List<Student> getList();

}
