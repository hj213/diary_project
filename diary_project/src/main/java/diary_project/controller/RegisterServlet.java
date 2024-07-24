package diary_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import diary_project.model.User;
import diary_project.service.UserService;
import diary_project.service.UserServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
		HttpSession session = req.getSession(false);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String userId = req.getParameter("userId");
		String pwd = req.getParameter("password");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");	
		
		
		User user = new User( userId, username, pwd, email, phone);
		
		//아이디 중복확인
        String idCheck = user.getUserId();
        String emailCheck = user.getEmail();
        //DB 내부에 중복된 userId가 있는지 확인하고, 없으면 가능하도록
        // int check가 0이면 중복 없음. 1이면 중복있음.
        int check =userService.userDuplicateCheck(idCheck);
        int eCheck =userService.userEmailDuplicateCheck(emailCheck);
        PrintWriter out = resp.getWriter();

        if(check == 0 && eCheck == 0) {
            userService.userRegister(user);
            System.out.println("회원가입 성공!");
            resp.sendRedirect("login");
        } else if  (check == 1 || eCheck == 1){
        	if(check == 1) {
        		System.out.println("회원가입 실패! 중복된 아이디");
        	}
        	
        	if(eCheck == 1) {
        		System.out.println("회원가입 실패! 중복된 이메일");
        	}
        	
			out.println("<script>");
            out.println("alert('❌ 회원가입 실패 ❌');");
            out.println("window.location.href = '" + req.getContextPath() + "/register';");
            out.println("</script>");
        }
		
	}
}
