package emp.model;

import java.util.List;

public class UpdateTaskBean {
	private List<NewTasksBean> tasksList;

	public List<NewTasksBean> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<NewTasksBean> tasksList) {
		this.tasksList = tasksList;
	}

	@Override
	public String toString() {
		return "UpdateTaskBean [tasksList=" + tasksList + "]";
	}

	public UpdateTaskBean(List<NewTasksBean> tasksList) {
		super();
		this.tasksList = tasksList;
	}

	public UpdateTaskBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
