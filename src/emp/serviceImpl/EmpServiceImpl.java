package emp.serviceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.dao.EmpDao;
import emp.daoImpl.EmpDaoImpl;
import emp.model.*;
import emp.service.EmpService;

public class EmpServiceImpl implements EmpService{

	@Override
	public UsersBean LoginService(UsersBean usersBean) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.LoginDao(usersBean);
	}

	@Override
	public boolean CreateNewService(UsersBean usersBean) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.CreateNewDao(usersBean);
	}

	@Override
	public boolean UpdatePassword(UsersBean usersBean) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.UpdatePassword(usersBean);
	}

	@Override
	public UserAccessListBean getUserAccessListService() throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.getUserAccessListDao();
	}

	@Override
	public boolean ProvideAccessService(int selectedUserId, int selectedAccessId) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.ProvideAccessServiceDao(selectedUserId,selectedAccessId);
	}

	@Override
	public UsersBean GetUserDetailsService(int selectedUserId)throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.GetUserDetailsDao(selectedUserId);
	}

	@Override
	public EmpProjListBean LoadProjectDataService(int userId) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.LoadProjectDataDao(userId);
	}
	

	@Override
	public List<UsersBean> LoadResourceDataService(int projectId)
			throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.LoadResourceDataDao(projectId);
	}

	@Override
	public void checkProjectValidity() throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		empDao.checkProjectValidityDao();
	}

	@Override
	public boolean CreateNewTask(NewTasksBean newTaskBean) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.CreateNewTaskDao(newTaskBean);
	}

	@Override
	public List<Date> LoadProjectDetailsService(int projectId)
			throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		List<String> dateSet= empDao.LoadProjectDetailsDao(projectId);
		System.out.println("dateSet "+dateSet);
		List<Date> newDateSet=new ArrayList<Date>();
		for (String data : dateSet) {
			try {
				String[] date=data.split(" ");
				String tempDate=date[2]+"/"+date[1]+"/"+date[5];
				newDateSet.add(new SimpleDateFormat("dd/MMM/yy").parse(tempDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return newDateSet;
	}

	@Override
	public List<NewTasksBean> LoadTaskDetails(int projectId) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.LoadTaskDetailsDao(projectId);
	}

	@Override
	public boolean UpdateTaskService(UpdateTaskBean updateTaskBean)
			throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		return empDao.UpdateTaskDao(updateTaskBean);
	}

	@Override
	public void benchAllocation(int userId) throws SQLException {
		EmpDao empDao=new EmpDaoImpl();
		empDao.benchAllocation(userId);
		
	}

}
