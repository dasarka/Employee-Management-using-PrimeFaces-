package emp.model;

import java.util.ArrayList;
import java.util.List;

public class Timecard {
	private int timecardId;
	private String week_val;
	private int[] project_id;
	private String projectNames;
	private int user_id;
	private int day_mon;
	private int day_tue;
	private int day_wed;
	private int day_thu;
	private int day_fri;
	private boolean disable_mon;
	private boolean disable_tue;
	private boolean disable_wed;
	private boolean disable_thu;
	private boolean disable_fri;
	private String submittionDate;
	private String status;
	private String comment;
	private List<ProjectBean> projectList=new ArrayList<ProjectBean>();
	
	public String getWeek_val() {
		return week_val;
	}
	public void setWeek_val(String week_val) {
		this.week_val = week_val;
	}
	public int[] getProject_id() {
		return project_id;
	}
	public void setProject_id(int[] project_id) {
		this.project_id = project_id;
	}
	
	public String getProjectNames() {
		return projectNames;
	}
	public void setProjectNames(String projectNames) {
		this.projectNames = projectNames;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDay_mon() {
		return day_mon;
	}
	public void setDay_mon(int day_mon) {
		this.day_mon = day_mon;
	}
	public int getDay_tue() {
		return day_tue;
	}
	public void setDay_tue(int day_tue) {
		this.day_tue = day_tue;
	}
	public int getDay_wed() {
		return day_wed;
	}
	public void setDay_wed(int day_wed) {
		this.day_wed = day_wed;
	}
	public int getDay_thu() {
		return day_thu;
	}
	public void setDay_thu(int day_thu) {
		this.day_thu = day_thu;
	}
	public int getDay_fri() {
		return day_fri;
	}
	public void setDay_fri(int day_fri) {
		this.day_fri = day_fri;
	}
	public boolean isDisable_mon() {
		return disable_mon;
	}
	public void setDisable_mon(boolean disable_mon) {
		this.disable_mon = disable_mon;
	}
	public boolean isDisable_tue() {
		return disable_tue;
	}
	public void setDisable_tue(boolean disable_tue) {
		this.disable_tue = disable_tue;
	}
	public boolean isDisable_wed() {
		return disable_wed;
	}
	public void setDisable_wed(boolean disable_wed) {
		this.disable_wed = disable_wed;
	}
	public boolean isDisable_thu() {
		return disable_thu;
	}
	public void setDisable_thu(boolean disable_thu) {
		this.disable_thu = disable_thu;
	}
	public boolean isDisable_fri() {
		return disable_fri;
	}
	public void setDisable_fri(boolean disable_fri) {
		this.disable_fri = disable_fri;
	}
	public String getSubmittionDate() {
		return submittionDate;
	}
	public void setSubmittionDate(String submittionDate) {
		this.submittionDate = submittionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public int getTimecardId() {
		return timecardId;
	}
	public void setTimecardId(int timecardId) {
		this.timecardId = timecardId;
	}
	@Override
	public String toString() {
		return "Timecard [week_val=" + week_val + ", project_id=" + project_id
				+ ", user_id=" + user_id + ", day_mon=" + day_mon
				+ ", day_tue=" + day_tue + ", day_wed=" + day_wed
				+ ", day_thu=" + day_thu + ", day_fri=" + day_fri
				+ ", disable_mon=" + disable_mon + ", disable_tue="
				+ disable_tue + ", disable_wed=" + disable_wed
				+ ", disable_thu=" + disable_thu + ", disable_fri="
				+ disable_fri + ", submittionDate=" + submittionDate
				+ ", status=" + status + ", comment=" + comment
				+ ", projectList=" + projectList + "]";
	}
	public List<ProjectBean> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ProjectBean> projectList) {
		this.projectList = projectList;
	}
	public Timecard(String week_val, int[] project_id, int user_id, int day_mon,
			int day_tue, int day_wed, int day_thu, int day_fri,
			boolean disable_mon, boolean disable_tue, boolean disable_wed,
			boolean disable_thu, boolean disable_fri, List<ProjectBean> projectList) {
		super();
		this.week_val = week_val;
		this.project_id = project_id;
		this.user_id = user_id;
		this.day_mon = day_mon;
		this.day_tue = day_tue;
		this.day_wed = day_wed;
		this.day_thu = day_thu;
		this.day_fri = day_fri;
		this.disable_mon = disable_mon;
		this.disable_tue = disable_tue;
		this.disable_wed = disable_wed;
		this.disable_thu = disable_thu;
		this.disable_fri = disable_fri;
		this.projectList = projectList;
	}
	public Timecard(int timecardId, String week_val, String projectNames,
			int user_id, int day_mon, int day_tue, int day_wed, int day_thu,
			int day_fri, String submittionDate, String status, String comment) {
		super();
		this.timecardId = timecardId;
		this.week_val = week_val;
		this.projectNames = projectNames;
		this.user_id = user_id;
		this.day_mon = day_mon;
		this.day_tue = day_tue;
		this.day_wed = day_wed;
		this.day_thu = day_thu;
		this.day_fri = day_fri;
		this.submittionDate = submittionDate;
		this.status = status;
		this.comment = comment;
	}
	
	
	
	
}
