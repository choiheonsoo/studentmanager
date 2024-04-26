<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "<%=request.getContextPath()%>/student/insertstudent.do">
		이름<input type="text" name="name"><br>
		나이<input type="number" name="age" min=0 required><br>
		학년<input type="number" name="grade" min=0 required><br>
		반<input type="number" name="classnumber" min=0 required><br>
		키<input type="text" name="height" required><br>
		주소<input type="text" name="address"><br>
		전화번호<input type="text" name="phone"><br>
		남<input type="radio" name="gender" value="남" checked>
		여<input type="radio" name="gender" value="여"><br>
		<input type="submit" value="회원 등록">
	</form>
</body>
</html>