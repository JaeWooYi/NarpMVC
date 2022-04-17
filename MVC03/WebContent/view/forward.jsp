<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>    
<%
MemberVO paramVO = (MemberVO)request.getAttribute("paramVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Controller에서 받는 데이터 출력<br>
이름 : <%=paramVO.getName() %><br>
나이 : <%=paramVO.getAge() %><br>
이메일 : <%=paramVO.getEmail() %><br>
</body>
</html>