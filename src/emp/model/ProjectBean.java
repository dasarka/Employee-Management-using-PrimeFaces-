package emp.model;

public class ProjectBean {
	private int projectId;
	private String projectName;
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
	@Override
	public String toString() {
		return "ProjectBean [projectId=" + projectId + ", projectName="
				+ projectName + "]";
	}
	public ProjectBean(int projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}
	public ProjectBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
