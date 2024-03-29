package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트에게 요청을 받아서 파라미터를 수집해야한다.
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// 위 수집한거 VO에 묶어주기
		MemberVO memberVO = new MemberVO();
		memberVO.setNum(num);
		memberVO.setAge(age);
		memberVO.setEmail(email);
		memberVO.setPhone(phone);
		
		// DAO모델을 연동해서 업데이트를 시켜보자
		MemberDAO memberDAO = new MemberDAO();
		int cnt = memberDAO.memberUpdate(memberVO);
		
		// 성공, 실패 테스트
		PrintWriter out = response.getWriter();
		if(cnt > 0) {
			// Update 성공			
			out.println("Update Success");
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			// 가입 실패 -> 예외를 만들어서 톰캣 WAS에게 던지자.
			throw new ServletException("Not Update");
		}
	}

}
