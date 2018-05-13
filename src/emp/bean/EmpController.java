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
	private NewTasksBean newTaskBean=new NewTasksBean();
	private UpdateTaskBean updateTaskBean=new UpdateTaskBean();
	
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
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		System.out.println("users before login " + usersBean);
		EmpService empService = new EmpServiceImpl();
		try {
			usersBean = empService.LoginService(usersBean);
			System.out.println("users after login " + usersBean);

			if (usersBean.getUserId() > 0) {
				session.setAttribute("usersBean", usersBean);
				return "dashboard.xhtml?faces-redirect=true";
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public String getControlProjRes(){
		EmpService empService = new EmpServiceImpl();
		try {
			empService.checkProjectValidity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String CreateNewProfile() {
		System.out.println("users before login " + newUserBean);

		String message = "";
		if (newUserBean.getEmpName() == "" || newUserBean.getEmpName() == null) {
			message += "EmpName,";
		}
		if (newUserBean.getEmpDesg() == "Default") {
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
			System.out.println("Message " + message);
		} else {
			EmpService empService = new EmpServiceImpl();
			boolean flag = false;
			try {
				flag = empService.CreateNewService(newUserBean);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		}
		System.out.println("Session usersbean " + userAccessListBean);
		return null;
	}

	public String UpdatePassword() {
		System.out.println("inside UpdatePassword");
		if (!usersBean.getOldPassword().equals(usersBean.getPassword())) {

		} else if (usersBean.getOldPassword()
				.equals(usersBean.getNewPassword())) {

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
				} else {
					System.out.println("update fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public String AccessProvide() {
		System.out.println("inside AccessProvide");
		System.out.println("userAccessListBean " + userAccessListBean);
		if (userAccessListBean.getSelectedUserId() == 0) {

		} else if (userAccessListBean.getSelectedAccessId() == 1) {

		} else {

			EmpService empService = new EmpServiceImpl();
			boolean flag = false;
			try {
				flag = empService.ProvideAccessService(
						userAccessListBean.getSelectedUserId(),
						userAccessListBean.getSelectedAccessId());
				if (flag) {
					System.out.println("update success");
				} else {
					System.out.println("update fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			System.out.println("usersBean.getAccessVal() "+usersBean.getAccessVal());
			if(usersBean.getAccessVal().equals("Admin") || usersBean.getAccessVal().equals("HR")){
				empProjListBean = empService.LoadInternalProjectDataService(usersBean
						.getUserId());
			}else{
			empProjListBean = empService.LoadProjectDataService(usersBean
					.getUserId());
			}
			System.out.println("projListBean " + empProjListBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Integer getFetchProjectDetails(){
		try {
			Map<String, String> params = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap();
			
			projectId = Integer.parseInt(String.valueOf(params.get("pid")));
			projectType=Integer.parseInt(String.valueOf(params.get("flag")));
			
			System.out.println("projectId "+projectId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getFetchNewTaskUI(){
		EmpService empService = new EmpServiceImpl();
		try {
			List<Date> minDateSet = empService.LoadProjectDetailsService(projectId);
			System.out.println("minDateSet " + minDateSet);

			minStartDate=minDateSet.get(0);
			minEndDate=minDateSet.get(1);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getLoadResourceData() {
		
		EmpService empService = new EmpServiceImpl();
		System.out.println("projectId "+projectId);
		newTaskBean.setEndDate(null);
		try {
			
			empResourceBean.setResourceDetails(empService
					.LoadResourceDataService(projectId));
			System.out.println("empResourceBean " + empResourceBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String CreateNewTask(){
		EmpService empService = new EmpServiceImpl();
		System.out.println("projectId "+projectId);
		newTaskBean.setProjcetId(projectId);
		newTaskBean.setTaskStatus(0);
		try {
			
			boolean flag=empService
					.CreateNewTask(newTaskBean);
			System.out.println("newTaskBean " + newTaskBean);
			if(flag){
				System.out.println("New Task created");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "projectDetails.xhtml?pid="+projectId+"&flag="+projectType+"&faces-redirect=true";
	}

	public String getLoadTaskDetails(){
		EmpService empService = new EmpServiceImpl();
		try {
			updateTaskBean.setTasksList(empService.LoadTaskDetails(projectId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String UpdateTask(){
		EmpService empService = new EmpServiceImpl();
		try {
			boolean flag= empService.UpdateTaskService(updateTaskBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "projectDetails.xhtml?pid="+projectId+"&flag="+projectType+"&faces-redirect=true";
	}
	
	public String ReleaseResource(){
		System.out.println("Inside ReleseResource");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		List<UsersBean> selectedUsers=(List<UsersBean>) session.getAttribute("SelectedResourceEMP");
		System.out.println("Release Resource "+selectedUsers);
		
		return "projectDetails.xhtml?pid="+projectId+"&flag="+projectType+"&faces-redirect=true";
	}
	
}
