package emp.serviceImpl;

import java.sql.SQLException;

import emp.dao.ClientDao;
import emp.daoImpl.ClientDaoImpl;
import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.service.ClientService;

public class ClientServiceImpl implements ClientService{

	@Override
	public boolean CreateProjectService(ClientProjViewBean projViewBean,String username) throws SQLException {
		ClientDao clientDao=new ClientDaoImpl();
		return clientDao.CreateProjectDao(projViewBean,username);
	}

	@Override
	public ClientProjListBean LoadDataService(String username) throws SQLException {
		ClientDao clientDao=new ClientDaoImpl();
		return clientDao.LoadDataDao(username);
	}

}
