package org.student.service.impl;

import java.util.List;

import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼��㣨��+���� ��Dao�����װ
public class StudentServiceImpl  implements IStudentService{
	StudentDaoImpl studentDao =new StudentDaoImpl();
	public boolean addStudent(Student student) {
		if(studentDao.isExist(student.getSno())==false) {
			studentDao.addStudent(student);
			System.out.println("��ӳɹ���");
			return true;
		}else {
			System.out.println("�����Ѿ����ڣ�");
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
	//����ѧ�Ų�ѯһ����
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	//��ѯ��������
	@Override
	public int getTotalCount() {
		
		return studentDao.getTotalCount();
	}
	//��ѯ��ǰҳ�����ݼ���
	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	
}