package emp.serviceImpl;

import java.util.List;

import emp.dao.HRDao;
import emp.daoImpl.HRDaoImpl;
import emp.model.ProjectBean;
import emp.model.Timecard;
import emp.model.UsersBean;
import emp.service.HRService;

public class HRServiceImpl implements HRService{

	@Override
	public List<ProjectBean> ProjectListService(int userId) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.ProjectListDao(userId);
	}

	@Override
	public boolean NewTimeCardService(List<Timecard> timecardList) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.NewTimeCardDao(timecardList);
	}

	@Override
	public List<Timecard> ViewTimeCardService(String month, String year,
			int userId) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.ViewTimeCardDao(month, year, userId);
	}

	@Override
	public List<UsersBean> FetchAllUsersService() throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.FetchAllUsersDao();
	}

	@Override
	public boolean UpdateTimecardService(List<Timecard> hrTimecard)
			throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.UpdateTimecardDao(hrTimecard);
	}

	
}
