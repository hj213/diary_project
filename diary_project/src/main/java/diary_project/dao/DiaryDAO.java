package diary_project.dao;

import java.util.List;

import diary_project.model.Diary;

public interface DiaryDAO {
	public Diary getOneDiary(int id);
	public List<Diary> getAllDiary(String userId);
	public void write(Diary diary);
	public void delete(int id);
	public void update(Diary diary);
}
