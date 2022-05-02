<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
</head>
<body>
	<form action="memberUpdate.do" method="post">
		<input type="hidden" name="num" value="${paramVO.num}" />
		<table class='table table-bordered'>
			<c:if test="${paramVO != null}">
				<tr>
					<td colspan="2">${paramVO.name}회원의상세보기</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>${paramVO.num}</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>${paramVO.id}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${paramVO.pass}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${paramVO.name}</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${paramVO.age}" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${paramVO.email}" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" value="${paramVO.phone}" /></td>
				</tr>
			</c:if>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="수정하기" class='btn btn-primary' /> <input type="reset"
					value="취소" class='btn btn-warning' /> <input type="button"
					value="리스트" onclick="location.href='/MVC04/memberList.do'"
					class='btn' /></td>
			</tr>
		</table>
	</form>
</body>
</html>