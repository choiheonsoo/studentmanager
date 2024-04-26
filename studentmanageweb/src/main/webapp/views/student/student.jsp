<%@page import="com.student.dto.StudentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%List<StudentDto> students = (List<StudentDto>)request.getAttribute("students"); %>
<%List<StudentDto> studentName = (List<StudentDto>)request.getAttribute("studentName"); %>
<%List<StudentDto> studentGrade = (List<StudentDto>)request.getAttribute("studentGrade"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름으로 조회
	<form action="<%=request.getContextPath() %>/student/searchbyname.do">
		<input type="text" name="studentName"> <input type="submit"
			value="이름으로 조회">
	</form>
	학년으로조회
	<form action="<%=request.getContextPath() %>/student/searchbygrade.do">
		<input type="number" name="studentGrade" min="1" required> <input type="submit"
			value="학년으로 조회">
	</form>
	<button onclick="btn4();">학생등록</button>

	<script>
	function btn4(){
		location.href="<%=request.getContextPath() %>/student/addstudent.do";
	}
	</script>
	<table>
		<tr>
			<th>학생번호</th>
			<th>학생이름</th>
			<th>나이</th>
			<th>학년</th>
			<th>반</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>성별</th>
		</tr>
		<%if(students != null){
			int i = 0 , j =0;
			for(StudentDto s : students){
			%>
		<tr>
			<td><%=s.getStudentNo() %></td>
			<td><%=s.getStudentName() %></td>
			<td><%=s.getAge() %></td>
			<td><%=s.getGrade() %></td>
			<td><%=s.getClasssNumber() %></td>
			<td><%=s.getHeight() %></td>
			<td><%=s.getAddress() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getGender() %></td>
			<td><button class="update">수정</button></td> 
			<td><button class="delete">삭제</button></td> 
			<script>
				document.querySelectorAll(".update")[<%=i%>].addEventListener("click", ()=>{
					location.href="<%=request.getContextPath()%>/student/updatestudent.do?student=<%=s.getStudentNo()%>";
					<%=i++%>
				});
				document.querySelectorAll(".delete")[<%=j%>].addEventListener("click", ()=>{
					location.href="<%=request.getContextPath()%>/student/deletestudent.do?student2=<%=s.getStudentNo()%>";
					<%=j++%>
				});
			</script>
		</tr>
		<%} 
		}%>
		<%if(studentName != null){
			for(StudentDto s : studentName){
			%>
		<tr>
			<td><%=s.getStudentNo() %></td>
			<td><%=s.getStudentName() %></td>
			<td><%=s.getAge() %></td>
			<td><%=s.getGrade() %></td>
			<td><%=s.getClasssNumber() %></td>
			<td><%=s.getHeight() %></td>
			<td><%=s.getAddress() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getGender() %></td>
		</tr>
		<%} 
		}%>
		<%if(studentGrade != null){
			for(StudentDto s : studentGrade){
			%>
		<tr>
			<td><%=s.getStudentNo() %></td>
			<td><%=s.getStudentName() %></td>
			<td><%=s.getAge() %></td>
			<td><%=s.getGrade() %></td>
			<td><%=s.getClasssNumber() %></td>
			<td><%=s.getHeight() %></td>
			<td><%=s.getAddress() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getGender() %></td>
		</tr>
		<%} 
		}%>
	</table>
</body>
</html>