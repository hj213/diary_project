package diary_project.dao;

import java.util.List;

import diary_project.model.User;

public interface UserDAO {
	public User getUserInfo(String userId);
	public List<User> getAllUsers();
	public void save(User user);
	public void delete(String userId);
	public void update(User user);
	public int duplicateCheck(String idCheck);
	public int emailDuplicateCheck(String emailCheck);

}
