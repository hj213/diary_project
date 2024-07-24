package diary_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import diary_project.model.Diary;
import diary_project.model.User;
import diary_project.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User user) {

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO user_info (user_id, username, password, email, phone_number) "
							+ "VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPhone());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

	@Override
	public User getUserInfo(String userID) {

		Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_info WHERE user_id = ?");
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	return new User(rs.getString("user_id"),
            			rs.getString("username"),
            			rs.getString("password"),
            			rs.getString("email"),
            			rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }

		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user = new ArrayList<>();
		Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_info");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	user.add(new User(rs.getString("user_id"),
            			rs.getString("username"),
            			rs.getString("password"),
            			rs.getString("email"),
            			rs.getString("phone_number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return user;
        
	}

	@Override
	public void delete(String userId) {

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_info WHERE user_id = ?");
			stmt.setString(1, userId);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}

	}

	@Override
	public void update(User user) {

		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE user_info SET password = ?, email = ?, phone_number = ? WHERE user_id = ? ");
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPhone());
			stmt.setString(4, user.getUserId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);

		}
	}
	
	@Override
	public int duplicateCheck(String idCheck) {
		Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_info WHERE user_id = ?");
            stmt.setString(1, idCheck);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	return 1;
            } else {
            	return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return 0;
		
	}
	
	@Override
	public int emailDuplicateCheck(String emailCheck) {
		Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_info WHERE email = ?");
            stmt.setString(1, emailCheck);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	return 1;
            } else {
            	return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return 0;
	}

}