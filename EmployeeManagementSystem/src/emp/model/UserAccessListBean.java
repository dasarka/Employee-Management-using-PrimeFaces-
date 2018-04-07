package emp.model;

import java.util.List;

public class UserAccessListBean {
	private List<UsersBean> usersList;
	private List<AccessBean> accessList;
	private int selectedUserId=0;
	private int selectedAccessId=1;
	private String empDesg;
	private String currAccess;

	public List<UsersBean> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UsersBean> usersList) {
		this.usersList = usersList;
	}

	public List<AccessBean> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<AccessBean> accessList) {
		this.accessList = accessList;
	}

	public int getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(int selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public int getSelectedAccessId() {
		return selectedAccessId;
	}

	public void setSelectedAccessId(int selectedAccessId) {
		this.selectedAccessId = selectedAccessId;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	@Override
	public String toString() {
		return "UserAccessListBean [usersList=" + usersList + ", accessList="
				+ accessList + ", selectedUserId=" + selectedUserId
				+ ", selectedAccessId=" + selectedAccessId + "]";
	}

	public UserAccessListBean(List<UsersBean> usersList,
			List<AccessBean> accessList, int selectedUserId,
			int selectedAccessId) {
		super();
		this.usersList = usersList;
		this.accessList = accessList;
		this.selectedUserId = selectedUserId;
		this.selectedAccessId = selectedAccessId;
	}

	public UserAccessListBean() {
		super();
	}

	public String getCurrAccess() {
		return currAccess;
	}

	public void setCurrAccess(String currAccess) {
		this.currAccess = currAccess;
	}

	

}
