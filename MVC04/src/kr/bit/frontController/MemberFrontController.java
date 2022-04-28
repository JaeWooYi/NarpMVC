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
		
		// 한글깨짐 방지
		request.setCharacterEncoding("euc-kr");
		
		// 1. 클라이언트가 어떤 요청을 했는지 파악하기
		String url = request.getRequestURI();
		System.out.println(url);
		String ctx = request.getContextPath();
		System.out.println(ctx);
		
		// 2. 실제로 요청한 명령이 무엇인지 파악하기
		String command = url.substring(ctx.length());
		System.out.println(command);	// ex) memberList.do
		
		// 3. 요청에 따른 분기작업(if~else if)
		if(command.equals("/memberList.do")) {
			
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.memberList();
			request.setAttribute("list", list);		// 객체바인딩
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");	// 포워딩
			rd.forward(request, response);
			
		}else if(command.equals("/memberInsert.do")) {
			
			// 1-insert. 파라메터수집(VO)
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age")); // "40"->40
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			
			// 2-insert. 파라메터수집(VO)
			//MemberVO vo=new MemberVO(id, pass, name, age, email, phone);
			MemberVO paramVO=new MemberVO();
			paramVO.setId(id);
			paramVO.setPass(pass);
			paramVO.setName(name);
			paramVO.setAge(age);
			paramVO.setEmail(email);
			paramVO.setPhone(phone);
			
			// Model과 연동부분
		    MemberDAO dao=new MemberDAO();
		    int cnt=dao.memberInsert(paramVO);
		    if(cnt>0) {
		    	// 가입성공
		        //out.println("insert success");	// 다시 회원리스트 보기로 가야된다.(/MVC04/memberList.do)
		    	response.sendRedirect("/MVC04/memberList.do");
		    }else {
		    	// 가입실패-> 예외객체를 만들어서  WAS에게 던지자.
		    	throw new ServletException("not insert");	    	
		    }
			
		}else if(command.equals("/memberRegister.do")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");	// 포워딩
			rd.forward(request, response);
			
		}else if(command.equals("/memberContent.do")) {
			
			int num=Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao=new MemberDAO();
			MemberVO paramVO=dao.memberContent(num);
			
			// 객체바인딩
			request.setAttribute("paramVO", paramVO);
			RequestDispatcher rd=request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response); //-----------------------------------▲
			
		}else if(command.equals("/memberUpdate.do")) {
			
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
			if(cnt>0) {
			    	// 가입성공		        
			    	response.sendRedirect("/MVC04/memberList.do");
			 }else {
			    	// 가입실패-> 예외객체를 만들어서  WAS에게 던지자.
			    	throw new ServletException("not update");	    	
			 }
			
		}else if(command.equals("/memberDelete.do")) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			int cnt = 0;
			cnt = dao.memberDelete(num);
			if (cnt > 0) {
				response.sendRedirect("/MVC04/memberList.do");
			} else {
				throw new ServletException("not delete");
			}
			
		}
	}

}
