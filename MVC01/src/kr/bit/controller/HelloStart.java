package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 순서 
		// 1. controller -> 클라이언트한테 요청을 받음(파라미터 수집) -> (servlet)
		// 2. 처리하는 작업(비지니스 로직) -> Model(Java class)
		int sum = 0;
		for(int i = 0; i < 101; i++) {
			sum += i;
		}
		// 3. 요청한 클라이언트에게 응답을 하는 부분 -> 프리젠테이션 로직 -> view(Jsp)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<H1>"+ sum +"</H1>");
		out.println("</body>");
		out.println("</html>");
		
		// servlet과 model만 가지고 회원관리를 한번 만들어보자 
	}

}
