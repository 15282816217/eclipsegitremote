package org.student.service;

import java.util.List;

import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;

public interface IStudentService {
	
	public boolean addStudent(Student student);
	
	
	public  boolean deleteStudentBySno(int sno);
		
	
	public boolean updateStudentBySno(int sno,Student student);
	
	
	public Student queryStudentBySno(int sno);
	
	
	//查询全部学
	public List<Student> queryAllStudents();


	public int getTotalCount();
	
	
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
