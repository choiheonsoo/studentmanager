package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.common.JDBCTemplate.close;
import com.student.dto.StudentDto;

public class StudentDao {
	private StudentDao() {}
	private static StudentDao dao = new StudentDao();
	public static StudentDao getDao() {return dao;}
	
	public List<StudentDto> searchAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDto> students = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				students.add(getStudent(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	public List<StudentDto> searchName(Connection conn, String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDto> students = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from student where student_name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				students.add(getStudent(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	
	public List<StudentDto> searchByGrade(Connection conn, int grade){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDto> students = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from student where grade = ?");
			pstmt.setInt(1, grade);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				students.add(getStudent(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return students;
	}
	
	public int insertStudent(Connection conn, StudentDto s) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into student values(student_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudentName());
			pstmt.setInt(2, s.getAge());
			pstmt.setInt(3, s.getGrade());
			pstmt.setInt(4, s.getClasssNumber());
			pstmt.setDouble(5, s.getHeight());
			pstmt.setString(6, s.getAddress());
			pstmt.setString(7, s.getPhone());
			pstmt.setString(8, String.valueOf(s.getGender()));
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteStudentCheck(Connection conn, int stuNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "delete student where student_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public StudentDto updateStudent(Connection conn, int stuNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDto student = new StudentDto();
		try {
			String sql = "select * from student where student_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stuNo);
			rs=pstmt.executeQuery();
			if(rs.next()){
				student.setStudentNo(rs.getInt("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setGrade(rs.getInt("grade"));
				student.setClasssNumber(rs.getInt("classnumber"));
				student.setHeight(rs.getDouble("height"));
				student.setAddress(rs.getString("address"));
				student.setPhone(rs.getString("phone"));
				student.setGender(rs.getString("gender").charAt(0));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return student;
	}
	
	public int updateStudent1(Connection conn, StudentDto s) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update student set student_name = ?, age=?, grade=?, classnumber=?, height=?, address=?, phone=?, gender=?"
					+ " where student_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudentName());
			pstmt.setInt(2, s.getAge());
			pstmt.setInt(3, s.getGrade());
			pstmt.setInt(4, s.getClasssNumber());
			pstmt.setDouble(5, s.getHeight());
			pstmt.setString(6, s.getAddress());
			pstmt.setString(7, s.getPhone());
			pstmt.setString(8, String.valueOf(s.getGender()));
			pstmt.setInt(9, s.getStudentNo());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	private StudentDto getStudent(ResultSet rs) throws SQLException {
		return StudentDto.builder()
				.studentNo(rs.getInt("student_no"))
				.studentName(rs.getString("student_name"))
				.age(rs.getInt("age"))
				.grade(rs.getInt("grade"))
				.classsNumber(rs.getInt("classnumber"))
				.height(rs.getDouble("height"))
				.address(rs.getString("address"))
				.phone(rs.getString("phone"))
				.gender(rs.getString("gender").charAt(0))
				.build();
	}
}
