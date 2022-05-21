package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx=request.getContextPath();	// ctx(컨텍스트)의 값은 06이겠지?
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPass(password);
		
		MemberDAO dao = new MemberDAO();
		
		String user_name = dao.memberLogin(vo);
		// user_name에 값이 있으면 인증에 성공한 것이고, user_name에 값이 없으면 회원 인증이 실패한 것.
		// 즉, 아래 if문은 로그인이 성공했을 때와 로그인이 실패했을때를 나누어 처리한 것
		if(user_name != null && !"".equals(user_name)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user_id);
			session.setAttribute("userName", user_name);
			// 성공했을때	- 위랑 아래랑 같아(이전에는 저렇게 했었지
//			request.getSession().setAttribute("user_id", user_id);	// 객체 바인딩 
//			request.getSession().setAttribute("user_name", user_name);	// 객체 바인딩	- 하나만 해도 되는데 다른데서 또 쓸수도 있으니까 
		}else {
			// 실패했을때
			request.getSession().setAttribute("user_id", "");		// null 처리
			request.getSession().setAttribute("user_name", "");
			request.getSession().setAttribute("msg", "사용자 정보가 올바르지 않습니다");
		}
		
		return "redirect:"+ctx+"/memberList.do";
	}

}
