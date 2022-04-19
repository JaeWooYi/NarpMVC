<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl을 사용하려면 아래처럼 써야함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 1-1. jstl을 안썻을때 jsp에서 변수를 선언했을 때 아래와 같이 함 -->
<%
int cnt = 10;
%>
<!-- 2-1.jstl을 사용해보자 -->
<c:set var="cnt2" value="20" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1-2. 출력할때는 %=을 썻지. -->
<%=cnt%><br>
<!-- 2-2. jstl출력 해보자. 연산까지 해보자 그냥 더하기 숫자 같은거 하면되. -->
${cnt2 * 10}<br>
${cnt2 > 10}
</body>
</html>