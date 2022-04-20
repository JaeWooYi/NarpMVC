<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// controller가 배열을 만들었다고 가정하고 실습
String[] str = {"apple", "banana", "grape", "orange", "melon"};
request.setAttribute("str", str);	// 객체 바인딩
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="fruits" items="${str}">
${fruits}<br>
</c:forEach>
</body>
</html>