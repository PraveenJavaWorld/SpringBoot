package org.pc.repository;

import java.util.Optional;

import org.pc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {
	
	//SELECT * FROM STUDENT_INFO WHERE username=?
	Optional<Student> findByUsername(String username);

}
