package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx=request.getContextPath(); // /MVC06
		
		// 세션을 가져와서 세션을 끊어주면 된다.
		// 1. 세션제거 방법1 - 강제 
		request.getSession().invalidate();
		// 2. 세션제거 방법2 - 브라우져 종료 
		// 3. 세션제거 방법3 - 세션이 종료 될때까지 기다리기(session timeout : 기본 30분= 1800초 
		
		return "redirect:"+ctx+"/memberList.do";
	}

}
