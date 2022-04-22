<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<String> list = new ArrayList<String>();
list.add("Java");
list.add("Python");
list.add("Javascript");
list.add("c++");
list.add("c#");
request.setAttribute("list", list);	// 객체 바인딩
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="Ex" items="${list}">
${Ex}<br>
</c:forEach>
</body>
</html>