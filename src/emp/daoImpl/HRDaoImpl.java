package emp.daoImpl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.connection.SQLConnection;
import emp.dao.HRDao;
import emp.model.ProjectBean;
import emp.model.Timecard;
import emp.model.UsersBean;

public class HRDaoImpl implements HRDao {
	private static SQLConnection connection = null;
	private ResultSet rs = null;
	private ResultSet rsDuplicate = null;
	static {
		connection = new SQLConnection();
	}

	@Override
	public List<ProjectBean> ProjectListDao(int userId) throws Exception {
		List<ProjectBean> projectList=new ArrayList<ProjectBean>();
		String query = "SELECT proj.project_id, proj.project_name FROM emp_project proj,"
				+ " emp_project_allocation alloc, "
				+ "emp_authentication auth "
				+ "where proj.project_id=alloc.project_id "
				+ "and alloc.user_id=auth.user_id "
				+ "and proj.flag='C' and auth.user_id="+userId;
		System.out.println("query " + query);
		rs=null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do{
				projectList.add(new ProjectBean((Integer) rs.getObject("project_id"),
						(String) rs.getObject("project_name")));
			}while(rs.next());
		}
		return projectList;
	}

	@Override
	public boolean NewTimeCardDao(List<Timecard> timecardList) throws Exception {
		boolean flag=false;
		Date date=new Date();
		SimpleDateFormat simpleFormat=new SimpleDateFormat("dd-MMM-yyyy");
		String today=simpleFormat.format(date);
		System.out.println("today "+today);
		String year=today.split("-")[2];
		System.out.println("year "+year);
		String month=today.split("-")[1];
		
		String insertQuery="INSERT INTO emp_timecard "
				+ "(project_id,user_id,month,year,day_mon,day_tue,day_wed,day_thu,day_fri,"
				+ "week_val,submittion_date,status,comment) VALUES (";
		String queryVal="";
		for (Timecard timecard : timecardList) {
			queryVal="";
			String projIds="";
			for(int projectId: timecard.getProject_id()){
				projIds +=projectId+",";
			}
			queryVal +="'"+projIds+"',";
			queryVal +=timecard.getUser_id()+",";
			queryVal +="'"+month+"',";
			queryVal +="'"+year+"',";
			queryVal +=timecard.getDay_mon()+",";
			queryVal +=timecard.getDay_tue()+",";
			queryVal +=timecard.getDay_wed()+",";
			queryVal +=timecard.getDay_thu()+",";
			queryVal +=timecard.getDay_fri()+",";
			queryVal +="'"+timecard.getWeek_val()+"',";
			queryVal +="'"+today+"',";
			queryVal +="'Submitted',''";
			System.out.println("queryVal "+queryVal);
			String finalQuery=insertQuery+queryVal+")";
			System.out.println("finalQuery "+finalQuery);
			if (connection.getICDM(finalQuery) > 0) {
				flag = true;
			}else{
				flag=false;
			}
	
		}
		return flag;
	}

	@Override
	public List<Timecard> ViewTimeCardDao(String month, String year, int userId)
			throws Exception {
		String query="SELECT * FROM emp_timecard"
				+ " where month='"+month+"' and year='"+year+"' and user_id="+userId+";";
		String projQuery="SELECT project_name FROM emp_project where project_id=";
		List<Timecard> results=new ArrayList<Timecard>();
		rs=null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do{
				String projectIds=(String) rs.getObject("project_id");
				String[] projectId=projectIds.split(",");
				String projectNames="";
				for (String id : projectId) {
					rsDuplicate=null;
					rsDuplicate = connection.getResultSet(projQuery+id);
					if (rsDuplicate.next() == false) {

					} else {
						rsDuplicate.absolute(1);
						projectNames +=(String)rsDuplicate.getObject("project_name")+",";
					}
				}
				results.add(new Timecard((Integer)rs.getObject("id"),
						(String)rs.getObject("week_val"),
						projectNames, 
						(Integer)rs.getObject("user_id"),
						(Integer)rs.getObject("day_mon"), 
						(Integer)rs.getObject("day_tue"), 
						(Integer)rs.getObject("day_wed"), 
						(Integer)rs.getObject("day_thu"),
						(Integer)rs.getObject("day_fri"), 
						(String)rs.getObject("submittion_date"), 
						(String)rs.getObject("status"),
						(String)rs.getObject("comment")));
				
			}while(rs.next());
		}
		return results;
	}

	@Override
	public List<UsersBean> FetchAllUsersDao() throws Exception {
		String query="SELECT user_id,emp_name FROM emp_authentication;";
		List<UsersBean> results=new ArrayList<UsersBean>();
		UsersBean user=null;
		rs=null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do{
				user=new UsersBean();
				user.setUserId((Integer)rs.getObject("user_id"));
				user.setEmpName((String)rs.getObject("emp_name"));
				results.add(user);
			}while(rs.next());
		}
		return results;
	}

	@Override
	public boolean UpdateTimecardDao(List<Timecard> hrTimecard)
			throws Exception {
		boolean flag=false;
		for (Timecard timecard : hrTimecard) {
			String query="UPDATE emp_timecard SET "
					+ "status = '"+timecard.getStatus()+"',"
					+ "comment = '"+timecard.getComment()+"'"
					+ "WHERE `id` = "+timecard.getTimecardId()+";";
			if (connection.getICDM(query)>0) {
				flag=true;
			}else{
				flag=false;
				break;
			}
		}
		return false;
	}

}
