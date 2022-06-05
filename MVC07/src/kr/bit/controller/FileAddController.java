package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileAddController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String UPLOAD_DIR="file_repo";								   // File.separator -> 운영체제에 맞게 물리적 경로 잡아줌
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File currentDirPath = new File(uploadPath);	// 업로드할 경로를 File객체로 만들기 
		if(!currentDirPath.exists()) {
			currentDirPath.mkdir();
		}
		// 파일을 업로드 할때 먼저 저장될 임시 저장경로를 설정 -> Class가 있대 (  DiskFileItemFactory  )
		// file upload시 필요한 API다운받아보자. -> commons-fileupload, commons-io 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);	// 어디에 저장할래?
		factory.setSizeThreshold(1024*1024);// 용량은 어떻게 할래?
		
		String fileName = null;
		
		// request에서 데이터를 좀더 쉽게 꺼내기위해 사용하는 클래스가 있다. -> ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {	// items안에는 파일 정보들이 배열처럼 들어가 있음 -> [],[],[]..  ([] 하나를 fileItem이라고 부름) 
			List<FileItem> items = upload.parseRequest(request);	// parseRequest : 파일정보를 쉽게 읽어올수있게 하는 메서드 
		//	request안에 여러개의 파일이 업로드된경우를 고려한거다.
			for(int i = 0; i < items.size(); i++) {
				FileItem fileItem = items.get(i);	// List<FileItem> 했으므로 다운캐스팅 필요 없다
				if(fileItem.isFormField()) {	// 폼필드이면
					System.out.println(fileItem.getFieldName() + "====" + fileItem.getString("utf-8"));
				}else {	// 파일이면 
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");	/* (\\ : window운영체제일때 경로),  (/ : 리눅스일때 경로) */
						if(idx==-1) {
							fileItem.getName().lastIndexOf("/");
						}
						fileName = fileItem.getName().substring(idx + 1);	// 실제 파일이름이 가져와 진다 // +1 :  가장 마지막 파일이름을 가져오기 위해서
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						
						// 파일 중복체크 
						if(uploadFile.exists()) {
							fileName = System.currentTimeMillis() + "_" + fileName;
							uploadFile = new File(currentDirPath + "\\" + fileName);
						}
						fileItem.write(uploadFile);		// 임시 경로에서 새로운 경로에 파일을 write(쓴다) 한다.
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		// $.ajax()쪽으로 최종 업로드된 파일이름을 전송시켜준다.
		response.setContentType("text/html;charset=euc-kr");
		response.getWriter().print(fileName);
		
		return null;
	}

}
