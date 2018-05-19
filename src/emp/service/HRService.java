package emp.service;

import java.util.List;

import emp.model.ProjectBean;
import emp.model.Timecard;
import emp.model.UsersBean;
public interface HRService {
	public List<ProjectBean> ProjectListService(int userId) throws Exception;
	public boolean NewTimeCardService(List<Timecard> timecardList) throws Exception;
	public List<Timecard> ViewTimeCardService(String month,String year,int userId) throws Exception;
	public List<UsersBean> FetchAllUsersService()throws Exception;
	public boolean UpdateTimecardService(List<Timecard> hrTimecard)throws Exception;
}
