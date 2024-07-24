package diary_project.model;

public class Diary {
	private String userId;
	private String title;
	private String content;
	private String date;
	private int id;
	
	
	Diary(){}
	
	public Diary(String userId, String title, String content){
		
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	public Diary(int id, String userId, String title, String content){
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}


	public Diary(int id, String userId, String title, String content, String date) {
		super();
		this.id= id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.date = date;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	};
	
	
	
	
}
