<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.bit.model.MemberVO" %>
<%
MemberVO paramVO = new MemberVO();
paramVO.setNum(1);
paramVO.setId("LKLK");
paramVO.setName("lklk");
paramVO.setEmail("lklk@lklk.com");
request.setAttribute("paramVO", paramVO);	// 객체 바인딩
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>NUM</td>
<td>ID</td>
<td>Name</td>
<td>Email</td>
</tr>
<tr>
<!-- 속성만 적어도 되는구 -->
<td>${paramVO.num}</td>
<td>${paramVO.id}</td>
<td>${paramVO.name}</td>
<td>${paramVO.email}</td>
</tr>
</table>
</body>
</html>