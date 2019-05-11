package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

//ͨ�õ����ݲ�������
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
	private static final String USENAME = "root";
	private static final String PWD = "123456789123wzx";
	public static PreparedStatement pstmt = null ;
	public static Connection connection = null ;
	public static ResultSet rs = null ;
	//ͨ�õ���ɾ��
	public static boolean executeUpdate(String sql,Object[] params) {//{"zs",1}
		try {
			 //Object[] obs = { name,age ,...,x} ; 
//			  String sql = "delete from xxx where Name = ? or id = ?  " ;
//			  pstmt.setInt(1,sno );
			  //setXxx()�����ĸ��� ������ ?�ĸ����� ��?�ĸ��� �ֺ� ����params�ĸ���һ��
			  //setXxx()�����ĸ��� ->����params�ĸ���һ��
				pstmt = createPreParedStatement(sql,params);
			  int count = pstmt.executeUpdate() ;
			  if(count>0)
				  return true ;
			  else 
				  return false ;
			  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return false ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return false ;
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}
		finally {
			closeAll(null,pstmt,connection);
		}
}
	//Statement
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection)
	{
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
		
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver") ;
		 return  DriverManager.getConnection( URL,USENAME,PWD) ;
	}
	
	public static PreparedStatement createPreParedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		  pstmt = getConnection() .prepareStatement( sql) ;
		  if(params!=null ) {
			  for(int i=0;i<params.length;i++) {
				  pstmt.setObject(i+1, params[i]);
			  }
		  }
		  return pstmt;
	}
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
		  pstmt = createPreParedStatement(sql, null);
		  rs = pstmt.executeQuery();
		 if(rs.next()) {
			 count=rs.getInt(1);
			
		 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, connection);
		}
		return count;
	}
	
		//ͨ�õĲ�  :ͨ�� ��ʾ  �ʺ��� �κβ�ѯ
		public static ResultSet executeQuery( String sql ,Object[] params) {//select xxx from xx where name=? or id=?
			Student student = null;
			List<Student> students = new ArrayList<>();
			try {
				
				//				  String sql = "select * from student" ;//select enmae ,job from xxxx where...id>3
				
				pstmt = createPreParedStatement(sql,params);
				 rs =  pstmt.executeQuery() ;
				  return rs ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null ; 
			} catch (SQLException e) {
				e.printStackTrace();
				return null ; 
			}catch (Exception e) {
				e.printStackTrace();
				return null ; 
			}
//			finally {
//					try {
//						if(rs!=null)rs.close();
//						if(pstmt!=null)pstmt.close();
//						if(connection!=null)connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} 
//			}
		}
	
	
	
	
	
}
