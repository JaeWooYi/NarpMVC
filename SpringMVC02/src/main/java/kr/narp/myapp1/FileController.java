package kr.narp.myapp1;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
		
		// parameter -> id, name
		Map map = new HashMap();	// HashMap에는 key, value 쌍으로 저장
//		String id = multipartRequest.getParameter("id");
//		String name = multipartRequest.getParameter("name");
//		System.out.println(id + ", " + name);
		
		// Enumeration -> 영어 : 나열, 열거
		Enumeration<String> e = multipartRequest.getParameterNames();
		System.out.println(e);
		
		return "";
	}
	
}
