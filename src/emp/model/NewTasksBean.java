package emp.model;

public class NewTasksBean {
	private int taskId;
	private String taskName;
	private int resourceId=-1;
	private String resourceName;
	private String description;
	private String endDate;
	private int projcetId;
	private int taskStatus = 0;

	
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getProjcetId() {
		return projcetId;
	}

	public void setProjcetId(int projcetId) {
		this.projcetId = projcetId;
	}

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "NewTasks [taskName=" + taskName + ", resourceId=" + resourceId
				+ ", description=" + description + ", endDate=" + endDate
				+ ", projcetId=" + projcetId + ", taskStatus=" + taskStatus
				+ "]";
	}

	public NewTasksBean(String taskName, int resourceId, String description,
			String endDate, int projcetId, int taskStatus) {
		super();
		this.taskName = taskName;
		this.resourceId = resourceId;
		this.description = description;
		this.endDate = endDate;
		this.projcetId = projcetId;
		this.taskStatus = taskStatus;
	}

	
	public NewTasksBean(int taskId, String taskName, String resourceName,
			String description, String endDate, int taskStatus) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.resourceName = resourceName;
		this.description = description;
		this.endDate = endDate;
		this.taskStatus = taskStatus;
	}

	public NewTasksBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
