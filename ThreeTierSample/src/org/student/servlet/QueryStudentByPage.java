package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryStudentByPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		int count = studentService.getTotalCount();
		
		Page p =new Page();
		
		String cPage = request.getParameter("currentPage");
		
		if(cPage==null) {
			cPage="1";
		}

		
		
		int currentPage =Integer.parseInt(cPage);
		p.setCurrentPage(currentPage);
	//×¢ÒâË³Ðò
		int totalcount =studentService.getTotalCount();
		p.setTotalCount(totalcount);
		
		int pageSize = 3;
		p.setPageSize(pageSize);
		studentService.queryStudentsByPage(currentPage, pageSize);
		List<Student> students = studentService.queryStudentsByPage(currentPage,pageSize);
		System.out.println(students);
		System.out.println(count);
		
	
		p.setStudents(students);
		request.setAttribute("p", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
