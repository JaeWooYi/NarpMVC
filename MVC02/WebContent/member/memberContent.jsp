<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%
int num = Integer.parseInt(request.getParameter("num"));
MemberDAO memberDAO = new MemberDAO();
MemberVO memberVO = memberDAO.memberContent(num);
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
<form action='memberUpdate.jsp' method='post'>
<input type="hidden" name="num" value="<%=memberVO.getNum()%>" />
<table class='table table-borderd'>
<% if(memberVO != null) {%>
	<tr>
		<td colspan='2'><%=memberVO.getName()%>의 상세보</td>
	</tr>
	<tr>
		<td>번호</td>
		<td><%=memberVO.getNum()%></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=memberVO.getId()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=memberVO.getPass()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=memberVO.getName()%></td>
	</tr>
	<tr>
	
		<td>나이</td>
		<td><input type='text' name='age' value='<%=memberVO.getAge()%>' /></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type='text' name='age' value='<%=memberVO.getEmail()%>' /></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type='text' name='age' value='<%=memberVO.getPhone()%>' /></td>
	</tr>
	<% } else {%>
	<tr>
		<td> 일치하는 회원이 없습니다. </td>
	</tr>
	<% }%>
	<tr>
		<td colspan='2' align='center'>
			<input type='submit' value='수정하기' class='btn btn-primary' />
			<input type='reset' value='취소' class='btn btn-warning' />
			<input type='button' value='리스트로' onclick="location.href='memberList.jsp'" class='btn' />
		</td>
	</tr>
</table>
</form>
</body>
</html>