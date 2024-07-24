package diary_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.dao.UserDAO;
import diary_project.dao.UserDAOImpl;
import diary_project.model.User;
import diary_project.service.UserService;
import diary_project.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	UserDAO userDAO = new UserDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			resp.sendRedirect("main");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String userId = req.getParameter("userId");
		String pwd = req.getParameter("password");
		User user = userService.authenticate(userId, pwd);
		
		
		if( user != null) {
			HttpSession session = req.getSession();
			System.out.println("로그인 성공!");
			session.setAttribute("userId", userId);
			session.setAttribute("username", user.getUsername());
			
			resp.sendRedirect("main");
			//세션 추가 
		} else {
			System.out.println("로그인 실패!");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
            out.println("alert('❌ 로그인 실패 ❌');");
            out.println("window.location.href = '" + req.getContextPath() + "/login';");
            out.println("</script>");
			
		}
	}
}
