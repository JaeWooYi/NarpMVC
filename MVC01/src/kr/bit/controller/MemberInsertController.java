package kr.bit.controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberVO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 수집(VO)
		// MemberRegister.html에 form안에 name태그들(파라미터) -> id, pass, name ....
		// 위 파라미터들 : HttpServletRequest request의 request에 담아져 있음
		// 이걸 VO에 묶어주는 작업을 지금 할거
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// VO로 묶어주는 작업
//		MemberVO memberVO = new MemberVO(id, pass, name, age, email, phone);
//		/* 위 방법으로 안하고
		MemberVO memberVO = new MemberVO(); //로 하면 아래처럼 셋을 다해줘야
		memberVO.setId(id);
		memberVO.setAge(age);
		memberVO.setPass(pass);
		memberVO.setName(name);
		memberVO.setEmail(email);
		memberVO.setPhone(phone);
//		*/
		
		// 이제 VO를 Model인 DAO에 넘겨서 member insert method를만들어서 mysql에insert를 해보자 
		// 일단은 화면 UI를 만들자.
		// 일단 잘 나오는지 테스트
		System.out.println(memberVO);	// memberVO.toString이 생략되어있는거야 톰캣콘솔에 수집이 되었는지 한번 보자.
	}
}
