package diary_project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.model.Diary;
import diary_project.service.DiaryService;
import diary_project.service.DiaryServiceImpl;
import diary_project.service.UserService;
import diary_project.service.UserServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	UserService userService = new UserServiceImpl();
	DiaryService diaryService = new DiaryServiceImpl();
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        
        if(session == null) {
        	System.out.println("세션 없음");
        	resp.sendRedirect("login");
        } else {
        	String userId = (String) session.getAttribute("userId");
            String username = (String) session.getAttribute("username");
        	
            List<Diary> allDiary = diaryService.getAllDiary(userId);
            session.setAttribute("allDiary", allDiary);
            
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
        }
        
        
  
    }
}