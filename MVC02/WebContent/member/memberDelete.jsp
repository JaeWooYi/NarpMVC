<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	
	MemberDAO memberDAO = new MemberDAO();
	int cnt = memberDAO.memberDelete(num);
	if(cnt > 0) {
		response.sendRedirect("memberList.jsp");
	}else {
		throw new ServletException("not delete");
	}
%>