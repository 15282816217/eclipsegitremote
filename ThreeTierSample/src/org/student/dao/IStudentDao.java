package org.student.dao;

import java.util.List;

import org.student.entity.Student;
public interface IStudentDao {
		public boolean addStudent(Student student) ;

		
		//根据学号修改学生。根据sno找到这个人，把这个人修改为student
		public boolean updateStudentBySno(int sno,Student student) ;//3->zs,23,bj
		
	
				
		//根据学号删除学生
		public boolean deleteStudentBySno(int sno) ;
		

		
		//查询全部学生
		public List<Student> queryAllStudents() ;
			
			
		
		public boolean isExist(int sno) ;
		
		//查询总数据数
		public int getTotalCount();

		
		public List<Student> queryStudentsByPage(int currentPage,int pageSize);
	//学号查人
		public Student queryStudentBySno(int sno) ;		

}
