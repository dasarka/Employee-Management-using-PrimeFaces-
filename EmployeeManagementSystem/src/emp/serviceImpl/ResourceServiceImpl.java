package emp.serviceImpl;

import java.sql.SQLException;

import emp.dao.ResourceDao;
import emp.daoImpl.ResourceDaoImpl;
import emp.model.ClientProjListBean;
import emp.model.ResourcesAllocBean;
import emp.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {
	
	@Override
	public ClientProjListBean LoadDataService() throws SQLException {
		ResourceDao resDao=new ResourceDaoImpl();
		return resDao.LoadDataDao();
	}

	@Override
	public ResourcesAllocBean LoadFormDataService() throws SQLException {
		ResourceDao resDao=new ResourceDaoImpl();
		return resDao.LoadFormDataDao();
	}

	@Override
	public boolean NewAllocationService(ResourcesAllocBean resourceBean)
			throws SQLException {
		ResourceDao resDao=new ResourceDaoImpl();
		return resDao.NewAllocationDao(resourceBean);
	}

}
