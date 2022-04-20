<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1"> <!-- 1부터 5까지 1씩 증가라는 뜻의 jstl반복문 -->
<font size="${i}">I'm sad</font><br>
<!-- var -> request.setAttribute -->
<!-- ${} -> request.getAttribute -->
</c:forEach>
</body>
</html>