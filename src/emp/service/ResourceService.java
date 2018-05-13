package emp.service;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ResourcesAllocBean;

public interface ResourceService {
	ClientProjListBean LoadDataService() throws SQLException;

	ResourcesAllocBean LoadFormDataService()throws SQLException;

	boolean NewAllocationService(ResourcesAllocBean resourceBean)throws SQLException;
}
