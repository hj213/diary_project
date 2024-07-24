package diary_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.model.User;
import diary_project.service.UserService;
import diary_project.service.UserServiceImpl;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	String userId;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션 객체 가져오기
        HttpSession session = req.getSession(false);
        // 세션에서 데이터 읽기
        userId = (String) session.getAttribute("userId");
        User user = userService.getUserInfo(userId);
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("phone", user.getPhone());
        
        req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 임시 사용
		// 세션을 통하여 기존 회원 정보를 가져옴.
		User user = userService.getUserInfo(userId);
		String action = req.getParameter("action");
		
		if("회원수정".equals(action)) {
			//입력창 입력을 통하여 수정할 정보를 파라미터로 가져옴 (id 제외)
			String username = req.getParameter("username");
			String pwd = req.getParameter("password");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			//수정
			User updatedUser = new User(userId, username, pwd, phone, email);
			userService.userUpdate(updatedUser);
			System.out.println("유저정보 수정 완료.");
			resp.sendRedirect("main");
		} else if ("회원탈퇴".equals(action)) {
			//탈퇴
			userService.userDelete(userId);
			System.out.println("유저 삭제 완료.");
			resp.sendRedirect("login");
			req.getSession().invalidate();
			
		} else if ("로그아웃".equals(action)) {
			System.out.println("로그아웃");
			req.getSession().invalidate();
			resp.sendRedirect("login");
			
		}
		
		
		
		
		
		
		
		
	}
	
}
