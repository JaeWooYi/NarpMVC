<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>    
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script type="text/javascript">
  function deleteFn(num){
	  location.href="${ctx}/memberDelete.do?num="+num; // ?num=12
  }
</script>
</head>
<body>
[MVC04 예제 = FrontController + POJO]<br>
<table class="table table-bordered">
  <tr>
    <td>번호</td>
    <td>아이디</td>
    <td>비밀번호</td>
    <td>이름</td>
    <td>나이</td>
    <td>이메일</td> 
    <td>전화번호</td>
    <td>삭제</td>
  </tr>
  <c:forEach items="${list}" var="paramVO">
    	 <tr>
    	    <td>${paramVO.num}	</td>
    	    <td><a href="${ctx}/memberContent.do?num=${paramVO.num}">${paramVO.id}</a></td>
    	    <td>${paramVO.pass}</td>
    	    <td>${paramVO.name}</td>
    	    <td>${paramVO.age}</td>
    	    <td>${paramVO.email}</td>
    	    <td>${paramVO.phone}</td>
    	    <td><input type="button" value="삭제" class="btn btn-warning" onclick="deleteFn(${paramVO.num})"></td>
		</tr>    	      	 
  </c:forEach>
  <tr>
  <td colspan="8" align="right"><input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='${ctx}/memberRegister.do'"/></td>
  </tr>
</table>
</body>
</html>

