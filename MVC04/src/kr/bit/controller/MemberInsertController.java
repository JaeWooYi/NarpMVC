package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
		// 1-insert. 파라메터수집(VO)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); // "40"->40
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// 2-insert. 파라메터수집(VO)
		// MemberVO vo=new MemberVO(id, pass, name, age, email, phone);
		MemberVO paramVO = new MemberVO();
		paramVO.setId(id);
		paramVO.setPass(pass);
		paramVO.setName(name);
		paramVO.setAge(age);
		paramVO.setEmail(email);
		paramVO.setPhone(phone);

		// Model과 연동부분
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(paramVO);
		String nextPage = null;
		if (cnt > 0) {
			// 가입성공
			// out.println("insert success"); // 다시 회원리스트 보기로 가야된다.(/MVC04/memberList.do)
			nextPage = "redirect:"+ctx+"/memberList.do";
		} else {
			// 가입실패-> 예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");
		}

		return nextPage;
	}

}
