<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	nav{
		width:100vw;
		height:100px;
		display:flex;
		flex-direction: row;
		justify-content: space-around;
	}
</style>
</head>
<body>
	<nav>

		<button onclick="btn1();">전체회원조회</button>
		
	</nav>
	<script>
		function btn1(){
			location.href="<%=request.getContextPath() %>/student/searchall.do";
		}
	</script>
	
</body>
</html>