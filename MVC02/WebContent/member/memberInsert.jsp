<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
<%
	// 파라메터 수집(VO로 하는거지)
	// 한글인코딩
	request.setCharacterEncoding("UTF-8");
	// 1. 파라미터 수집(VO)
	// MemberRegister.html에 form안에 name태그들(파라미터) -> id, pass, name ....
	// 위 파라미터들 : HttpServletRequest request의 request에 담아져 있음
	// 이걸 VO에 묶어주는 작업을 지금 할거
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");

	// VO로 묶어주는 작업
	//		MemberVO memberVO = new MemberVO(id, pass, name, age, email, phone);
	//		/* 위 방법으로 안하고
	MemberVO memberVO = new MemberVO(); //로 하면 아래처럼 셋을 다해줘야
	memberVO.setId(id);
	memberVO.setAge(age);
	memberVO.setPass(pass);
	memberVO.setName(name);
	memberVO.setEmail(email);
	memberVO.setPhone(phone);
	//		*/

	// MemberDao 작업 완료 후
	MemberDAO memberDAO = new MemberDAO();
	int cnt = memberDAO.memberInsert(memberVO);
	// PrintWriter out = response.getWriter();
		if (cnt > 0) {
		// 가입 성공
		out.println("Insert Success");
		response.sendRedirect("memberList.jsp");
	} else {
		// 가입 실패 -> 예외를 만들어서 톰캣 WAS에게 던지자.
		throw new ServletException("Not Insert");
	}
%>