package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

// 6개의 POJO가 해야할 일을 1개의 POJO로 바꿈
// controller에 MemberController 제외하고 다 지워도 된다 이제
public class MemberController{

	// MemberContentController
	@RequestMapping("/memberContent.do")	// 기존의 HandlerMapping이 이거로 바뀌는거야 
	public String memberContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao=new MemberDAO();
		MemberVO paramVO=dao.memberContent(num);
		
		// 객체바인딩
		request.setAttribute("paramVO", paramVO);
		
		//return "/WEB-INF/member/memberContent.jsp";
		return "memberContent";
	}
	
	// MememberDeleteController
	@RequestMapping("/memberDelete.do")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = 0;
		cnt = dao.memberDelete(num);
		String nextPage = null;
		if (cnt > 0) {
			nextPage = "redirect:"+ ctx +"/memberList.do";
		} else {
			throw new ServletException("not delete");
		}
		
		return nextPage;
	}
	
	// MemberInsertController
	@RequestMapping("/memberInsert.do")
	public String memberInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
		// 1-insert. 파라메터수집(VO)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); // "40"->40
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// 2-insert. 파라메터수집(VO)
		// MemberVO vo=new MemberVO(id, pass, name, age, email, phone);
		MemberVO paramVO = new MemberVO();
		paramVO.setId(id);
		paramVO.setPass(pass);
		paramVO.setName(name);
		paramVO.setAge(age);
		paramVO.setEmail(email);
		paramVO.setPhone(phone);

		// Model과 연동부분
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(paramVO);
		String nextPage = null;
		if (cnt > 0) {
			// 가입성공
			// out.println("insert success"); // 다시 회원리스트 보기로 가야된다.(/MVC04/memberList.do)
			nextPage = "redirect:"+ctx+"/memberList.do";
		} else {
			// 가입실패-> 예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");
		}

		return nextPage;
	}
	
	// MemberListController
	@RequestMapping("/memberList.do")
	public String memberList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. MODEL연동
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 최종적으로는 list를 member/memberList.jsp에다가 줘야한
		// 2. 객체 바인딩
		request.setAttribute("list", list);
		
		// 3. View page의 정보
		// 다음페이지는 
		//		return "/WEB-INF/member/memberList.jsp";	// requestHandler의 type이 void가 아니라 String으로 가야겠지?
		return "memberList";	// requestHandler의 type이 void가 아니라 String으로 가야겠지?
	}
	
	// MemberRegisterController
	@RequestMapping("/memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//return "/WEB-INF/member/memberRegister.jsp";
		return "memberRegister";
	}
	
	// MemberUpdateController
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
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
		String nextPage = null;
		if(cnt>0) {
		    	// 수정성공		        
		    	nextPage = "redirect:"+ctx+"/memberList.do";
		 }else {
		    	// 가입실패-> 예외객체를 만들어서  WAS에게 던지자.
		    	throw new ServletException("not update");	    	
		 }
		
		return nextPage;
	}
}
