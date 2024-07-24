package diary_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.model.Diary;
import diary_project.service.DiaryService;
import diary_project.service.DiaryServiceImpl;

@WebServlet("/write")
public class WriteServlet  extends HttpServlet {
	
	DiaryService diaryService = new DiaryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//만약에 패스에 따라서 수정하기면 기존 내용 가져오기 띄우기
		int id = 0; 
		if(req.getParameter("id") != null) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		if(id > 0){
			HttpSession session = req.getSession(false);
		} 
		req.getRequestDispatcher("/WEB-INF/views/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//패스에 따라서 다르게 설정
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		
		int id = 0;
		
		if(req.getParameter("id") != null) {
			
			id = Integer.parseInt(req.getParameter("id"));
		} 
		
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
	
		
		if(id > 0) {
			Diary diary = new Diary(id, (String) session.getAttribute("userId"), title, content );
			diaryService.update(diary);
			System.out.println("수정완료");
		} else {
			
			Diary diary = new Diary((String) session.getAttribute("userId"), title, content );
			diaryService.write(diary);
			System.out.println("작성완료");
		}
			
		out.println("<script>");
	    out.println("alert('글 작성 완료!');");
	    out.println("window.location.href = '" + req.getContextPath() + "/main';");
	    out.println("</script>");
	    out.close();
			
	}
}
