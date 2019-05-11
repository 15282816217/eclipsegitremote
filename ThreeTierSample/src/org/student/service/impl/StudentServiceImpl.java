package org.student.service.impl;

import java.util.List;

import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层（查+增） 对Dao层的组装
public class StudentServiceImpl  implements IStudentService{
	StudentDaoImpl studentDao =new StudentDaoImpl();
	public boolean addStudent(Student student) {
		if(studentDao.isExist(student.getSno())==false) {
			studentDao.addStudent(student);
			System.out.println("添加成功！");
			return true;
		}else {
			System.out.println("此人已经存在！");
			return false;
		}
	}
	public  boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
		return studentDao.deleteStudentBySno(sno);
		}else {
			return false;
		}
	}
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno,student);
		}return false;
	}
	//根据学号查询一个人
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	//查询数据总数
	@Override
	public int getTotalCount() {
		
		return studentDao.getTotalCount();
	}
	//查询当前页的数据集合
	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	
}