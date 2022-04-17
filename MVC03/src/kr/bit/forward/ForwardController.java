package kr.bit.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberVO;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "kkk";
		int age = 14;
		String email = "kkk@kkk.com";
		
		MemberVO paramVO = new MemberVO();
		paramVO.setName(name);
		paramVO.setAge(age);
		paramVO.setEmail(email);
		
		// forward.jsp
		// 객체바인딩
		request.setAttribute("paramVO", paramVO);
		// forwarding
		RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
		rd.forward(request, response);
	}

}
