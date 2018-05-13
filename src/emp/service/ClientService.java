package emp.service;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.UsersBean;

public interface ClientService {


	ClientProjListBean LoadDataService(String username) throws SQLException;

	boolean CreateProjectService(ClientProjViewBean projViewBean,
			UsersBean usersbean) throws SQLException;

}
