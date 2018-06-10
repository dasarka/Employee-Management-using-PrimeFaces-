package emp.dao;

import java.util.List;

import emp.model.ApprisalBean;
import emp.model.LMSBean;
import emp.model.ProjectBean;
import emp.model.RequestResources;
import emp.model.Timecard;
import emp.model.UsersBean;

public interface HRDao {
	public List<ProjectBean> ProjectListDao(int userId) throws Exception;
	public boolean NewTimeCardDao(List<Timecard> timecardList) throws Exception;
	public List<Timecard> ViewTimeCardDao(String month,String year,int userId) throws Exception;
	public List<UsersBean> FetchAllUsersDao()throws Exception;
	public boolean UpdateTimecardDao(List<Timecard> hrTimecard)throws Exception;
	public boolean SubmitApprisalEmployeeDao(List<ApprisalBean> apprisalList)throws Exception;
	public List<ApprisalBean> apprisalDataDao(int userId)throws Exception;
	public boolean UpdateAppraisalDao(List<ApprisalBean> apprisalList)throws Exception;
	public boolean ProvideLeaveDao()throws Exception;
	public int GetLeaveBalanceDao(int userId)throws Exception;
	public List<LMSBean> GetAppliedLeaveDao(int userId)throws Exception;
	public boolean ApplyLeaveDao(int userId, LMSBean lmsBean, int leaveBalance)throws Exception;
	public List<LMSBean> LoadLMSDataDao()throws Exception;
	public boolean UpdateLMSDao(List<LMSBean> lmsList)throws Exception;
	public List<RequestResources> LoadRequestDao()throws Exception;
	public boolean UpdateExistingAllocationDao(
			RequestResources selectedReqResBean)throws Exception;
}
