package emp.dao;

import java.sql.SQLException;
import java.util.List;

import emp.model.*;

public interface EmpDao {

	UsersBean LoginDao(UsersBean usersBean) throws SQLException;

	boolean CreateNewDao(UsersBean usersBean) throws SQLException;

	boolean UpdatePassword(UsersBean usersBean) throws SQLException;

	UserAccessListBean getUserAccessListDao() throws SQLException;

	boolean ProvideAccessServiceDao(int selectedUserId, int selectedAccessId) throws SQLException;

	UsersBean GetUserDetailsDao(int selectedUserId)throws SQLException;

	EmpProjListBean LoadProjectDataDao(int userId)throws SQLException;

	List<UsersBean> LoadResourceDataDao(int projectId)throws SQLException;

	Object checkProjectValidityDao()throws SQLException;

	boolean CreateNewTaskDao(NewTasksBean newTaskBean)throws SQLException;

	List<String> LoadProjectDetailsDao(int projectId)throws SQLException;

	List<NewTasksBean> LoadTaskDetailsDao(int projectId)throws SQLException;

	boolean UpdateTaskDao(UpdateTaskBean updateTaskBean) throws SQLException;

	void benchAllocation(int userId) throws SQLException;

	boolean ReleaseResourceDao(List<UsersBean> selectedUsers, int projectId)throws SQLException;

	boolean RequestResourceDao(String resourceType, int resourceNo,int projectId)throws SQLException;


}
