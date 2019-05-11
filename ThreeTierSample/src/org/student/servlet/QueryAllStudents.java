package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryAllStudentsServlet
 */
public class QueryAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public QueryAllStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IStudentService service  = new StudentServiceImpl();
		List<Student> students = service.queryAllStudents() ;
		
		System.out.println(students);
		request.setAttribute("students", students);
		//��Ϊrequest���������ݣ������Ҫͨ������ת���ķ�ʽ��ת ���ض���ᶪʧrequest��
		//pageContext<request<session<application
		
		request.getRequestDispatcher( "index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
