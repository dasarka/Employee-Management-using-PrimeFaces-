package emp.serviceImpl;

import java.util.List;

import emp.dao.HRDao;
import emp.daoImpl.HRDaoImpl;
import emp.model.ApprisalBean;
import emp.model.LMSBean;
import emp.model.ProjectBean;
import emp.model.RequestResources;
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

	@Override
	public boolean SubmitApprisalEmployeeService(List<ApprisalBean> apprisalList)
			throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.SubmitApprisalEmployeeDao(apprisalList);
	}

	@Override
	public List<ApprisalBean> apprisalDataService(int userId) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.apprisalDataDao(userId);
	}

	@Override
	public boolean UpdateAppraisalService(List<ApprisalBean> apprisalList)
			throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.UpdateAppraisalDao(apprisalList);
	}

	@Override
	public boolean ProvideLeaveService() throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao. ProvideLeaveDao();
		
	}

	@Override
	public int GetLeaveBalanceService(int userId) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao. GetLeaveBalanceDao(userId);
	}

	@Override
	public List<LMSBean> GetAppliedLeaveService(int userId) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao. GetAppliedLeaveDao(userId);
	}

	@Override
	public boolean ApplyLeaveService(int userId, LMSBean lmsBean,int leaveBalance)
			throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao. ApplyLeaveDao(userId,lmsBean,leaveBalance);
	}

	@Override
	public List<LMSBean> LoadLMSDataService() throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.LoadLMSDataDao();
	}

	@Override
	public boolean UpdateLMSService(List<LMSBean> lmsList) throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.UpdateLMSDao(lmsList);
	}

	@Override
	public List<RequestResources> LoadRequestService() throws Exception {
		HRDao hrDao=new HRDaoImpl();
		return hrDao.LoadRequestDao();
	}

	
}
