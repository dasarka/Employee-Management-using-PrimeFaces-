package emp.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import emp.model.*;

public interface EmpService {

	UsersBean LoginService(UsersBean usersBean) throws SQLException;

	boolean CreateNewService(UsersBean usersBean) throws SQLException;

	boolean UpdatePassword(UsersBean usersBean) throws SQLException;

	UserAccessListBean getUserAccessListService() throws SQLException;

	boolean ProvideAccessService(int selectedUserId, int selectedAccessId) throws SQLException;

	UsersBean GetUserDetailsService(int selectedUserId) throws SQLException;

	EmpProjListBean LoadProjectDataService(int userId)throws SQLException;

	List<UsersBean> LoadResourceDataService(int projectId)throws SQLException;

	void checkProjectValidity()throws SQLException;

	boolean CreateNewTask(NewTasksBean newTaskBean)throws SQLException;

	List<Date> LoadProjectDetailsService(int projectId)throws SQLException;

	List<NewTasksBean> LoadTaskDetails(int projectId)throws SQLException;

	boolean UpdateTaskService(UpdateTaskBean updateTaskBean)throws SQLException;

	EmpProjListBean LoadInternalProjectDataService(int userId)
			throws SQLException;

	void benchAllocation(int userId)throws SQLException;

}
