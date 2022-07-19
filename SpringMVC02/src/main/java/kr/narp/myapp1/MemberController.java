package kr.narp.myapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.mapper.MemberMapper;
import kr.bit.model.MemberVO;

// @ -> 어노테이션(전처리) -> Spring Container에서 관리를 해준다.
@Controller
public class MemberController {
	
	@Autowired
	//private MemberDAO dao;	// Dependency Injection 
	private MemberMapper memberMapper;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {	// HttpServletRequest -> Model와 일맥 상통한다.
		
		List<MemberVO> list = memberMapper.memberList();

		// 객체 바인딩
		model.addAttribute("list", list);
		
		return "memberList";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {	// 파라미터 수집(VO)
		
		// 인코딩 해줘야 한다.(한글깨짐 방지) - web.xml에 검색을 통해 해결! -- 주석 부분 : <!-- Character Encoding --> 
		
		int cnt = memberMapper.memberInsert(vo);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(int num) {	// 파라미터 수집 : num -> MemberVO vo로 해도 상관은 없다.
		
		int cnt = memberMapper.memberDelete(num);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberContent.do")
	public String memberContent(int num, Model model) {
		
		MemberVO vo = memberMapper.memberContent(num);
		
		// 객체 바인딩
		model.addAttribute("vo", vo);
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		
		int cnt = memberMapper.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
	
}
