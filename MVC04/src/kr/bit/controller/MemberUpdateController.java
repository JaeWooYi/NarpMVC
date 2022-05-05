package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num=Integer.parseInt(request.getParameter("num"));
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO paramVO=new MemberVO();
		paramVO.setNum(num);
		paramVO.setAge(age);
		paramVO.setEmail(email);
		paramVO.setPhone(phone);
		
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberUpdate(paramVO);
		String nextPage = null;
		if(cnt>0) {
		    	// 수정성공		        
		    	nextPage = "redirect:/MVC04/memberList.do";
		 }else {
		    	// 가입실패-> 예외객체를 만들어서  WAS에게 던지자.
		    	throw new ServletException("not update");	    	
		 }
		
		return nextPage;
	}

}
