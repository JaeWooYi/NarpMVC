package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MyCalc;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트에서 넘어오는 form	 파라미터를 받는다(파라미터 수집) -> su.html에 name태그 su1, su2를 받자 
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		// 2. su1과 su2의 합을 구해보자.
		// 이부분(비지니스로직)을 모델로 빼보자
//		int sum = 0;	// 초기화
//		for(int i = su1; i <= su2; i++) {
//			sum += i;
//		}
	
		//int sum = su1 + su2;
		
		MyCalc myCalc = new MyCalc();
		int sum = myCalc.hap(su1, su2);
		
		// 응답하는 부분(프리젠테이션로직 = View = JSP)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("total = " + sum);
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
