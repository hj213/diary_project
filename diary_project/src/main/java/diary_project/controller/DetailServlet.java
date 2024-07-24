package diary_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.model.Diary;
import diary_project.service.DiaryService;
import diary_project.service.DiaryServiceImpl;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	
	DiaryService diaryService = new DiaryServiceImpl();
	HttpSession session = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		int diaryId = Integer.parseInt(req.getParameter("diaryId"));
		
		Diary diary = diaryService.getOneDiary(diaryId);
		
		session.setAttribute("diaryTitle", diary.getTitle());
		session.setAttribute("diaryContent", diary.getContent());
		session.setAttribute("diaryId", diary.getId());
		session.setAttribute("diaryDate", diary.getDate());
		
		req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("action");
		int diaryId = Integer.parseInt(req.getParameter("diaryId"));
		if(value.equals("delete")) {
			diaryService.delete(diaryId);
			resp.sendRedirect("main");
		} 
	}
}
