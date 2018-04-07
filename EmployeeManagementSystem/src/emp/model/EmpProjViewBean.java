package emp.model;

import java.util.Map;

public class EmpProjViewBean {
	private int projectId;
	private String projectName;
	private String startDate;
	private String endDate;
	private Double progress;
	private String onsiteManagerName;
	private String clientName;
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
	
	

	public Double getProgress() {
		return progress;
	}
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
	public String getOnsiteManagerName() {
		return onsiteManagerName;
	}
	public void setOnsiteManagerName(String onsiteManagerName) {
		this.onsiteManagerName = onsiteManagerName;
	}
	
	public EmpProjViewBean(int projectId, String projectName, String startDate,
			String endDate, String onsiteManagerName,
			String clientName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onsiteManagerName = onsiteManagerName;
		this.clientName = clientName;
	}
	
	public EmpProjViewBean(int projectId, String projectName, String startDate,
			String endDate, Double progress, String onsiteManagerName,
			String clientName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.progress = progress;
		this.onsiteManagerName = onsiteManagerName;
		this.clientName = clientName;
	}
	@Override
	public String toString() {
		return "EmpProjViewBean [projectId=" + projectId + ", projectName="
				+ projectName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", progress=" + progress + ", onsiteManagerName="
				+ onsiteManagerName + ", clientName=" + clientName + "]";
	}
	public EmpProjViewBean() {
		super();
	}
	
}
