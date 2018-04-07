package emp.bean;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	private ClientProjListBean projListBean=new ClientProjListBean();
	private ClientProjViewBean projViewBean=new ClientProjViewBean();

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
	
	public String getLoadData(){
		minStartDate=new Date();
		projViewBean.setStartDate(null);
		projViewBean.setEndDate(null);
		ClientService clientService=new ClientServiceImpl();
		try {
			projListBean=clientService.LoadDataService(SessionData().getEmpName());
			System.out.println("projListBean "+projListBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void SetEndDate(AjaxBehaviorEvent e){
		System.out.println("Ajjx call");
		try {
			String[] date=projViewBean.getStartDate().split(" ");
			String tempDate=date[2]+"/"+date[1]+"/"+date[5];
			minEndDate=new SimpleDateFormat("dd/MMM/yy").parse(tempDate);
			System.out.println("minEndDate "+minEndDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	UsersBean SessionData(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
		System.out.println("Session usersbean " + usersBean);
		return usersBean;
	}
	public String CreateProject(){
		
		ClientService clientService=new ClientServiceImpl();
		boolean flag=false;
		try {
			flag=clientService.CreateProjectService(projViewBean,SessionData().getEmpName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
