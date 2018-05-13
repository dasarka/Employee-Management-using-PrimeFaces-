package emp.model;

public class UsersBean {
	private int userId;
	private String username;
	private String password;
	private String oldPassword;
	private String newPassword;
	private String empName;
	private String empDesg="Default";
	private String accessVal;
	private int remainHours;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	
	public String getAccessVal() {
		return accessVal;
	}
	public void setAccessVal(String accessVal) {
		this.accessVal = accessVal;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	public int getRemainHours() {
		return remainHours;
	}
	public void setRemainHours(int remainHours) {
		this.remainHours = remainHours;
	}
	
	
	@Override
	public String toString() {
		return "UsersBean [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + ", empName=" + empName
				+ ", empDesg=" + empDesg + ", accessVal=" + accessVal
				+ ", remainHours=" + remainHours + "]";
	}
	
	
	
	public UsersBean(int userId, String empName, String empDesg,
			String accessVal, int remainHours) {
		super();
		this.userId = userId;
		this.empName = empName;
		this.empDesg = empDesg;
		this.accessVal = accessVal;
		this.remainHours = remainHours;
	}
	
	public UsersBean(int userId, String username, String password,
			String empName, String empDesg) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.empName = empName;
		this.empDesg = empDesg;
	}
	public UsersBean(int userId, String username, String password,
			String empName, String empDesg, int remainHours) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.empName = empName;
		this.empDesg = empDesg;
		this.remainHours = remainHours;
	}
	public UsersBean() {
		super();
	}
	
}
