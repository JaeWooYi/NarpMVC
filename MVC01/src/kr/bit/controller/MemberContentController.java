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

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = memberDAO.memberContent(num);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form action='/MVC01/memberUpdate.do' method='post'>");
		out.println("<input type='hidden' name='num' value='"+memberVO.getNum()+"' />");
		
		out.println("<table class='table table-bordered'>");
		if(memberVO != null) {
			out.println("<tr>");
			out.println("<td colspan='2'>"+ memberVO.getName() +"의 상세보기</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>"+ memberVO.getNum() +"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>아이디</td>");
			out.println("<td>"+ memberVO.getId() +"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>비밀번호</td>");
			out.println("<td>"+ memberVO.getPass() +"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>이름</td>");
			out.println("<td>"+ memberVO.getName() +"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>나이</td>");
			out.println("<td><input type='text' name='age' value='"+memberVO.getAge()+"'/></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td><input type='text' name='email' value='"+memberVO.getEmail()+"'/></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>전화번호</td>");
			out.println("<td><input type='text' name='phone' value='"+memberVO.getPhone()+"'/></td>");
			out.println("</tr>");
		}else {
			out.println("<tr>");
			out.println("<td>일치하는 회원이 없습니다.</td>");
			out.println("</tr>");
		}
		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='수정하기' class='btn btn-primary'/>");
		out.println("<input type='reset' value='취소' class='btn btn-warning'/>");
		out.println("<a href='/MVC01/memberList.do'>리스트로</a>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<form>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
