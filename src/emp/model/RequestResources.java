package emp.model;

import java.util.List;

public class RequestResources {
	private int projectId;
	private String projectName;
	private String requestType;
	private int resourceCount;
	private List<UsersBean> userList;
	private List<UsersBean> selectedUsers;
	private List<Integer> selectedUsersWHs;
	private int selectedUserId;
	private int selectedUserWH;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public int getResourceCount() {
		return resourceCount;
	}
	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}
	
	public List<UsersBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UsersBean> userList) {
		this.userList = userList;
	}
	public List<UsersBean> getSelectedUsers() {
		return selectedUsers;
	}
	public void setSelectedUsers(List<UsersBean> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	public List<Integer> getSelectedUsersWHs() {
		return selectedUsersWHs;
	}
	public void setSelectedUsersWHs(List<Integer> selectedUsersWHs) {
		this.selectedUsersWHs = selectedUsersWHs;
	}
	public int getSelectedUserId() {
		return selectedUserId;
	}
	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}
	public int getSelectedUserWH() {
		return selectedUserWH;
	}
	public void setSelectedUserWH(int selectedUserWH) {
		this.selectedUserWH = selectedUserWH;
	}
	public RequestResources(int projectId, String projectName,
			String requestType, int resourceCount) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.requestType = requestType;
		this.resourceCount = resourceCount;
	}
	public RequestResources() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
