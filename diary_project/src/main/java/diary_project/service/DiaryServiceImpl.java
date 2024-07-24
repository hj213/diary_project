package diary_project.service;

import java.util.List;

import diary_project.dao.DiaryDAO;
import diary_project.dao.DiaryDAOImpl;
import diary_project.model.Diary;

public class DiaryServiceImpl implements DiaryService{
	
	DiaryDAO diaryDAO = new DiaryDAOImpl();

	@Override
	public Diary getOneDiary(int id) {
		return diaryDAO.getOneDiary(id);
	}

	@Override
	public List<Diary> getAllDiary(String userId) {
		return diaryDAO.getAllDiary(userId);
	}

	@Override
	public void write(Diary diary) {
		diaryDAO.write(diary);
	}

	@Override
	public void delete(int id) {
		diaryDAO.delete(id);
	}

	@Override
	public void update(Diary diary) {
		diaryDAO.update(diary);
	}

}
