package emp.dao;

import java.sql.SQLException;

import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;

public interface ClientDao {

	boolean CreateProjectDao(ClientProjViewBean projViewBean,String username) throws SQLException;

	ClientProjListBean LoadDataDao(String username) throws SQLException;

}
