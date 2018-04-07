package emp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import emp.ui.view.ResourceUI;

public class ResourcesAllocBean {
	private List<ClientProjViewBean> projectList;
	private List<UsersBean> onsiteManager;
	private List<UsersBean> manager;
	private List<UsersBean>	lead;
	private List<UsersBean> developer;
	private List<UsersBean> perfTester;
	private List<UsersBean> tester;
	private int hours_om=2;
	private int hours_m=2;
	private int hours_l=2;
	private int hours_d=2;
	private int hours_pt=2;
	private int hours_t=2;
	private int selectedProjectId;
	private int selectedOnsiteManagerId;
	private int selectedManagerId;
	private int selectedLeadId;
	private int selectedDeveloperId;
	private int selectedPerfTesterId;
	private int selectedTesterId;
	
	private String selectedProjectName;
	private String selectedOnsiteManagerName;
	private String selectedManagerName;
	private String selectedLeadName;
	private String selectedDeveloperName;
	private String selectedPerfTesterName;
	private String selectedTesterName;
	
	private String selectedOnsiteManagerDesg;
	private String selectedManagerDesg;
	private String selectedLeadDesg;
	private String selectedDeveloperDesg;
	private String selectedPerfTesterDesg;
	private String selectedTesterDesg;
	

	public String getSelectedDeveloperDesg() {
		return selectedDeveloperDesg;
	}
	public String getSelectedProjectName() {
		return selectedProjectName;
	}
	public String getSelectedOnsiteManagerName() {
		return selectedOnsiteManagerName;
	}
	public String getSelectedManagerName() {
		return selectedManagerName;
	}
	public String getSelectedLeadName() {
		return selectedLeadName;
	}
	public String getSelectedDeveloperName() {
		return selectedDeveloperName;
	}
	public String getSelectedPerfTesterName() {
		return selectedPerfTesterName;
	}
	public String getSelectedTesterName() {
		return selectedTesterName;
	}
	public String getSelectedOnsiteManagerDesg() {
		return selectedOnsiteManagerDesg;
	}
	public String getSelectedManagerDesg() {
		return selectedManagerDesg;
	}
	public String getSelectedLeadDesg() {
		return selectedLeadDesg;
	}
	public String getSelectedPerfTesterDesg() {
		return selectedPerfTesterDesg;
	}
	public String getSelectedTesterDesg() {
		return selectedTesterDesg;
	}
	
	
	
	public void setSelectedProjectName(String selectedProjectName) {
		this.selectedProjectName = selectedProjectName;
	}
	public void setSelectedOnsiteManagerName(String selectedOnsiteManagerName) {
		this.selectedOnsiteManagerName = selectedOnsiteManagerName;
	}
	public void setSelectedManagerName(String selectedManagerName) {
		this.selectedManagerName = selectedManagerName;
	}
	public void setSelectedLeadName(String selectedLeadName) {
		this.selectedLeadName = selectedLeadName;
	}
	public void setSelectedDeveloperName(String selectedDeveloperName) {
		this.selectedDeveloperName = selectedDeveloperName;
	}
	public void setSelectedPerfTesterName(String selectedPerfTesterName) {
		this.selectedPerfTesterName = selectedPerfTesterName;
	}
	public void setSelectedTesterName(String selectedTesterName) {
		this.selectedTesterName = selectedTesterName;
	}
	public void setSelectedOnsiteManagerDesg(String selectedOnsiteManagerDesg) {
		this.selectedOnsiteManagerDesg = selectedOnsiteManagerDesg;
	}
	public void setSelectedManagerDesg(String selectedManagerDesg) {
		this.selectedManagerDesg = selectedManagerDesg;
	}
	public void setSelectedLeadDesg(String selectedLeadDesg) {
		this.selectedLeadDesg = selectedLeadDesg;
	}
	public void setSelectedDeveloperDesg(String selectedDeveloperDesg) {
		this.selectedDeveloperDesg = selectedDeveloperDesg;
	}
	public void setSelectedPerfTesterDesg(String selectedPerfTesterDesg) {
		this.selectedPerfTesterDesg = selectedPerfTesterDesg;
	}
	public void setSelectedTesterDesg(String selectedTesterDesg) {
		this.selectedTesterDesg = selectedTesterDesg;
	}



	private Map<Integer,ResourceUI> selectedDeveloperList=new HashMap<Integer, ResourceUI>();
	private Map<Integer,ResourceUI> selectedPerfTesterList=new HashMap<Integer,ResourceUI>();
	private Map<Integer,ResourceUI> selectedTesterList=new HashMap<Integer,ResourceUI>();
	
	
	
	
	public Map<Integer,ResourceUI> getSelectedDeveloperList() {
		return selectedDeveloperList;
	}
	public List<Map.Entry<Integer,ResourceUI>> getSelectedDevelopers() {
	    Set<Map.Entry<Integer,ResourceUI>> developerSet = 
	                     selectedDeveloperList.entrySet();
	    return new ArrayList<Map.Entry<Integer,ResourceUI>>(developerSet);
	}
	public void setSelectedDeveloperList(Map<Integer,ResourceUI> selectedDeveloperList) {
		this.selectedDeveloperList = selectedDeveloperList;
	}
	public Map<Integer,ResourceUI> getSelectedPerfTesterList() {
		return selectedPerfTesterList;
	}
	public List<Map.Entry<Integer,ResourceUI>> getSelectedPerfTesters() {
	    Set<Map.Entry<Integer,ResourceUI>> perfTesterSet = 
	                     selectedPerfTesterList.entrySet();
	    return new ArrayList<Map.Entry<Integer,ResourceUI>>(perfTesterSet);
	}
	public void setSelectedPerfTesterList(Map<Integer,ResourceUI> selectedPerfTesterList) {
		this.selectedPerfTesterList = selectedPerfTesterList;
	}
	public Map<Integer,ResourceUI> getSelectedTesterList() {
		return selectedTesterList;
	}
	public List<Map.Entry<Integer,ResourceUI>> getSelectedTesters() {
	    Set<Map.Entry<Integer,ResourceUI>> testerSet = 
	                     selectedTesterList.entrySet();
	    return new ArrayList<Map.Entry<Integer,ResourceUI>>(testerSet);
	}
	public void setSelectedTesterList(Map<Integer,ResourceUI> selectedTesterList) {
		this.selectedTesterList = selectedTesterList;
	}
	public List<ClientProjViewBean> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ClientProjViewBean> projectList) {
		this.projectList = projectList;
	}
	public List<UsersBean> getOnsiteManager() {
		return onsiteManager;
	}
	public void setOnsiteManager(List<UsersBean> onsiteManager) {
		this.onsiteManager = onsiteManager;
	}
	public List<UsersBean> getManager() {
		return manager;
	}
	public void setManager(List<UsersBean> manager) {
		this.manager = manager;
	}
	public List<UsersBean> getLead() {
		return lead;
	}
	public void setLead(List<UsersBean> lead) {
		this.lead = lead;
	}
	public List<UsersBean> getDeveloper() {
		return developer;
	}
	public void setDeveloper(List<UsersBean> developer) {
		this.developer = developer;
	}
	public List<UsersBean> getPerfTester() {
		return perfTester;
	}
	public void setPerfTester(List<UsersBean> perfTester) {
		this.perfTester = perfTester;
	}
	public List<UsersBean> getTester() {
		return tester;
	}
	public void setTester(List<UsersBean> tester) {
		this.tester = tester;
	}
	public int getHours_om() {
		return hours_om;
	}
	public void setHours_om(int hours_om) {
		this.hours_om = hours_om;
	}
	public int getHours_m() {
		return hours_m;
	}
	public void setHours_m(int hours_m) {
		this.hours_m = hours_m;
	}
	public int getHours_l() {
		return hours_l;
	}
	public void setHours_l(int hours_l) {
		this.hours_l = hours_l;
	}
	public int getHours_d() {
		return hours_d;
	}
	public void setHours_d(int hours_d) {
		this.hours_d = hours_d;
	}
	public int getHours_pt() {
		return hours_pt;
	}
	public void setHours_pt(int hours_pt) {
		this.hours_pt = hours_pt;
	}
	public int getHours_t() {
		return hours_t;
	}
	public void setHours_t(int hours_t) {
		this.hours_t = hours_t;
	}
	public int getSelectedProjectId() {
		return selectedProjectId;
	}
	public void setSelectedProjectId(int selectedProjectId) {
		this.selectedProjectId = selectedProjectId;
		
	}
	public int getSelectedOnsiteManagerId() {
		return selectedOnsiteManagerId;
	}
	public void setSelectedOnsiteManagerId(int selectedOnsiteManagerId) {
		this.selectedOnsiteManagerId = selectedOnsiteManagerId;
		
	}
	public int getSelectedManagerId() {
		return selectedManagerId;
	}
	public void setSelectedManagerId(int selectedManagerId) {
		this.selectedManagerId = selectedManagerId;
		
	}
	public int getSelectedLeadId() {
		return selectedLeadId;
	}
	public void setSelectedLeadId(int selectedLeadId) {
		this.selectedLeadId = selectedLeadId;
		
	}
	public int getSelectedDeveloperId() {
		return selectedDeveloperId;
	}
	public void setSelectedDeveloperId(int selectedDeveloperId) {
		this.selectedDeveloperId = selectedDeveloperId;
		
	}
	public int getSelectedPerfTesterId() {
		return selectedPerfTesterId;
	}
	public void setSelectedPerfTesterId(int selectedPerfTesterId) {
		this.selectedPerfTesterId = selectedPerfTesterId;
		
	}
	public int getSelectedTesterId() {
		return selectedTesterId;
	}
	public void setSelectedTesterId(int selectedTesterId) {
		this.selectedTesterId = selectedTesterId;
		
	}
	
	@Override
	public String toString() {
		return "ResourcesAllocBean [projectList=" + projectList
				+ ", onsiteManager=" + onsiteManager + ", manager=" + manager
				+ ", lead=" + lead + ", developer=" + developer
				+ ", perfTester=" + perfTester + ", tester=" + tester
				+ ", hours_om=" + hours_om + ", hours_m=" + hours_m
				+ ", hours_l=" + hours_l + ", hours_d=" + hours_d
				+ ", hours_pt=" + hours_pt + ", hours_t=" + hours_t
				+ ", selectedProjectId=" + selectedProjectId
				+ ", selectedOnsiteManagerId=" + selectedOnsiteManagerId
				+ ", selectedManagerId=" + selectedManagerId
				+ ", selectedLeadId=" + selectedLeadId
				+ ", selectedDeveloperId=" + selectedDeveloperId
				+ ", selectedPerfTesterId=" + selectedPerfTesterId
				+ ", selectedTesterId=" + selectedTesterId
				+ ", selectedProjectName=" + selectedProjectName
				+ ", selectedOnsiteManagerName=" + selectedOnsiteManagerName
				+ ", selectedManagerName=" + selectedManagerName
				+ ", selectedLeadName=" + selectedLeadName
				+ ", selectedDeveloperName=" + selectedDeveloperName
				+ ", selectedPerfTesterName=" + selectedPerfTesterName
				+ ", selectedTesterName=" + selectedTesterName
				+ ", selectedOnsiteManagerDesg=" + selectedOnsiteManagerDesg
				+ ", selectedManagerDesg=" + selectedManagerDesg
				+ ", selectedLeadDesg=" + selectedLeadDesg
				+ ", selectedDeveloperDesg=" + selectedDeveloperDesg
				+ ", selectedPerfTesterDesg=" + selectedPerfTesterDesg
				+ ", selectedTesterDesg=" + selectedTesterDesg
				+ ", selectedDeveloperList=" + selectedDeveloperList
				+ ", selectedPerfTesterList=" + selectedPerfTesterList
				+ ", selectedTesterList=" + selectedTesterList + "]";
	}
	public ResourcesAllocBean(List<ClientProjViewBean> projectList,
			List<UsersBean> onsiteManager, List<UsersBean> manager,
			List<UsersBean> lead, List<UsersBean> developer,
			List<UsersBean> perfTester, List<UsersBean> tester, int hours_om,
			int hours_m, int hours_l, int hours_d, int hours_pt, int hours_t,
			int selectedProjectId, int selectedOnsiteManagerId,
			int selectedManagerId, int selectedLeadId, int selectedDeveloperId,
			int selectedPerfTesterId, int selectedTesterId) {
		super();
		this.projectList = projectList;
		this.onsiteManager = onsiteManager;
		this.manager = manager;
		this.lead = lead;
		this.developer = developer;
		this.perfTester = perfTester;
		this.tester = tester;
		this.hours_om = hours_om;
		this.hours_m = hours_m;
		this.hours_l = hours_l;
		this.hours_d = hours_d;
		this.hours_pt = hours_pt;
		this.hours_t = hours_t;
		this.selectedProjectId = selectedProjectId;
		this.selectedOnsiteManagerId = selectedOnsiteManagerId;
		this.selectedManagerId = selectedManagerId;
		this.selectedLeadId = selectedLeadId;
		this.selectedDeveloperId = selectedDeveloperId;
		this.selectedPerfTesterId = selectedPerfTesterId;
		this.selectedTesterId = selectedTesterId;
	}
	
	public ResourcesAllocBean(List<ClientProjViewBean> projectList,
			List<UsersBean> onsiteManager, List<UsersBean> manager,
			List<UsersBean> lead, List<UsersBean> developer,
			List<UsersBean> perfTester, List<UsersBean> tester) {
		super();
		this.projectList = projectList;
		this.onsiteManager = onsiteManager;
		this.manager = manager;
		this.lead = lead;
		this.developer = developer;
		this.perfTester = perfTester;
		this.tester = tester;
	}
	public ResourcesAllocBean() {
		super();
	}
	
	

}
