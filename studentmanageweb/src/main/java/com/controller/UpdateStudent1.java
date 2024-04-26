package com.controller;

import static com.service.Service.getService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent1
 */
@WebServlet("/student/updateStudent1.do")
public class UpdateStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent1() {
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
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		int result = getService().updateStudent1(name, age, grade,classNum,height,address,phone,gender,stuNo);
		System.out.println(result > 0 ? "수정 성공" : "수정 실패");
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
