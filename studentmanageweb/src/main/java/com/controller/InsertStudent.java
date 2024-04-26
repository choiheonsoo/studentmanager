package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.service.Service.getService;/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/student/insertstudent.do")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		int classNum= Integer.parseInt(request.getParameter("classnumber"));
		double height= Double.parseDouble(request.getParameter("height"));
		String address = request.getParameter("address");
		String phone= request.getParameter("phone");
		char gender = request.getParameter("gender").charAt(0);

		
		int result = getService().insertStudent(name, age, grade,classNum,height,address,phone,gender);
		System.out.println(result > 0 ? "등록 성공" : "등록 실패");
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
