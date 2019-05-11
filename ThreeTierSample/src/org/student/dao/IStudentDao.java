package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
		public boolean addStudent(Student student) ;

		
		//����ѧ���޸�ѧ��������sno�ҵ�����ˣ���������޸�Ϊstudent
		public boolean updateStudentBySno(int sno,Student student) ;//3->zs,23,bj
		
	
				
		//����ѧ��ɾ��ѧ��
		public boolean deleteStudentBySno(int sno) ;
		

		
		//��ѯȫ��ѧ��
		public List<Student> queryAllStudents() ;
			
			
		
		public boolean isExist(int sno) ;
		
		//��ѯ��������
		public int getTotalCount();

		
		public List<Student> queryStudentsByPage(int currentPage,int pageSize);
	//ѧ�Ų���
		public Student queryStudentBySno(int sno) ;		

}
