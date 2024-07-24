package diary_project.service;

import java.util.List;

import diary_project.dao.UserDAO;
import diary_project.dao.UserDAOImpl;
import diary_project.model.User;

public class UserServiceImpl implements UserService {
	UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public User authenticate(String userId, String password) {
		User user = userDAO.getUserInfo(userId);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public void userRegister(User user) {
		userDAO.save(user);
	
	}

	@Override
	public User getUserInfo(String userId) {
		return userDAO.getUserInfo(userId);
	}

	@Override
	public List<User> getAllUserInfo() {
		return userDAO.getAllUsers();
	}

	@Override
	public void userDelete(String userId) {
		userDAO.delete(userId);
	}

	@Override
	public void userUpdate(User user) {
		userDAO.update(user);
	}

	
    @Override
    public int userDuplicateCheck(String idCheck) {
        return userDAO.duplicateCheck(idCheck);
    }
    
    @Override
	public int userEmailDuplicateCheck(String emailCheck) {
		return userDAO.emailDuplicateCheck(emailCheck);
	}
}
