<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%
		// 전체 List 가져오기. -> Model과 연동
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberVO> list = memberDAO.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
</head>
<body>
<table class="table table-bordered">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>나이</td>
		<td>이메일</td>
		<td>전화번호</td>
	</tr>
	
	<% 	for(MemberVO vo : list){  %>
		<tr>
		<td><%=vo.getNum()%></td>
		<td><%=vo.getId()%></td>
		<td><%=vo.getPass()%></td>
		<td><%=vo.getName()%></td>
		<td><%=vo.getAge()%></td>
		<td><%=vo.getEmail()%></td>
		<td><%=vo.getPhone()%></td>
		</tr>
	<% 	} %>
	
</table>
</body>
</html>