package com.service;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;
import static com.student.dao.StudentDao.getDao;

import java.sql.Connection;
import java.util.List;

import com.student.dto.StudentDto;
public class Service {
	private Service() {}
	private static Service service = new Service();
	public static Service getService() {return service;};
	
	public List<StudentDto> searchAll(){
		Connection conn = getConnection();
		List<StudentDto> students = getDao().searchAll(conn);
		close(conn);
		return students;
	}
	
	public List<StudentDto> searchByName(String name){
		Connection conn = getConnection();
		List<StudentDto> students = getDao().searchName(conn,name);
		close(conn);
		return students;
	}
	public List<StudentDto> searchByGrade(int grade){
		Connection conn = getConnection();
		List<StudentDto> students = getDao().searchByGrade(conn,grade);
		close(conn);
		return students;
	}
	
	public int insertStudent(String name, int age, int grade,int classNum, double height, String address, String phone, char gender) {
		Connection conn = getConnection();
		StudentDto s = StudentDto.builder().studentName(name).age(age).grade(grade).classsNumber(classNum).height(height).address(address).phone(phone).gender(gender).build();
		int result = getDao().insertStudent(conn, s);
		close(conn);
		return result;
	}
	
	public int deleteStudentCheck(int stuNo) {
		Connection conn = getConnection();
		int result = getDao().deleteStudentCheck(conn, stuNo);
		close(conn);
		return result;
	}
	
	public StudentDto updateStudent(int stuNo) {
		Connection conn = getConnection();
		StudentDto student = getDao().updateStudent(conn, stuNo);
		close(conn);
		return student;
	}
	public int updateStudent1(String name, int age, int grade,int classNum, double height, String address, String phone, char gender, int stuNo) {
		Connection conn = getConnection();
		StudentDto s = StudentDto.builder().studentName(name).age(age).grade(grade).classsNumber(classNum).height(height).address(address).phone(phone).gender(gender).studentNo(stuNo).build();
		int result = getDao().updateStudent1(conn, s);
		close(conn);
		return result;
	}
}
