package org.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

public class StudentDaoImpl implements IStudentDao{
	private final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
	private final String USENAME = "root";
	private final String PWD = "123456789123wzx";

	
	public boolean addStudent(Student student) {
		String sql = "insert into student values(?,?,?,?)";
		Object[]params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	
		
	}
	//����ѧ���޸�ѧ��������sno�ҵ�����ˣ���������޸�Ϊstudent
	public boolean updateStudentBySno(int sno,Student student) {//3->zs,23,bj
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[]params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	
	}
	//为什么成乱码了啊
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from student ";
		 rs = DBUtil.executeQuery(sql, null);
			//rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	
	
	//��ѯ�����Ƿ����
	public boolean isExist(int sno) {
		return queryStudentBySno(sno) == null ? false: true;
	}


//ѧ�Ų���
	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USENAME, PWD);
			String sql = "select * from student where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, connection);
		}
	}
	
	public int getTotalCount() {//��ѯ��������
		
		String sql="select count(1) from student";
		
		return DBUtil.getTotalCount(sql);
	}
	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		String sql ="select * from student limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		List<Student> students = new ArrayList<>();
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				Student student =new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"),rs.getString("saddress"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return students;
	}

}
