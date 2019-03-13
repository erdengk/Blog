package User;


import Db.DBBean;
public class UserBlog extends User{
	private String username;

	private String title ;
	private String txt ;
	public String getTitle() {
		return title;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTxt() {
		return txt;
	}
	public String toString() {
		return "UserBlog [title=" + title + ", txt=" + txt + "]";
	}
	public void setTxt(String txt) {
		this.txt = txt;
	
	} 
	

}
