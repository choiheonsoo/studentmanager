package com.controller;

import static com.service.Service.getService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dto.StudentDto;
/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/student/deletestudent.do")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentNo = Integer.parseInt(request.getParameter("student2"));
		int result= getService().deleteStudentCheck(studentNo);
		System.out.println(result > 0 ? "삭제성공" : "삭제실패");
//		RequestDispatcher rd= request.getRequestDispatcher(request.getContextPath()+"/views/student/DeleteStudent.jsp");
//		rd.forward(request, response);
		 response.sendRedirect(request.getContextPath()+"/student/searchall.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
