<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>    
<%
    	request.setCharacterEncoding("utf-8");
    	//파라메터 수집(VO)
    	int num=Integer.parseInt(request.getParameter("num"));
    	int age=Integer.parseInt(request.getParameter("age"));
    	String email=request.getParameter("email");
    	String phone=request.getParameter("phone");
    	
    	MemberVO memberVO=new MemberVO();
    	memberVO.setNum(num);
    	memberVO.setAge(age);
    	memberVO.setEmail(email);
    	memberVO.setPhone(phone);
    	
    	MemberDAO dao=new MemberDAO();
    	int cnt=dao.memberUpdate(memberVO);
    	if(cnt>0) {
    	    	// 수정성공		        
    	    	response.sendRedirect("memberList.jsp");
    	 }else {
    	    	// 예외객체를 만들어서  WAS에게 던지자.
    	    	throw new ServletException("not update");	    	
    	 }
    %>