<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cnt" value="80" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${cnt%2 == 0}">	<!-- jstl에서의 스위치문 형식이야 -->
		<h1>cnt is even</h1>
	</c:when>
	<c:when test="${cnt%2 != 0}">
		<h1>cnt is odd number</h1>
	</c:when>
	<c:otherwise>					<!-- jstl에서의 스위치문 형식이야 : 이게 default야 -->
		<h1>일치하는 when절이 없습니다.</h1>
	</c:otherwise>
</c:choose>
</body>
</html>