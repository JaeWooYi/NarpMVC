<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>메인화면</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Spring WEB MVC 게시판 만들기</div>
    <div class="panel-body">
    
	  <div class="table table-hover">          
	  <table class="table">
	    <thead>
	      <tr>
	        <th>BOARD NUM</th>
	        <th>TITLE</th>
	        <th>COUNT</th>
	        <th>WRITER</th>
	        <th>DATE</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach var="vo" items="${list}">
	      <tr>
	        <td>${vo.idx}</td>
	        <td>${vo.title}</td>
	        <td>${vo.count}</td>
	        <td>${vo.writer}</td>
	        <td>${vo.indate}</td>
	      </tr>
	    </c:forEach>
	      
	    </tbody>
	  </table>
	  </div>
    
    </div>
    <div class="panel-footer">INFLEARN GOOD</div>
  </div>
</div>

</body>
</html>
