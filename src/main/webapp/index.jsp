<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// java 코드
	String name = "홍길동";
	int age = 25;
	%>
	<h2>이름 : <%= name %></h2>
	<h2>나이 : <%=age %></h2>  
</body>
</html>