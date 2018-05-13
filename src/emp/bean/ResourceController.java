package emp.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.ResourcesAllocBean;
import emp.model.UsersBean;
import emp.service.ResourceService;
import emp.serviceImpl.ResourceServiceImpl;
import emp.ui.view.MaxValUI;
import emp.ui.view.ResourceUI;

public class ResourceController {
	private ClientProjListBean projListBean = new ClientProjListBean();
	private ResourcesAllocBean resourceBean = new ResourcesAllocBean();
	private MaxValUI maxValUI=new MaxValUI();
	
	

	public MaxValUI getMaxValUI() {
		return maxValUI;
	}

	public void setMaxValUI(MaxValUI maxValUI) {
		this.maxValUI = maxValUI;
	}

	public ClientProjListBean getProjListBean() {
		return projListBean;
	}

	public void setProjListBean(ClientProjListBean projListBean) {
		this.projListBean = projListBean;
	}

	public ResourcesAllocBean getResourceBean() {
		return resourceBean;
	}

	public void setResourceBean(ResourcesAllocBean resourceBean) {
		this.resourceBean = resourceBean;
	}

	public ResourceController() {
		super();
	}

	UsersBean SessionData() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		UsersBean usersBean = (UsersBean) session.getAttribute("usersBean");
		System.out.println("Session usersbean " + usersBean);
		return usersBean;
	}

	public String getLoadData() {
		ResourceService resService = new ResourceServiceImpl();
		try {
			projListBean = resService.LoadDataService();
			System.out.println("projListBean " + projListBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getLoadFormData() {
		ResourceService resService = new ResourceServiceImpl();
		try {
			resourceBean = resService.LoadFormDataService();
			System.out.println("projListBean " + projListBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void UpdateDeveloper(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateDeveloper");
		System.out.println(resourceBean.getSelectedDeveloperId());
		System.out.println(resourceBean.getHours_d());
		LinkedHashSet<Integer> idList=new LinkedHashSet<Integer>();
		if(resourceBean.getSelectedDeveloperId()>0 && resourceBean.getHours_d()>=2 && resourceBean.getHours_d()<=8){
			if(idList.add(resourceBean.getSelectedDeveloperId())){
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedDeveloperList();
				dataList.put(resourceBean.getSelectedDeveloperId(),
						new ResourceUI(resourceBean.getSelectedDeveloperName(),
								resourceBean.getSelectedDeveloperDesg(),resourceBean.getHours_d()));
				resourceBean.setSelectedDeveloperList(dataList);
			}else{
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedDeveloperList();
				dataList.get(resourceBean.getSelectedDeveloperId()).setValue3(resourceBean.getHours_d());
				resourceBean.setSelectedDeveloperList(dataList);
			}
			
			resourceBean.setHours_d(2);
			resourceBean.setSelectedDeveloperId(0);
		}
	}
	public void UpdatePerfTester(AjaxBehaviorEvent e) {
		LinkedHashSet<Integer> idList=new LinkedHashSet<Integer>();
		if(resourceBean.getSelectedPerfTesterId()>0 && resourceBean.getHours_pt()>=2 && resourceBean.getHours_pt()<=8){
			if(idList.add(resourceBean.getSelectedPerfTesterId())){
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedPerfTesterList();
				dataList.put(resourceBean.getSelectedPerfTesterId(),
						new ResourceUI(resourceBean.getSelectedPerfTesterName(),
								resourceBean.getSelectedPerfTesterDesg(),resourceBean.getHours_pt()));
				resourceBean.setSelectedPerfTesterList(dataList);
			}else{
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedPerfTesterList();
				dataList.get(resourceBean.getSelectedPerfTesterId()).setValue3(resourceBean.getHours_pt());
				resourceBean.setSelectedPerfTesterList(dataList);
			}
			
			resourceBean.setHours_pt(2);
			resourceBean.setSelectedPerfTesterId(0);
		}
	}
	public void UpdateTester(AjaxBehaviorEvent e) {
		LinkedHashSet<Integer> idList=new LinkedHashSet<Integer>();
		if(resourceBean.getSelectedTesterId()>0 && resourceBean.getHours_t()>=2 && resourceBean.getHours_t()<=8){
			if(idList.add(resourceBean.getSelectedTesterId())){
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedTesterList();
				dataList.put(resourceBean.getSelectedTesterId(),
						new ResourceUI(resourceBean.getSelectedTesterName(),
								resourceBean.getSelectedTesterDesg(),resourceBean.getHours_t()));
				resourceBean.setSelectedTesterList(dataList);
			}else{
				Map<Integer,ResourceUI> dataList=resourceBean.getSelectedTesterList();
				dataList.get(resourceBean.getSelectedTesterId()).setValue3(resourceBean.getHours_t());
				resourceBean.setSelectedTesterList(dataList);
			}
			
			resourceBean.setHours_t(2);
			resourceBean.setSelectedTesterId(0);
		}
	}

	public void UpdateProject(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		for (ClientProjViewBean projBean : resourceBean.getProjectList()) {
			if(resourceBean.getSelectedProjectId()==projBean.getProjectId()){
				resourceBean.setSelectedProjectName(projBean.getProjectName());
			}
			
		}
		
		
	}
	public void UpdateOnsiteManager(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_om(resourceBean.getHours_om());
		for (UsersBean userBean : resourceBean.getOnsiteManager()) {
			if(resourceBean.getSelectedOnsiteManagerId()==userBean.getUserId()){
				resourceBean.setSelectedOnsiteManagerName(userBean.getEmpName());
				resourceBean.setSelectedOnsiteManagerDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_om(userBean.getRemainHours());
			}
			
		}
		
	}
	
	public void UpdateManager(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_m(resourceBean.getHours_m());
		for (UsersBean userBean : resourceBean.getManager()) {
			if(resourceBean.getSelectedManagerId()==userBean.getUserId()){
				resourceBean.setSelectedManagerName(userBean.getEmpName());
				resourceBean.setSelectedManagerDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_m(userBean.getRemainHours());
			}
			
		}
		
	}
	
	public void UpdateLead(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_l(resourceBean.getHours_l());
		for (UsersBean userBean : resourceBean.getLead()) {
			if(resourceBean.getSelectedLeadId()==userBean.getUserId()){
				resourceBean.setSelectedLeadName(userBean.getEmpName());
				resourceBean.setSelectedLeadDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_l(userBean.getRemainHours());
			}
			
		}
		
	}
	public void UpdateSelectDeveloper(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_d(resourceBean.getHours_d());
		for (UsersBean userBean : resourceBean.getDeveloper()) {
			if(resourceBean.getSelectedDeveloperId()==userBean.getUserId()){
				resourceBean.setSelectedDeveloperName(userBean.getEmpName());
				resourceBean.setSelectedDeveloperDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_d(userBean.getRemainHours());
			}
			
		}
		
	}
	public void UpdateSelectPerfTester(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_pt(resourceBean.getHours_pt());
		for (UsersBean userBean : resourceBean.getPerfTester()) {
			if(resourceBean.getSelectedPerfTesterId()==userBean.getUserId()){
				resourceBean.setSelectedPerfTesterName(userBean.getEmpName());
				resourceBean.setSelectedPerfTesterDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_pt(userBean.getRemainHours());
			}
			
		}
		
	}
	public void UpdateSelectTester(AjaxBehaviorEvent e) {
		System.out.println("Inside UpdateProject ");
		System.out.println(resourceBean.getSelectedProjectId());
		resourceBean.setHours_t(resourceBean.getHours_t());
		for (UsersBean userBean : resourceBean.getTester()) {
			if(resourceBean.getSelectedTesterId()==userBean.getUserId()){
				resourceBean.setSelectedTesterName(userBean.getEmpName());
				resourceBean.setSelectedTesterDesg(userBean.getEmpDesg());
				maxValUI.setMax_hours_t(userBean.getRemainHours());
			}
			
		}
		
	}
	public String NewAllocation(){
		System.out.println("Inside NewAllocation");
		System.out.println("resourceBean "+resourceBean);
		ResourceService resService = new ResourceServiceImpl();
		boolean flag=false;
		try {
			flag = resService.NewAllocationService(resourceBean);
			System.out.println("flag " + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
