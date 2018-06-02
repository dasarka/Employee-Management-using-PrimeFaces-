package emp.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import emp.model.ProjectReport;
import emp.service.ProjectReportService;
import emp.serviceImpl.ProjectReportServiceImpl;

public class ProjectReportController {
	private int projectId;
	private int projectType;

	private ProjectReport projReport = new ProjectReport();

	public Integer getFetchProjectDetails() {
		try {
			Map<String, String> params = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap();

			projectId = Integer.parseInt(String.valueOf(params.get("pid")));
			projectType = Integer.parseInt(String.valueOf(params.get("flag")));

			System.out.println("projectId " + projectId);

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
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		ProjectReportService progService = new ProjectReportServiceImpl();
		try {
			projReport = progService.CreateCharts(projectId);
			
			
		} catch (Exception e) {
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

}