package emp.dao;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.UsersBean;

public interface ClientDao {

	boolean CreateProjectDao(ClientProjViewBean projViewBean,UsersBean usersbean) throws SQLException;

	ClientProjListBean LoadDataDao(String username) throws SQLException;

}
