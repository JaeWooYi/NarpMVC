<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
MemberVO paramVO = new MemberVO();
paramVO.setNum(1);
paramVO.setId("LKLK");
paramVO.setName("lklk");
paramVO.setEmail("lklk@lklk.com");
request.setAttribute("paramVO", paramVO);	// 객체 바인딩

List<MemberVO> list = new ArrayList<MemberVO>();
list.add(paramVO);
list.add(paramVO);
list.add(paramVO);
list.add(paramVO);
list.add(paramVO);

request.setAttribute("list", list);
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
		<td>NAME</td>
		<td>EMAIL</td>
	</tr>
	<c:forEach items="${list}" var="paramVO">
		<tr>
		<td>${paramVO.num}</td>
		<td>${paramVO.id}</td>
		<td>${paramVO.name}</td>
		<td>${paramVO.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>