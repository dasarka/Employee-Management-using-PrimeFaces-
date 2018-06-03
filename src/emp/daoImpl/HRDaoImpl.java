package emp.daoImpl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import emp.connection.SQLConnection;
import emp.dao.HRDao;
import emp.model.ApprisalBean;
import emp.model.LMSBean;
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
		List<ProjectBean> projectList = new ArrayList<ProjectBean>();
		String query = "SELECT project_id, project_name FROM emp_proj_map "
				+ "where flag='C' and user_id=" + userId;
		System.out.println("query " + query);
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				projectList.add(new ProjectBean((Integer) rs
						.getObject("project_id"), (String) rs
						.getObject("project_name")));
			} while (rs.next());
		}
		return projectList;
	}

	@Override
	public boolean NewTimeCardDao(List<Timecard> timecardList) throws Exception {
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String today = simpleFormat.format(date);
		System.out.println("today " + today);
		String year = today.split("-")[2];
		System.out.println("year " + year);
		String month = today.split("-")[1];

		String insertQuery = "INSERT INTO emp_timecard "
				+ "(project_id,user_id,month,year,day_mon,day_tue,day_wed,day_thu,day_fri,"
				+ "week_val,submittion_date,status,comment) VALUES (";
		String queryVal = "";
		for (Timecard timecard : timecardList) {
			queryVal = "";
			String projIds = "";
			for (int projectId : timecard.getProject_id()) {
				projIds += projectId + ",";
			}
			queryVal += "'" + projIds + "',";
			queryVal += timecard.getUser_id() + ",";
			queryVal += "'" + month + "',";
			queryVal += "'" + year + "',";
			queryVal += timecard.getDay_mon() + ",";
			queryVal += timecard.getDay_tue() + ",";
			queryVal += timecard.getDay_wed() + ",";
			queryVal += timecard.getDay_thu() + ",";
			queryVal += timecard.getDay_fri() + ",";
			queryVal += "'" + timecard.getWeek_val() + "',";
			queryVal += "'" + today + "',";
			queryVal += "'Submitted',''";
			System.out.println("queryVal " + queryVal);
			String finalQuery = insertQuery + queryVal + ")";
			System.out.println("finalQuery " + finalQuery);
			if (connection.getICDM(finalQuery) > 0) {
				flag = true;
			} else {
				flag = false;
			}

		}
		return flag;
	}

	@Override
	public List<Timecard> ViewTimeCardDao(String month, String year, int userId)
			throws Exception {
		String query = "SELECT * FROM emp_timecard" + " where month='" + month
				+ "' and year='" + year + "' and user_id=" + userId + ";";
		String projQuery = "SELECT project_name FROM emp_project where project_id=";
		List<Timecard> results = new ArrayList<Timecard>();
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				String projectIds = (String) rs.getObject("project_id");
				String[] projectId = projectIds.split(",");
				String projectNames = "";
				for (String id : projectId) {
					rsDuplicate = null;
					rsDuplicate = connection.getResultSet(projQuery + id);
					if (rsDuplicate.next() == false) {

					} else {
						rsDuplicate.absolute(1);
						projectNames += (String) rsDuplicate
								.getObject("project_name") + ",";
					}
				}
				results.add(new Timecard((Integer) rs.getObject("id"),
						(String) rs.getObject("week_val"), projectNames,
						(Integer) rs.getObject("user_id"), (Integer) rs
								.getObject("day_mon"), (Integer) rs
								.getObject("day_tue"), (Integer) rs
								.getObject("day_wed"), (Integer) rs
								.getObject("day_thu"), (Integer) rs
								.getObject("day_fri"), (String) rs
								.getObject("submittion_date"), (String) rs
								.getObject("status"), (String) rs
								.getObject("comment")));

			} while (rs.next());
		}
		return results;
	}

	@Override
	public List<UsersBean> FetchAllUsersDao() throws Exception {
		String query = "SELECT user_id,emp_name FROM emp_authentication;";
		List<UsersBean> results = new ArrayList<UsersBean>();
		UsersBean user = null;
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				user = new UsersBean();
				user.setUserId((Integer) rs.getObject("user_id"));
				user.setEmpName((String) rs.getObject("emp_name"));
				results.add(user);
			} while (rs.next());
		}
		return results;
	}

	@Override
	public boolean UpdateTimecardDao(List<Timecard> hrTimecard)
			throws Exception {
		boolean flag = false;
		for (Timecard timecard : hrTimecard) {
			String query = "UPDATE emp_timecard SET " + "status = '"
					+ timecard.getStatus() + "'," + "comment = '"
					+ timecard.getComment() + "'" + "WHERE `id` = "
					+ timecard.getTimecardId() + ";";
			if (connection.getICDM(query) > 0) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return false;
	}

	@Override
	public boolean SubmitApprisalEmployeeDao(List<ApprisalBean> apprisalList)
			throws Exception {
		boolean flag = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("year " + year);
		String insertQuery = "INSERT INTO emp_apprisal(user_id,objective,employee_comment,status,year) VALUES (";
		String completeQuery = "";
		for (ApprisalBean apprisalBean : apprisalList) {
			completeQuery = insertQuery + apprisalBean.getUserId() + ",'"
					+ apprisalBean.getObjective() + "'" + ",'"
					+ apprisalBean.getEmpComment() + "'" + ",'Submitted',"
					+ year + ");";
			System.out.println("completeQuery " + completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public List<ApprisalBean> apprisalDataDao(int userId) throws Exception {
		List<ApprisalBean> apprisalList = new ArrayList<ApprisalBean>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("year " + year);
		String query = "SELECT * FROM emp_apprisal where user_id=" + userId
				+ " AND year=" + year;
		System.out.println("query " + query);
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				apprisalList.add(new ApprisalBean((Integer) rs
						.getObject("user_id"), (Integer) rs
						.getObject("appraisal_id"), (String) rs
						.getObject("objective"), (String) rs
						.getObject("employee_comment"), (String) rs
						.getObject("hr_comment"), (Integer) rs
						.getObject("rating")));
			} while (rs.next());
		}
		return apprisalList;
	}

	@Override
	public boolean UpdateAppraisalDao(List<ApprisalBean> apprisalList)
			throws Exception {
		boolean flag = false;
		String updateQuery = "UPDATE emp_apprisal SET ";
		String data = "hr_comment = 'emp_hr_comment',rating = emp_rating,status = 'complete' ";
		String clause = "WHERE appraisal_id =";
		String completeQuery = "";
		for (ApprisalBean apprisalBean : apprisalList) {
			completeQuery = "";
			completeQuery = updateQuery
					+ data.replace("emp_hr_comment",
							apprisalBean.getHrComment()).replace("emp_rating",
							String.valueOf(apprisalBean.getRating())) + clause
					+ apprisalBean.getAppraisalId();

			System.out.println("completeQuery " + completeQuery);

			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		return flag;
	}

	@Override
	public boolean ProvideLeaveDao() throws Exception {
		System.out.println("ProvideLeaveDao");
		boolean flag = false;
		String query = "SELECT * FROM emp_authentication;";
		String updateQuery = "UPDATE emp_authentication SET leave_balance = ";
		String updateClause = " WHERE user_id = ";
		int userId = 0;
		int leaveBal = 0;
		String completeQuery = "";
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				userId = (int) rs.getObject("user_id");
				leaveBal = (int) rs.getObject("leave_balance") + 2;
				completeQuery = updateQuery + leaveBal + updateClause + userId;
				System.out.println("completeQuery " + completeQuery);
				if (connection.getICDM(completeQuery) > 0) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			} while (rs.next());
		}
		return flag;

	}

	@Override
	public int GetLeaveBalanceDao(int userId) throws Exception {
		String query = "SELECT leave_balance FROM emp_authentication WHERE user_id="
				+ userId;
		System.out.println("GetLeaveBalanceDao " + query);
		int leaveBalance = 0;
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			leaveBalance = (int) rs.getObject("leave_balance");
		}
		return leaveBalance;
	}

	@Override
	public List<LMSBean> GetAppliedLeaveDao(int userId) throws Exception {
		List<LMSBean> lmsList = new ArrayList<LMSBean>();
		String query = "SELECT * FROM ems_lms_data WHERE user_id=" + userId;
		System.out.println("GetAppliedLeaveDao " + query);
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				lmsList.add(new LMSBean((String) rs
						.getObject("leave_start_date"), (String) rs
						.getObject("leave_end_date"), (String) rs
						.getObject("leave_comments"), (int) rs
						.getObject("leave_taken"), (String) rs
						.getObject("leave_status")));
			} while (rs.next());
		}
		return lmsList;
	}

	@Override
	public boolean ApplyLeaveDao(int userId, LMSBean lmsBean, int leaveBalance)
			throws Exception {
		boolean flag = false;
		String query = "INSERT INTO ems_lms_data "
				+ "(user_id,leave_start_date,leave_end_date,leave_taken,leave_status,leave_comments) "
				+ "VALUES (" + "" + userId + "," + "'" + lmsBean.getStartDate()
				+ "'," + "'" + lmsBean.getEndDate() + "'," + ""
				+ lmsBean.getLeaveCount() + "," + "'Submitted'," + "'"
				+ lmsBean.getComments() + "')";
		String updateQuery = "UPDATE emp_authentication SET "
				+ "leave_balance = " + (leaveBalance - lmsBean.getLeaveCount())
				+ " WHERE user_id =" + userId;
		System.out.println("ApplyLeaveDao " + query);
		System.out.println("updateQuery " + updateQuery);
		if (connection.getICDM(query) > 0) {
			flag = true;
			if (connection.getICDM(updateQuery) > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<LMSBean> LoadLMSDataDao() throws Exception {
		List<LMSBean> lmsList = new ArrayList<LMSBean>();
		String query = "SELECT "
				+ "auth.emp_name,auth.user_id,lms.leave_id,lms.leave_start_date,lms.leave_end_date,"
				+ "lms.leave_comments, lms.leave_taken "
				+ "FROM ems_lms_data lms INNER JOIN emp_authentication auth "
				+ "where lms.user_id=auth.user_id and lms.leave_status='Submitted'";
		System.out.println("GetAppliedLeaveDao " + query);
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				lmsList.add(new LMSBean((String) rs
						.getObject("leave_start_date"), (String) rs
						.getObject("leave_end_date"), (String) rs
						.getObject("leave_comments"), (int) rs
						.getObject("leave_taken"), (String) rs
						.getObject("emp_name"), (int) rs.getObject("user_id"),
						(int) rs.getObject("leave_id")));
			} while (rs.next());
		}
		return lmsList;
	}

	@Override
	public boolean UpdateLMSDao(List<LMSBean> lmsList) throws Exception {
		boolean flag = false;
		System.out.println("UpdateLMSDao");
		String updateLMS = "UPDATE ems_lms_data SET leave_status=";
		String lmsClause = " WHERE leave_id = ";
		String getLeaveBal = "SELECT leave_balance FROM emp_authentication where user_id=";
		String resetLeave = "UPDATE emp_authentication SET leave_balance = ";
		String resetLeaveClause = " WHERE user_id =";
		String getLMSId="SELECT project_id FROM emp_project where project_name ='LMS Project'";
		String insertAllocation = "INSERT INTO emp_project_allocation "
				+ "(user_id,project_id,lms_start_date,lms_end_date) VALUES (";
		String completeLMS = "";
		String completeResetLeave = "";
		String completeQuery="";
		int lmsProjId=0;
		rs = null;
		rs = connection.getResultSet(getLMSId);
		if (rs.next() == false) {
			flag=false;
		} else {
			rs.absolute(1);
			lmsProjId=(int) rs.getObject("project_id");
			for (LMSBean lmsBean : lmsList) {
				completeLMS = updateLMS + "'" + lmsBean.getStatus() + "'"
						+ lmsClause + lmsBean.getLeaveId();
				System.out.println("completeLMS " + completeLMS);
				if (connection.getICDM(completeLMS) > 0) {
					flag = true;
					if (lmsBean.getStatus().equalsIgnoreCase("Rejected")) {
						rs = null;
						rs = connection.getResultSet(getLeaveBal
								+ lmsBean.getUserId());
						if (rs.next() == false) {

						} else {
							rs.absolute(1);
							completeResetLeave = resetLeave
									+ ((int) rs.getObject("leave_balance") + lmsBean
											.getLeaveCount()) + resetLeaveClause
									+ lmsBean.getUserId();
							System.out.println("completeResetLeave "
									+ completeResetLeave);
							if (connection.getICDM(completeResetLeave) > 0) {
								flag = true;
							} else {
								flag = false;
								break;
							}
						}
					} else {
						completeQuery=insertAllocation
								+""+lmsBean.getUserId()+","
								+""+lmsProjId+","
								+"'"+lmsBean.getStartDate()+"',"
								+"'"+lmsBean.getEndDate()+"')";
						System.out.println("completeQuery "
								+ completeQuery);
						if (connection.getICDM(completeQuery) > 0) {
							flag = true;
						} else {
							flag = false;
							break;
						}
					}
				} else {
					flag = false;
				}
			}
		}
		
		return flag;
	}

}
