package emp.service;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;

public interface ClientService {

	boolean CreateProjectService(ClientProjViewBean projViewBean,String username) throws SQLException;

	ClientProjListBean LoadDataService(String username) throws SQLException;

}
