package emp.bean;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.UsersBean;
import emp.service.ClientService;
import emp.serviceImpl.ClientServiceImpl;

public class ClientController {
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

	private ClientProjListBean projListBean = new ClientProjListBean();
	private ClientProjViewBean projViewBean = new ClientProjViewBean();

	public ClientProjListBean getProjListBean() {
		return projListBean;
	}

	public void setProjListBean(ClientProjListBean projListBean) {
		this.projListBean = projListBean;
	}

	public ClientProjViewBean getProjViewBean() {
		return projViewBean;
	}

	public void setProjViewBean(ClientProjViewBean projViewBean) {
		this.projViewBean = projViewBean;
	}

	public ClientController() {
		super();
	}

	public String getLoadData() {
		minStartDate = new Date();
		projViewBean.setStartDate(null);
		projViewBean.setEndDate(null);
		ClientService clientService = new ClientServiceImpl();
		if (SessionData().getAccessVal().equals("HR")) {
			projViewBean.setProjectName("Internal Project");
			projViewBean.setBudget(0.00);
		}

		try {
			projListBean = clientService.LoadDataService(SessionData()
					.getEmpName());
			System.out.println("projListBean " + projListBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"projDash:newProjMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));
		}
		return null;
	}

	public void SetEndDate(AjaxBehaviorEvent e) {
		System.out.println("Ajjx call");
		try {
			String[] date = projViewBean.getStartDate().split(" ");
			String tempDate = date[2] + "/" + date[1] + "/" + date[5];
			minEndDate = new SimpleDateFormat("dd/MMM/yy").parse(tempDate);

			System.out.println("minEndDate " + minEndDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"projDash:newProjMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));

		}

	}

	UsersBean SessionData() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
		System.out.println("Session usersbean " + usersBean);
		return usersBean;
	}

	public String CreateProject() {

		ClientService clientService = new ClientServiceImpl();
		boolean flag = false;
		System.out.println("projViewBean " + projViewBean);

		try {
			if (projViewBean.getStartDate() == null
					|| projViewBean.getStartDate() == "") {
				FacesContext.getCurrentInstance().addMessage(
						"projDash:newProjMsg",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Project Start Date required", null));
			} else if (projViewBean.getEndDate() == null
					|| projViewBean.getEndDate() == "") {
				FacesContext.getCurrentInstance().addMessage(
						"projDash:newProjMsg",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Project End Date required", null));
			} else {
				String[] date = projViewBean.getStartDate().split(" ");
				String tempDate = date[2] + "/" + date[1] + "/" + date[5];
				String[] date1 = projViewBean.getEndDate().split(" ");
				String tempDate1 = date1[2] + "/" + date1[1] + "/" + date1[5];

				Date startDate = new SimpleDateFormat("dd/MMM/yy")
						.parse(tempDate);
				Date endDate = new SimpleDateFormat("dd/MMM/yy")
						.parse(tempDate1);
				System.out.println("startDate " + startDate);
				System.out.println("endDate " + endDate);
				if (startDate.before(new Date())) {
					FacesContext.getCurrentInstance().addMessage(
							"projDash:newProjMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Project can't start before or from today", null));
				} else if (endDate.before(startDate)) {
					FacesContext.getCurrentInstance().addMessage(
							"projDash:newProjMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Project can't end before start", null));
				} else if (projViewBean.getProjectName() == null
						|| projViewBean.getProjectName() == "") {
					FacesContext.getCurrentInstance().addMessage(
							"projDash:newProjMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Project name required", null));
				} else if (projViewBean.getResources() < 0) {
					FacesContext.getCurrentInstance().addMessage(
							"projDash:newProjMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Resources can't less than zero", null));
				} else if (projViewBean.getBudget() < 0.0) {
					FacesContext.getCurrentInstance().addMessage(
							"projDash:newProjMsg",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Budget can't less than zero", null));
				} else {
					if (SessionData().getAccessVal().equals("Client")
							&&

							(projViewBean.getProjectName().equalsIgnoreCase(
									"Internal Project")
									|| projViewBean.getProjectName()
											.equalsIgnoreCase("Bench Project") || projViewBean
									.getProjectName().equalsIgnoreCase(
											"LMS Project"))) {
						FacesContext.getCurrentInstance().addMessage(
								"projDash:newProjMsg",
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Please select different project name",
										null));
						return null;
					}
					flag = clientService.CreateProjectService(projViewBean,
							SessionData());
					if (flag) {
						FacesContext.getCurrentInstance().addMessage(
								"projDash:newProjMsg",
								new FacesMessage(FacesMessage.SEVERITY_INFO,
										"Project has created successfully",
										null));

					} else {
						FacesContext
								.getCurrentInstance()
								.addMessage(
										"projDash:newProjMsg",
										new FacesMessage(
												FacesMessage.SEVERITY_ERROR,
												"Faied to create a new project, please contact with support team",
												null));

					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"projDash:newProjMsg",
							new FacesMessage(
									FacesMessage.SEVERITY_FATAL,
									"We have faced some issue, please wait for some time or contact with support team",
									null));

		}

		return null;
	}

}
