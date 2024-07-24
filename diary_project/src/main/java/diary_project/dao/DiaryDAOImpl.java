package diary_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import diary_project.model.Diary;
import diary_project.util.DBUtil;

public class DiaryDAOImpl implements DiaryDAO {
	
	public Diary getOneDiary(int id) {
		Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_diary WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	return new Diary(
            			rs.getInt("id"),
            			rs.getString("user_id"),
            			rs.getString("title"),
            			rs.getString("content"),
            			rs.getString("diary_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;

		
	}
	
	
	public List<Diary> getAllDiary(String usreId) {
		Connection conn = null;
		List<Diary> diary = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_diary WHERE user_id=?");
            stmt.setString(1, usreId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	diary.add(new Diary(
            			rs.getInt("id"),
            			rs.getString("user_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("diary_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
		return diary;
		
	}
	public void write(Diary diary) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO user_diary (user_id, title, content) "
							+ "VALUES (?, ?, ?)");
			stmt.setString(1, diary.getUserId());
			stmt.setString(2, diary.getTitle());
			stmt.setString(3, diary.getContent());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_diary WHERE id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	public void update(Diary diary) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE user_diary SET title = ?, content = ? WHERE id = ? ");
			stmt.setString(1, diary.getTitle());
			stmt.setString(2, diary.getContent());
			stmt.setInt(3, diary.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);

		}
	}
}