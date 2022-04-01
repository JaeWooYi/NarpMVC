package kr.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트에게 요청 받기.(memberList.do)
		
		// 2. 전체 List 가져오기. -> Model과 연동 
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberVO> list = memberDAO.memberList(); 
		
		// 3. 회원 전체 List를 html로 만들어서 응답하기 
		
	}

}
