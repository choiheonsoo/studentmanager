<%@page import="com.student.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDto s = (StudentDto)request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "<%=request.getContextPath()%>/student/updateStudent1.do">
		번호<input type="text" name="stuNo" value=<%=s.getStudentNo() %> hidden>
		이름<input type="text" name="name" value=<%=s.getStudentName() %>><br>
		나이<input type="number" name="age" min=0 required value=<%=s.getAge() %>><br>
		학년<input type="number" name="grade" min=0 required value=<%=s.getGrade() %>><br>
		반<input type="number" name="classnumber" min=0 required value=<%=s.getClasssNumber() %>><br>
		키<input type="text" name="height" required value=<%=s.getHeight() %>><br>
		주소<input type="text" name="address" value=<%=s.getAddress() %>><br>
		전화번호<input type="text" name="phone" value=<%=s.getPhone() %>><br>
		남<input type="radio" name="gender" value= "남" checked=<%=s.getGender()=='남' ? true : false  %>>
		여<input type="radio" name="gender" value="여" checked=<%=s.getGender()=='여' ? true : false  %>><br>
		<input type="submit" value="회원 등록">
	</form>
</body>
</html>