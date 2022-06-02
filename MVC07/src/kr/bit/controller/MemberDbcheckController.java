package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDbcheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// $.ajax(); 에서 오는 요청을 처리하는거야 
		String id = request.getParameter("id"); // { "id" : id } 형태로 넘어옴 
		MemberDAO dao = new MemberDAO();
		
		String dbDouble = dao.memberDbcheck(id);	// Yes or No가 들어있다.
		// ajax함수에 만들어 놓은 콜백함수로 응답이 된다.(dbCheck)
		response.getWriter().print(dbDouble);
		
		return null;
	}

}
