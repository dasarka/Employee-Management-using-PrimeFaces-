package emp.model;

import java.util.ArrayList;
import java.util.List;

public class EmpResourceBean {
	private List<UsersBean> resourceDetails;

	public List<UsersBean> getResourceDetails() {
		return resourceDetails;
	}

	public void setResourceDetails(List<UsersBean> resourceDetails) {
		this.resourceDetails = resourceDetails;
	}

	@Override
	public String toString() {
		return "EmpResourceBean [resourceDetails=" + resourceDetails + "]";
	}

	public EmpResourceBean() {
		super();
	}
	
	

}
