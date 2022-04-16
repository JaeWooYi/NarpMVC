 package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. forward 실습 
		int su = 100;
		String data = "apple";
		String name = "kkk";
		int age = 14;
		String email = "kkk@kkk.com";
		// 2. view(result.jsp)로 data 전달하여 View page에서 출력
		// Controller에서 View로 전환하는 방
		// 1) redirect
		// 2) forward
//		request.setAttribute("data", data);	// 객체바인딩(request바인딩)
//		response.sendRedirect("view/result.jsp?data=" + data);
		response.sendRedirect("view/result.jsp?name=" + name + "&age=" +age + "&email=" + email);
	}

}
