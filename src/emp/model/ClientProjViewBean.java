package emp.model;


import java.util.List;

public class ClientProjViewBean {
	private int projectId;
	private String projectName;
	private String startDate;
	private String endDate;
	private int resources;
	private Double budget;
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
	public int getResources() {
		return resources;
	}
	public void setResources(int resources) {
		this.resources = resources;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Override
	public String toString() {
		return "ClientProjViewBean [projectId=" + projectId + ", projectName="
				+ projectName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", resources=" + resources + ", budget=" + budget
				+ ", clientName=" + clientName + "]";
	}
	public ClientProjViewBean(int projectId, String projectName,
			String startDate, String endDate, int resources, Double budget,
			String clientName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resources = resources;
		this.budget = budget;
		this.clientName = clientName;
	}
	public ClientProjViewBean() {
		super();
	}
	
	
}
