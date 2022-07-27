package kr.inflearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping("/list.do")
	public String list(Model model) {
		
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list); // 객체 바인딩
		
		return "boardList";
	}
	
	// Get방식일때
	// @GetMapping("/register.do") -> 상위 버전이면 해당 어노테이션을 쓸 수 있다.
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public String registerGet() {
		
		return "register";	// register.jsp -> 게시물 등록 화면
	}
	
	// Post방식일때 -> 게시물 등록!
	// @PostMapping("/register.do") -> 상위 버전이면 해당 어노테이션을 쓸 수 있다.
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerPost(BoardVO boardVO) {
		service.register(boardVO);	// 게시물 등록
		return "redirect:/list.do";	// 성공하면 게시판리스트로!
	}
	
	@RequestMapping("/get.do")
	public String get(@RequestParam("bno") int bno, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
		return "get";	// get.jsp
	}
	
}

/*
 * list.do ---> GET ---> list()
 * register.do ---> POST ---> register()
 * read.do ---> GET ---> read()
 * remove.do ---> GET ---> remove()
 * modify.do ---> POST ---> modify() 
 */