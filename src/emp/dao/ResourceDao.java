package emp.dao;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ResourcesAllocBean;

public interface ResourceDao {

	ClientProjListBean LoadDataDao() throws SQLException;

	ResourcesAllocBean LoadFormDataDao()throws SQLException;

	boolean NewAllocationDao(ResourcesAllocBean resourceBean)
			throws SQLException;

}
