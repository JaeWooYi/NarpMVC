package kr.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		// MemberDAO객체 만들었으니 삭제 메서드 만들러 가볼까? MemberDAO에
		MemberDAO memberDAO = new MemberDAO();
		int cnt = memberDAO.memberDelete(num);
		if(cnt > 0) {
			response.sendRedirect("/MVC01/memberList.do");
		}else {
			throw new ServletException("not delete");
		}
	}

}
