package emp.model;

import java.util.List;

public class ClientProjListBean {
	private List<ClientProjViewBean> currentProj;
	private List<ClientProjViewBean> upcomingProj;
	private List<ClientProjViewBean> completeProj;
	public List<ClientProjViewBean> getCurrentProj() {
		return currentProj;
	}
	public void setCurrentProj(List<ClientProjViewBean> currentProj) {
		this.currentProj = currentProj;
	}
	public List<ClientProjViewBean> getUpcomingProj() {
		return upcomingProj;
	}
	public void setUpcomingProj(List<ClientProjViewBean> upcomingProj) {
		this.upcomingProj = upcomingProj;
	}
	public List<ClientProjViewBean> getCompleteProj() {
		return completeProj;
	}
	public void setCompleteProj(List<ClientProjViewBean> completeProj) {
		this.completeProj = completeProj;
	}
	@Override
	public String toString() {
		return "ClientProjListBean [currentProj=" + currentProj
				+ ", upcomingProj=" + upcomingProj + ", completeProj="
				+ completeProj + "]";
	}
	public ClientProjListBean(List<ClientProjViewBean> currentProj,
			List<ClientProjViewBean> upcomingProj,
			List<ClientProjViewBean> completeProj) {
		super();
		this.currentProj = currentProj;
		this.upcomingProj = upcomingProj;
		this.completeProj = completeProj;
	}
	public ClientProjListBean() {
		super();
	}
}
