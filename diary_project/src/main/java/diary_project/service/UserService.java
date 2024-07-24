package diary_project.service;

import java.util.List;

import diary_project.model.User;

public interface UserService {
	public User authenticate(String userId, String password); //로그인 인증(아이디, 비번)
	public void userRegister(User user); //회원가입
	public User getUserInfo(String userId);
	public List<User> getAllUserInfo();
	public void userDelete(String userId);
	public void userUpdate(User user);
    public int userDuplicateCheck(String idCheck);
    public int userEmailDuplicateCheck(String emailCheck);

}
