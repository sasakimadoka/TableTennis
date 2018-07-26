package beans;

public class User {
	private String userId = null;
	private String userPassword = null;
	private  int userRole = 1;
	private String userName = null;
	private int userActivate = 1;

	public User() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public User(String userId, String userPassword, int userRole, String userName, int userActivate) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userName = userName;
		this.userActivate = userActivate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserActivate() {
		return userActivate;
	}
	public void setUserActivate(int userActivate) {
		this.userActivate = userActivate;
	}
}