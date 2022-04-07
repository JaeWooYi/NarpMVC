package kr.web.controller;
//JavaEE환경 -> 기본프로그램 : Servlet의 골격 -> 쓰려면 상속을 받아야한다.
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import kr.web.util.MyUtil;

@WebServlet("/hs.do")	// web.xml에 쓰는거보다 어노테이션이 훨씬 편하지? (web.xml에 해당내용 주석처리)
public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1 ~ 100 까지의 합을 구해보자..
		MyUtil myUtil = new MyUtil();
		int sum = myUtil.hap();
		
		// 위 사항을 요청한 클라이언트에게 응답을 해야함.
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + sum + "<h1>");
		out.println("</body>");
		out.println("</html>");
		
		// 서버 실행하고 http://172.16.100.21:8080/web/WEB-INF/classes/kr.web.controller.HelloServlet 경로들어가 봐 404오류 나 
		// url에 정보가 다 나오자나. 보안에 취약해. 이거를 hs.do로 매핑을 해서 실행해보자
		// WEB-INF/classes/kr.web.controller.HelloServlet -> 가짜이름 hs.do로 매 (servlet-mapping)
		// 이런 매핑을 해주는 파일이 하나 있어. 바로 web.xml 파일이
	}
}

//