package emp.serviceImpl;

import java.sql.SQLException;

import emp.dao.ClientDao;
import emp.daoImpl.ClientDaoImpl;
import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.UsersBean;
import emp.service.ClientService;

public class ClientServiceImpl implements ClientService{

	@Override
	public boolean CreateProjectService(ClientProjViewBean projViewBean,UsersBean usersbean) throws SQLException {
		ClientDao clientDao=new ClientDaoImpl();
		return clientDao.CreateProjectDao(projViewBean,usersbean);
	}

	@Override
	public ClientProjListBean LoadDataService(String username) throws SQLException {
		ClientDao clientDao=new ClientDaoImpl();
		return clientDao.LoadDataDao(username);
	}

}
