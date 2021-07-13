package org.pc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pc.entity.Student;
import org.pc.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService,UserDetailsService {
	
	@Autowired
	private IStudentRepo repo;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	 

	@Override
	public String insertStudent(Student stud) {
		//get password and encode it
		String encodedPwd = encoder.encode(stud.getPassword());
		//set encoded password to entity class
		stud.setPassword(encodedPwd);
		stud.setStatus(1);
		//use repo
		Student student = repo.save(stud);
		if(student!=null)
			return "Student Inserted With ID :: "+student.getId();
		else
			return "Insertion Failure";
	}
	
	@Override
	public List<Student> getList() {
		//use repo
		List<Student> list = repo.findAll();
		return list;
	}
	
	//================================================================================
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetch obj using username
		Optional<Student> opt = repo.findByUsername(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("Username Not Exist");
		else {
			Student stud = opt.get();
			return new User(username, stud.getPassword(), List.of(stud.getRole()).stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		}
	}

}
