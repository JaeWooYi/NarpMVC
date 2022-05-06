package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller{

	@Override
	// public String requestHandler -> String : 다음페이지의 정보를 리턴한다
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. MODEL연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 최종적으로는 list를 member/memberList.jsp에다가 줘야한
		// 2. 객체 바인딩
		request.setAttribute("list", list);
		
		// 3. View page의 정보
		// 다음페이지는 
//		return "/WEB-INF/member/memberList.jsp";	// requestHandler의 type이 void가 아니라 String으로 가야겠지?
		return "memberList";	// requestHandler의 type이 void가 아니라 String으로 가야겠지?
	}

}
