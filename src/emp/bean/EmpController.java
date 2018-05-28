package emp.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import emp.model.*;
import emp.service.EmpService;
import emp.service.ResourceService;
import emp.serviceImpl.EmpServiceImpl;
import emp.serviceImpl.ResourceServiceImpl;

public class EmpController {
	private UsersBean usersBean = new UsersBean();
	private UsersBean newUserBean = new UsersBean();

	private UserAccessListBean userAccessListBean = new UserAccessListBean();
	private EmpProjListBean empProjListBean = new EmpProjListBean();
	private EmpResourceBean empResourceBean = new EmpResourceBean();
	private NewTasksBean newTaskBean = new NewTasksBean();
	private UpdateTaskBean updateTaskBean = new UpdateTaskBean();

	private int projectId;
	private int projectType;

	private Date minStartDate;
	private Date minEndDate;

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

	public NewTasksBean getNewTaskBean() {
		return newTaskBean;
	}

	public void setNewTaskBean(NewTasksBean newTaskBean) {
		this.newTaskBean = newTaskBean;
	}

	public UpdateTaskBean getUpdateTaskBean() {
		return updateTaskBean;
	}

	public void setUpdateTaskBean(UpdateTaskBean updateTaskBean) {
		this.updateTaskBean = updateTaskBean;
	}

	public EmpResourceBean getEmpResourceBean() {
		return empResourceBean;
	}

	public void setEmpResourceBean(EmpResourceBean empResourceBean) {
		this.empResourceBean = empResourceBean;
	}

	public EmpProjListBean getEmpProjListBean() {
		return empProjListBean;
	}

	public void setEmpProjListBean(EmpProjListBean empProjListBean) {
		this.empProjListBean = empProjListBean;
	}

	public UsersBean getUsersBean() {
		return usersBean;
	}

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}

	public UsersBean getNewUserBean() {
		return newUserBean;
	}

	public void setNewUserBean(UsersBean newUserBean) {
		this.newUserBean = newUserBean;
	}

	public UserAccessListBean getUserAccessListBean() {
		return userAccessListBean;
	}

	public void setUserAccessListBean(UserAccessListBean userAccessListBean) {
		this.userAccessListBean = userAccessListBean;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProjectType() {
		return projectType;
	}

	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}

	public String Login() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		// empLogin:loginMessage
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		System.out.println("users before login " + usersBean);
		EmpService empService = new EmpServiceImpl();

		if (!(usersBean.getUsername().equals("") && usersBean.getPassword()
				.equals(""))) {
			try {

				usersBean = empService.LoginService(usersBean);
				System.out.println("users after login " + usersBean);

				if (usersBean.getUserId() > 0) {
					session.setAttribute("usersBean", usersBean);
					return "dashboard.xhtml?faces-redirect=true";
				} else {
					System.out.println("else");
					FacesContext
							.getCurrentInstance()
							.addMessage(
									"empLogin:loginMessage",
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"Invalid UserName/Password, please try again",
											null));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(
						"empLogin:loginMessage",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Sorry!! We have faced some issue, Please wait for some time or "
										+ "cantact with support team", null));

			}
		}
		return null;
	}

	public String getControlProjRes() {
		EmpService empService = new EmpServiceImpl();
		try {

			empService.checkProjectValidity();
			FacesContext.getCurrentInstance().addMessage(
					"empDashboard:dashMsg",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome "
							+ usersBean.getEmpName(), null));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"empDashboard:dashMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
		}
		return null;
	}

	public String getBenchAllocation() {
		EmpService empService = new EmpServiceImpl();
		try {
			if (!(usersBean.getAccessVal().equals("HR") || usersBean
					.getAccessVal().equals("Admin")))
				empService.benchAllocation(usersBean.getUserId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"empDashboard:dashMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
		}
		return null;
	}

	public String CreateNewProfile() {
		System.out.println("users before login " + newUserBean);

		String message = "";
		if (newUserBean.getEmpName() == "" || newUserBean.getEmpName() == null) {
			message += "EmpName,";
		}
		if (newUserBean.getEmpDesg() == "") {
			message += "EmpDesg,";
		}
		if (newUserBean.getUsername() == ""
				|| newUserBean.getUsername() == null) {
			message += "UserName,";
		}
		if (newUserBean.getPassword() == ""
				|| newUserBean.getPassword() == null) {
			message += "Password,";
		}

		if (message != "") {
			message = message.substring(0, message.length() - 2);
			FacesContext.getCurrentInstance()
					.addMessage(
							"newResource:newResourceMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									message, null));
		} else {
			EmpService empService = new EmpServiceImpl();
			boolean flag = false;
			try {
				flag = empService.CreateNewService(newUserBean);
				if (flag) {
					FacesContext.getCurrentInstance().addMessage(
							"newResource:newResourceMsg",
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Employee is hired successfully", null));
				} else {
					FacesContext
							.getCurrentInstance()
							.addMessage(
									"newResource:newResourceMsg",
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"Failed to hire new employee, please contact with support team",
											null));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				FacesContext
						.getCurrentInstance()
						.addMessage(
								"newResource:newResourceMsg",
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"We have faced some issue, please wait for some time or contact with support team",
										null));
			}
			System.out.println("users after auto login " + newUserBean);
		}
		return null;
	}

	public String getSessionData() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		usersBean = (UsersBean) session.getAttribute("usersBean");
		System.out.println("Session usersbean " + usersBean);

		return null;
	}

	public String getUserAccessList() {
		EmpService empService = new EmpServiceImpl();
		try {
			userAccessListBean = empService.getUserAccessListService();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"provideAccess:accessMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
		}
		System.out.println("Session usersbean " + userAccessListBean);
		return null;
	}

	public void UpdatePassword(AjaxBehaviorEvent ev) {
		System.out.println("inside UpdatePassword");
		if (usersBean.getOldPassword().equals("")) {
			return;
		} else if (!usersBean.getOldPassword().equals(usersBean.getPassword())) {
			FacesContext.getCurrentInstance().addMessage(
					"empDashboard:dashTab:profileForm:profileMsg",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please enter your last password", null));
		} else if (usersBean.getOldPassword()
				.equals(usersBean.getNewPassword())) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"empDashboard:dashTab:profileForm:profileMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"your current password and last password should be different",
									null));

		} else {
			usersBean.setPassword(usersBean.getNewPassword());
			usersBean.setOldPassword("");
			usersBean.setNewPassword("");
			EmpService empService = new EmpServiceImpl();
			boolean flag = false;
			try {
				flag = empService.UpdatePassword(usersBean);
				if (flag) {
					System.out.println("update success");
					FacesContext.getCurrentInstance().addMessage(
							"empDashboard:dashTab:profileForm:profileMsg",
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Your password has updated successfully",
									null));
				} else {
					System.out.println("update fail");
					FacesContext
							.getCurrentInstance()
							.addMessage(
									"empDashboard:dashTab:profileForm:profileMsg",
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"Failed to update your password, please contact with support team",
											null));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				FacesContext
						.getCurrentInstance()
						.addMessage(
								"empDashboard:dashTab:profileForm:profileMsg",
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"We have faced some issue, please wait for some time or contact with support team",
										null));
			}
		}

	}

	public String AccessProvide() {
		System.out.println("inside AccessProvide");
		System.out.println("userAccessListBean " + userAccessListBean);

		if (userAccessListBean.getSelectedUserId() == 0) {
			FacesContext.getCurrentInstance().addMessage(
					"provideAccess:accessMsg",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please select valid user", null));
		} else if (userAccessListBean.getSelectedAccessId() == 1) {
			FacesContext.getCurrentInstance().addMessage(
					"provideAccess:accessMsg",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Please select valid access", null));
		} else {

			EmpService empService = new EmpServiceImpl();
			boolean flag = false;
			try {
				flag = empService.ProvideAccessService(
						userAccessListBean.getSelectedUserId(),
						userAccessListBean.getSelectedAccessId());
				if (flag) {
					System.out.println("update success");
					FacesContext.getCurrentInstance().addMessage(
							"provideAccess:accessMsg",
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Succesfully access provided", null));
				} else {
					System.out.println("update fail");
					FacesContext
							.getCurrentInstance()
							.addMessage(
									"provideAccess:accessMsg",
									new FacesMessage(
											FacesMessage.SEVERITY_ERROR,
											"Failed to provide access, please contact with support team",
											null));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				FacesContext
						.getCurrentInstance()
						.addMessage(
								"provideAccess:accessMsg",
								new FacesMessage(
										FacesMessage.SEVERITY_FATAL,
										"We have faced some issue, please wait for some time or contact with support team",
										null));
			}
		}
		return null;
	}

	public void GetUsersAccessDetails(AjaxBehaviorEvent e) {
		EmpService empService = new EmpServiceImpl();
		UsersBean tempUserBean;
		try {
			tempUserBean = empService.GetUserDetailsService(userAccessListBean
					.getSelectedUserId());

			userAccessListBean.setEmpDesg(tempUserBean.getEmpDesg());
			userAccessListBean.setCurrAccess(tempUserBean.getAccessVal());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getLoadProjectData() {
		EmpService empService = new EmpServiceImpl();
		try {
			System.out.println("usersBean.getAccessVal() "
					+ usersBean.getAccessVal());
			
				empProjListBean = empService.LoadProjectDataService(usersBean
						.getUserId());

			System.out.println("projListBean " + empProjListBean);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext
					.getExternalContext().getSession(false);
			session.setAttribute("projDetailsMsg", null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"projView:projMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"projTimeline:projTimelineMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
		}
		return null;
	}

	public Integer getFetchProjectDetails() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		try {
			Map<String, String> params = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap();

			projectId = Integer.parseInt(String.valueOf(params.get("pid")));
			projectType = Integer.parseInt(String.valueOf(params.get("flag")));

			System.out.println("projectId " + projectId);
			if (session.getAttribute("projDetailsMsg") != null) {
				FacesContext.getCurrentInstance().addMessage(
						"empProject:projDetailsMsg",
						(FacesMessage) session.getAttribute("projDetailsMsg"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public String getFetchNewTaskUI() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		EmpService empService = new EmpServiceImpl();
		try {
			List<Date> minDateSet = empService
					.LoadProjectDetailsService(projectId);
			System.out.println("minDateSet " + minDateSet);

			minStartDate = minDateSet.get(0);
			minEndDate = minDateSet.get(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(
					"projDetailsMsg",
					new FacesMessage(
							FacesMessage.SEVERITY_FATAL,
							"We have faced some issue, please wait for some time or contact with support team",
							null));
		}
		return null;
	}

	public String getLoadResourceData() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		EmpService empService = new EmpServiceImpl();
		System.out.println("projectId " + projectId);
		newTaskBean.setEndDate(null);
		try {

			empResourceBean.setResourceDetails(empService
					.LoadResourceDataService(projectId));
			System.out.println("empResourceBean " + empResourceBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(
					"projDetailsMsg",
					new FacesMessage(
							FacesMessage.SEVERITY_FATAL,
							"We have faced some issue, please wait for some time or contact with support team",
							null));
		}
		return null;
	}

	public String CreateNewTask() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		EmpService empService = new EmpServiceImpl();
		System.out.println("projectId " + projectId);
		newTaskBean.setProjcetId(projectId);
		newTaskBean.setTaskStatus(0);
		boolean inValid = false;
		if (newTaskBean.getTaskName().equals("")) {
			inValid = true;
		} else if (newTaskBean.getResourceId() == -1) {
			inValid = true;
		} else if (newTaskBean.getDescription().equals("")) {
			inValid = true;
		} else if (newTaskBean.getEndDate().equals("")) {
			inValid = true;
		} else {
			inValid = false;
		}
		if (inValid) {
			session.setAttribute("projDetailsMsg", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "All fields are required",
					null));
		} else {
			try {

				boolean flag = empService.CreateNewTask(newTaskBean);
				System.out.println("newTaskBean " + newTaskBean);
				if (flag) {
					System.out.println("New Task created");
					session.setAttribute("projDetailsMsg", new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"New task is created successfully", null));
				} else {
					session.setAttribute(
							"projDetailsMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"Failed to create new task, please contact with support team",
									null));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(
						"projDetailsMsg",
						new FacesMessage(
								FacesMessage.SEVERITY_FATAL,
								"We have faced some issue, please wait for some time or contact with support team",
								null));
			}
		}
		return "projectDetails.xhtml?pid=" + projectId + "&flag=" + projectType
				+ "&faces-redirect=true";
	}

	public String getLoadTaskDetails() {
		EmpService empService = new EmpServiceImpl();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		try {
			updateTaskBean.setTasksList(empService.LoadTaskDetails(projectId));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(
					"projDetailsMsg",
					new FacesMessage(
							FacesMessage.SEVERITY_FATAL,
							"We have faced some issue, please wait for some time or contact with support team",
							null));

		}
		return null;
	}

	public String UpdateTask() {
		System.out.println("UpdateTask");
		EmpService empService = new EmpServiceImpl();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		try {
			boolean flag = empService.UpdateTaskService(updateTaskBean);
			if (flag) {
				session.setAttribute("projDetailsMsg", new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Task's status is updated successfully", null));

			} else {
				session.setAttribute(
						"projDetailsMsg",
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Failed to update task, please contact with support team",
								null));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(
					"projDetailsMsg",
					new FacesMessage(
							FacesMessage.SEVERITY_FATAL,
							"We have faced some issue, please wait for some time or contact with support team",
							null));

		}
		return "projectDetails.xhtml?pid=" + projectId + "&flag=" + projectType
				+ "&faces-redirect=true";
	}

	public String ReleaseResource() {
		System.out.println("Inside ReleseResource");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		List<UsersBean> selectedUsers = (List<UsersBean>) session
				.getAttribute("SelectedResourceEMP");
		System.out.println("Release Resource " + selectedUsers);

		return "projectDetails.xhtml?pid=" + projectId + "&flag=" + projectType
				+ "&faces-redirect=true";
	}

}
