package emp.model;

import java.util.List;
import java.util.Map;

public class EmpProjListBean {
	private List<EmpProjViewBean> currentProj;
	private List<EmpProjViewBean> upcomingProj;
	private List<EmpProjViewBean> completeProj;
	private Map<Integer,UsersBean> resourcesMap;
	
	public Map<Integer, UsersBean> getResourcesMap() {
		return resourcesMap;
	}
	public void setResourcesMap(Map<Integer, UsersBean> resourcesMap) {
		this.resourcesMap = resourcesMap;
	}
	public List<EmpProjViewBean> getCurrentProj() {
		return currentProj;
	}
	public void setCurrentProj(List<EmpProjViewBean> currentProj) {
		this.currentProj = currentProj;
	}
	public List<EmpProjViewBean> getUpcomingProj() {
		return upcomingProj;
	}
	public void setUpcomingProj(List<EmpProjViewBean> upcomingProj) {
		this.upcomingProj = upcomingProj;
	}
	public List<EmpProjViewBean> getCompleteProj() {
		return completeProj;
	}
	public void setCompleteProj(List<EmpProjViewBean> completeProj) {
		this.completeProj = completeProj;
	}
	@Override
	public String toString() {
		return "EmpProjListBean [currentProj=" + currentProj
				+ ", upcomingProj=" + upcomingProj + ", completeProj="
				+ completeProj + ", resourcesMap=" + resourcesMap + "]";
	}
	public EmpProjListBean(List<EmpProjViewBean> currentProj,
			List<EmpProjViewBean> upcomingProj,
			List<EmpProjViewBean> completeProj) {
		super();
		this.currentProj = currentProj;
		this.upcomingProj = upcomingProj;
		this.completeProj = completeProj;
	}
	public EmpProjListBean() {
		super();
	}
	
}
