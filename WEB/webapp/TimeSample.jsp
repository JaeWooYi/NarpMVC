<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
java.util.Date date = new java.util.Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>First Page</h1>
	</br>
	<p>What Time is it now!!</p>
	<%=date.toString()%></br>
	<p>JSP를 이용하여 동적인 페이지를 만들었네</p>
</body>
</html>