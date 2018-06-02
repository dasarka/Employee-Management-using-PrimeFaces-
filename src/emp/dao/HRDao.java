package emp.dao;

import java.util.List;

import emp.model.ApprisalBean;
import emp.model.ProjectBean;
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
}
