package emp.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import emp.model.ProjectReport;
import emp.service.ProjectReportService;
import emp.serviceImpl.ProjectReportServiceImpl;



public class ProjectReportController {
	private int projectId;
	private int projectType;
	
	private ProjectReport projReport=new ProjectReport();
	
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

	
   
    



	public ProjectReport getProjReport() {
		return projReport;
	}







	public void setProjReport(ProjectReport projReport) {
		this.projReport = projReport;
	}







	public String getInitCharts() {
    	ProjectReportService progService=new ProjectReportServiceImpl();
        try {
			projReport=progService.CreateCharts(projectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
 
   
    
   
    
   
     
   
	
}