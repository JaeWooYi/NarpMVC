package kr.bit.frontController;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.*;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		String ctx = request.getContextPath();
		System.out.println(ctx);
		
		// 2. 실제로 요청한 명령이 무엇인지 파악하기
		String command = url.substring(ctx.length());
		System.out.println(command);	// ex) memberList.do
		
		// 3. 요청에 따른 분기작업
		if(command.equals("/memberList.do")) {
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.memberList();
			request.setAttribute("list", list);		// 객체바인딩
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");	// 포워딩
			rd.forward(request, response);
		}else if(command.equals("/memberInsert.do")) {
			
		}else if(command.equals("/memberRegister.do")) {
			
		}else if(command.equals("/memberContent.do")) {
			
		}else if(command.equals("/memberUpdate.do")) {
			
		}else if(command.equals("/memberDelete.do")) {
			
		}
	}

}
