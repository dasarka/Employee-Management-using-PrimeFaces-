package emp.service;

import java.util.List;

import emp.model.ApprisalBean;
import emp.model.LMSBean;
import emp.model.ProjectBean;
import emp.model.RequestResources;
import emp.model.Timecard;
import emp.model.UsersBean;
public interface HRService {
	public List<ProjectBean> ProjectListService(int userId) throws Exception;
	public boolean NewTimeCardService(List<Timecard> timecardList) throws Exception;
	public List<Timecard> ViewTimeCardService(String month,String year,int userId) throws Exception;
	public List<UsersBean> FetchAllUsersService()throws Exception;
	public boolean UpdateTimecardService(List<Timecard> hrTimecard)throws Exception;
	public boolean SubmitApprisalEmployeeService(List<ApprisalBean> apprisalList)throws Exception;
	public List<ApprisalBean> apprisalDataService(int userId)throws Exception;
	public boolean UpdateAppraisalService(List<ApprisalBean> apprisalList)throws Exception;
	public boolean ProvideLeaveService()throws Exception;
	public int GetLeaveBalanceService(int userId)throws Exception;
	public List<LMSBean> GetAppliedLeaveService(int userId)throws Exception;
	public boolean ApplyLeaveService(int userId, LMSBean lmsBean, int leaveBalance)throws Exception;
	public List<LMSBean> LoadLMSDataService()throws Exception;
	public boolean UpdateLMSService(List<LMSBean> lmsList)throws Exception;
	public List<RequestResources> LoadRequestService()throws Exception;
}
