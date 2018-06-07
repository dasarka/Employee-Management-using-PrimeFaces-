package emp.model;

import java.util.Date;

public class LMSBean {
	private String startDate;
	private String endDate;
	private Date startDateUtil;
	private Date endDateUtil;
	private String comments;
	private int leaveCount;
	private String status;
	private String empName;
	private int userId;
	private int leaveId;
	private Date minStartDate=new Date();
	private Date minEndDate=new Date();
	 
	
	
	public Date getMinStartDate() {
		return minStartDate;
	}
	public void setMinStartDate(Date minStartDate) {
		this.minStartDate = minStartDate;
	}
	
	public Date getMinEndDate() {
		return minEndDate;
	}
	public void setMinEndDate(Date minEndDate) {
		this.minEndDate = minEndDate;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getStartDateUtil() {
		return startDateUtil;
	}
	public void setStartDateUtil(Date startDateUtil) {
		this.startDateUtil = startDateUtil;
	}
	public Date getEndDateUtil() {
		return endDateUtil;
	}
	public void setEndDateUtil(Date endDateUtil) {
		this.endDateUtil = endDateUtil;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LMSBean(String startDate, String endDate, String comments,
			int leaveCount, String status) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.leaveCount = leaveCount;
		this.status = status;
	}
	
	
	
	
	public LMSBean(String startDate, String endDate, String comments,
			int leaveCount, String empName, int userId, int leaveId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.leaveCount = leaveCount;
		this.empName = empName;
		this.userId = userId;
		this.leaveId = leaveId;
	}
	public LMSBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LMSBean [startDate=" + startDate + ", endDate=" + endDate
				+ ", startDateUtil=" + startDateUtil + ", endDateUtil="
				+ endDateUtil + ", comments=" + comments + ", leaveCount="
				+ leaveCount + ", status=" + status + ", empName=" + empName
				+ ", userId=" + userId + ", leaveId=" + leaveId + "]";
	}
	
	
	
}
