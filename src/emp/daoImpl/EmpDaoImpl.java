package emp.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.connection.SQLConnection;
import emp.dao.EmpDao;
import emp.model.AccessBean;
import emp.model.EmpProjListBean;
import emp.model.EmpProjViewBean;
import emp.model.EmpResourceBean;
import emp.model.NewTasksBean;
import emp.model.UpdateTaskBean;
import emp.model.UserAccessListBean;
import emp.model.UsersBean;

public class EmpDaoImpl implements EmpDao {

	private static SQLConnection connection = null;
	private ResultSet rs = null;
	private ResultSet rsDuplicate = null;
	static {
		connection = new SQLConnection();
	}

	@Override
	public UsersBean LoginDao(UsersBean usersBean) throws SQLException {
		System.out.println("users dao login " + usersBean);
		rs = null;
		String query = "SELECT * FROM emp_authentication where user_name='"
				+ usersBean.getUsername() + "' and password='"
				+ usersBean.getPassword() + "'";
		String accessQuery = "SELECT accessVal FROM emp_access where accessId =";
		System.out.println("query " + query);
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			usersBean = new UsersBean(Integer.valueOf(String.valueOf(rs
					.getObject("user_id"))), String.valueOf(rs
					.getObject("user_name")), String.valueOf(rs
					.getObject("password")), String.valueOf(rs
					.getObject("emp_name")), String.valueOf(rs
					.getObject("emp_desg")), Integer.valueOf(String.valueOf(rs
					.getObject("emp_remainHours"))));
			int accessId = Integer.valueOf(String.valueOf(rs
					.getObject("emp_access")));
			if (accessId > 0) {
				accessQuery += accessId;
				rs = connection.getResultSet(accessQuery);
				if (rs.next() == false) {

				} else {
					usersBean.setAccessVal(String.valueOf(rs
							.getObject("accessVal")));
				}

			}
		}
		return usersBean;
	}

	@Override
	public boolean CreateNewDao(UsersBean usersBean) throws SQLException {
		boolean flag = false;
		System.out.println("users dao create new " + usersBean);

		String query = "INSERT INTO emp_authentication ( user_name, password, emp_name, emp_desg,emp_access) VALUES ("
				+ "'"
				+ usersBean.getUsername()
				+ "',"
				+ "'"
				+ usersBean.getPassword()
				+ "',"
				+ "'"
				+ usersBean.getEmpName()
				+ "'," + "'" + usersBean.getEmpDesg() + "'" + ", 1 );";
		System.out.println("query " + query);

		if (connection.getICDM(query) > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean UpdatePassword(UsersBean usersBean) throws SQLException {
		boolean flag = false;
		System.out.println("users dao update password" + usersBean);
		String query = "UPDATE emp_authentication SET password = '"
				+ usersBean.getPassword() + "'" + "WHERE user_id = "
				+ usersBean.getUserId();
		System.out.println("query " + query);

		if (connection.getICDM(query) > 0) {
			flag = true;
		}

		return flag;
	}

	@Override
	public UserAccessListBean getUserAccessListDao() throws SQLException {
		List<UsersBean> usersList = new ArrayList<UsersBean>();
		List<AccessBean> accessList = new ArrayList<AccessBean>();
		System.out.println("inside getUserAccessListDao");
		rs = null;
		String query = "SELECT * FROM emp_authentication";
		String accessQuery = "SELECT * FROM emp_access";
		System.out.println("query " + query);
		System.out.println("accessQuery " + accessQuery);
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				usersList.add(new UsersBean(Integer.valueOf(String.valueOf(rs
						.getObject("user_id"))), String.valueOf(rs
						.getObject("user_name")), String.valueOf(rs
						.getObject("password")), String.valueOf(rs
						.getObject("emp_name")), String.valueOf(rs
						.getObject("emp_desg"))));
			} while (rs.next());
		}
		rs = null;
		rs = connection.getResultSet(accessQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				accessList.add(new AccessBean(Integer.valueOf(String.valueOf(rs
						.getObject("accessId"))), String.valueOf(rs
						.getObject("accessVal"))));
			} while (rs.next());
		}
		System.out.println("users " + usersList);
		System.out.println("access " + accessList);
		return new UserAccessListBean(usersList, accessList, 0, 1);
	}

	@Override
	public boolean ProvideAccessServiceDao(int selectedUserId,
			int selectedAccessId) throws SQLException {
		boolean flag = false;
		System.out.println("inside ProvideAccessServiceDao");
		String query = "UPDATE emp_authentication SET emp_access = "
				+ selectedAccessId + " WHERE user_id = " + selectedUserId;
		System.out.println("query " + query);

		if (connection.getICDM(query) > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public UsersBean GetUserDetailsDao(int selectedUserId) throws SQLException {
		System.out.println("usersid dao login " + selectedUserId);
		UsersBean usersBean = null;
		rs = null;
		String query = "SELECT * FROM emp_authentication where user_id="
				+ selectedUserId;
		String accessQuery = "SELECT accessVal FROM emp_access where accessId =";
		System.out.println("query " + query);
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			usersBean = new UsersBean(Integer.valueOf(String.valueOf(rs
					.getObject("user_id"))), String.valueOf(rs
					.getObject("user_name")), String.valueOf(rs
					.getObject("password")), String.valueOf(rs
					.getObject("emp_name")), String.valueOf(rs
					.getObject("emp_desg")));
			int accessId = Integer.valueOf(String.valueOf(rs
					.getObject("emp_access")));
			if (accessId > 0) {
				accessQuery += accessId;
				rs = connection.getResultSet(accessQuery);
				if (rs.next() == false) {

				} else {
					usersBean.setAccessVal(String.valueOf(rs
							.getObject("accessVal")));
				}

			}
		}
		return usersBean;
	}

	@Override
	public EmpProjListBean LoadProjectDataDao(int userId) throws SQLException {
		EmpProjViewBean projViewBean;
		List<EmpProjViewBean> tempProjList = new ArrayList<EmpProjViewBean>();
		List<EmpProjViewBean> tempProjList1 = new ArrayList<EmpProjViewBean>();
		List<EmpProjViewBean> tempProjList2 = new ArrayList<EmpProjViewBean>();
		Date currDate = new Date();
		String progressQuery = "SELECT  avg(task_status) AS progress_raw,count(distinct task_id) from emp_task where project_id= ";

		String currQuery = "SELECT * FROM emp_proj_map where user_id=" + userId
				+ " and flag='C';";

		String upcQuery = "SELECT * FROM emp_proj_map where user_id=" + userId
				+ " and flag='U';";
		String oldQuery = "SELECT * FROM emp_proj_map where user_id=" + userId
				+ " and flag='O';";

		System.out.println("currQuery " + currQuery);
		System.out.println("upcQuery " + upcQuery);
		System.out.println("oldQuery " + oldQuery);
		// set current project
		rs = null;
		rs = connection.getResultSet(currQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				String projectName = String.valueOf(rs
						.getObject("project_name"));
				if (projectName.equals("LMS Project")) {
					projViewBean = new EmpProjViewBean(Integer.valueOf(String
							.valueOf(rs.getObject("project_id"))), projectName,
							String.valueOf(rs.getObject("lms_start_date")),
							String.valueOf(rs.getObject("lms_end_date")),
							String.valueOf(rs.getObject("onsite_manager")),
							String.valueOf(rs.getObject("client_name")));
				} else {
					projViewBean = new EmpProjViewBean(Integer.valueOf(String
							.valueOf(rs.getObject("project_id"))), projectName,
							String.valueOf(rs.getObject("start_date")),
							String.valueOf(rs.getObject("end_date")),
							String.valueOf(rs.getObject("onsite_manager")),
							String.valueOf(rs.getObject("client_name")));
				}
				rsDuplicate = null;
				System.out.println("progress query " + progressQuery
						+ projViewBean.getProjectId());
				rsDuplicate = connection.getResultSet(progressQuery
						+ projViewBean.getProjectId());
				if (rsDuplicate.next() == false) {

				} else {
					rsDuplicate.absolute(1);
					try {
						Double progress_raw = Double
								.valueOf(String.valueOf(rsDuplicate
										.getObject("progress_raw")));

						Double progress = Math.ceil(progress_raw * 10);

						System.out.println("progress " + progress);
						projViewBean.setProgress(progress);
					} catch (Exception e) {

					}

				}

				tempProjList.add(projViewBean);
			} while (rs.next());
		}

		// set upcoming project
		rs = null;
		rs = connection.getResultSet(upcQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				projViewBean = new EmpProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						String.valueOf(rs.getObject("project_name")),
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						String.valueOf(rs.getObject("onsite_manager")),
						String.valueOf(rs.getObject("client_name")));
				tempProjList1.add(projViewBean);
			} while (rs.next());
		}

		// set old project
		rs = null;
		rs = connection.getResultSet(oldQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				projViewBean = new EmpProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						String.valueOf(rs.getObject("project_name")),
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						String.valueOf(rs.getObject("onsite_manager")),
						String.valueOf(rs.getObject("client_name")));
				tempProjList2.add(projViewBean);
			} while (rs.next());
		}

		return new EmpProjListBean(tempProjList, tempProjList1, tempProjList2);

	}

	@Override
	public List<UsersBean> LoadResourceDataDao(int projectId)
			throws SQLException {
		List<UsersBean> dataList = new ArrayList<UsersBean>();
		String query = "SELECT auth.user_id, auth.emp_name,auth.emp_desg,alloc.working_hours,acc.accessVal"
				+ " FROM emp_project_allocation alloc INNER JOIN emp_authentication auth INNER JOIN emp_access acc"
				+ " WHERE alloc.user_id=auth.user_id AND auth.emp_access=acc.accessId"
				+ " AND alloc.project_id=" + projectId;
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				dataList.add(new UsersBean(Integer.valueOf(String.valueOf(rs
						.getObject("user_id"))), String.valueOf(rs
						.getObject("emp_name")), String.valueOf(rs
						.getObject("emp_desg")), String.valueOf(rs
						.getObject("accessVal")), Integer.valueOf(String
						.valueOf(rs.getObject("working_hours")))));
			} while (rs.next());
		}
		return dataList;
	}

	@Override
	public Object checkProjectValidityDao() throws SQLException {
		String curr_oldSelectQuery = "SELECT project_id,start_date,end_date FROM emp_project where flag='C'";
		String up_currSelectQuery = "SELECT project_id,start_date,end_date FROM emp_project where flag='U'";
		String up_currUpdateQuery = "UPDATE emp_project SET flag='C' WHERE project_id = ";
		String curr_oldUpdateQuery = "UPDATE emp_project SET flag='O' WHERE project_id = ";

		String resUpdateQuery = "UPDATE emp_authentication SET emp_remainHours = emp_remainHours+";
		String resTempQuery = "(SELECT working_hours FROM emp_project_allocation where user_id= ";
		String resProjQuery = " AND project_id= ";
		String resWhereClause = ") WHERE user_id = ";
		String resSelectQuery = "SELECT user_id FROM emp_project_allocation where project_id= ";
		String resAllocUpdateQuery = "UPDATE emp_project_allocation SET working_hours = 0 WHERE project_id =";

		Date currDate = null;
		try {
			currDate = new SimpleDateFormat("dd/MMM/yy")
					.parse(new SimpleDateFormat("dd/MMM/yy").format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs = null;
		rs = connection.getResultSet(curr_oldSelectQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {

				System.out.println("currDate " + currDate);
				String[] startdate = String.valueOf(rs.getObject("end_date"))
						.split(" ");
				String tempStartDate = startdate[2] + "/" + startdate[1] + "/"
						+ startdate[5];
				Date startDate = null;
				try {
					startDate = new SimpleDateFormat("dd/MMM/yy")
							.parse(tempStartDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("startDate " + startDate);
				if (startDate.compareTo(currDate) < 0) {
					if (connection.getICDM(curr_oldUpdateQuery
							+ Integer.valueOf(String.valueOf(rs
									.getObject("project_id")))) > 0) {
						System.out.println("update");

						rsDuplicate = null;
						rsDuplicate = connection.getResultSet(resSelectQuery
								+ Integer.valueOf(String.valueOf(rs
										.getObject("project_id"))));
						if (rsDuplicate.next() == false) {

						} else {
							rsDuplicate.absolute(1);
							do {
								if (connection
										.getICDM(resUpdateQuery
												+ resTempQuery
												+ Integer.valueOf(String.valueOf(rsDuplicate
														.getObject("user_id")))
												+ resProjQuery
												+ Integer.valueOf(String.valueOf(rs
														.getObject("project_id")))
												+ resWhereClause
												+ Integer.valueOf(String.valueOf(rsDuplicate
														.getObject("user_id")))) > 0) {
									System.out.println("Relese all");
								}

							} while (rsDuplicate.next());
							if (connection.getICDM(resAllocUpdateQuery
									+ Integer.valueOf(String.valueOf(rs
											.getObject("project_id")))) > 0) {
								System.out.println("reset");
							}
						}

					}
				}
			} while (rs.next());
		}

		rs = null;
		rs = connection.getResultSet(up_currSelectQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {

				System.out.println("currDate " + currDate);
				String[] startdate = String.valueOf(rs.getObject("start_date"))
						.split(" ");
				String tempStartDate = startdate[2] + "/" + startdate[1] + "/"
						+ startdate[5];
				Date startDate = null;
				try {
					startDate = new SimpleDateFormat("dd/MMM/yy")
							.parse(tempStartDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("startDate " + startDate);
				if (startDate.compareTo(currDate) == 0) {
					if (connection.getICDM(up_currUpdateQuery
							+ Integer.valueOf(String.valueOf(rs
									.getObject("project_id")))) > 0) {
						System.out.println("update");
					}
				}
			} while (rs.next());
		}

		return null;
	}

	@Override
	public boolean CreateNewTaskDao(NewTasksBean newTaskBean)
			throws SQLException {
		boolean flag = false;
		String insertQuery = "INSERT INTO emp_task "
				+ "(task_name, project_id, user_id, end_date, task_desc, task_status) VALUES ( "
				+ "'" + newTaskBean.getTaskName() + "', " + ""
				+ newTaskBean.getProjcetId() + ", " + ""
				+ newTaskBean.getResourceId() + ", " + "'"
				+ newTaskBean.getEndDate() + "', " + "'"
				+ newTaskBean.getDescription() + "', " + ""
				+ newTaskBean.getTaskStatus() + ") ";
		System.out.println("CreateNewTaskDao/insertQuery " + insertQuery);

		if (connection.getICDM(insertQuery) > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<String> LoadProjectDetailsDao(int projectId)
			throws SQLException {
		String query = "SELECT start_date,end_date FROM emp_project where project_id= "
				+ projectId;
		System.out.println("query " + query);
		List<String> dateSet = new ArrayList<String>();
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			dateSet.add(String.valueOf(rs.getObject("start_date")));
			dateSet.add(String.valueOf(rs.getObject("end_date")));
		}
		System.out.println("dateSet " + dateSet);
		return dateSet;
	}

	@Override
	public List<NewTasksBean> LoadTaskDetailsDao(int projectId)
			throws SQLException {
		String query = "SELECT  "
				+ "task.task_id, task.task_name,auth.user_name,task.end_date,task.task_desc,task.task_status "
				+ "FROM emp_task task INNER JOIN emp_authentication auth "
				+ "WHERE task.user_id=auth.user_id AND task.project_id= "
				+ projectId;
		System.out.println("LoadTaskDetailsDao/query " + query);
		List<NewTasksBean> taskList = new ArrayList<NewTasksBean>();
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				taskList.add(new NewTasksBean(Integer.valueOf(String.valueOf(rs
						.getObject("task_id"))), String.valueOf(rs
						.getObject("task_name")), String.valueOf(rs
						.getObject("user_name")), String.valueOf(rs
						.getObject("task_desc")), String.valueOf(rs
						.getObject("end_date")), Integer.valueOf(String
						.valueOf(rs.getObject("task_status")))));
			} while (rs.next());
		}

		return taskList;
	}

	@Override
	public boolean UpdateTaskDao(UpdateTaskBean updateTaskBean)
			throws SQLException {
		boolean flag = false;
		String updateQuery = "UPDATE emp_task SET task_status=";
		String whereClause = " WHERE task_id =";
		String completeQuery = "";
		for (NewTasksBean data : updateTaskBean.getTasksList()) {
			completeQuery = updateQuery + data.getTaskStatus() + whereClause
					+ data.getTaskId();
			System.out.println("UpdateTaskDao/completeQuery " + completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			} else {
				flag = false;
			}
		}

		return flag;
	}

	@Override
	public void benchAllocation(int userId) throws SQLException {
		String checkReleaseBench= "SELECT * FROM emp_proj_map WHERE user_id="+userId+" and flag='C' and project_name not in ('Bench Project','Internal Project','LMS Project')";
		String releaseBenchQuery = "DELETE FROM emp_project_allocation WHERE allocation_id =";
		String findBecnhAllocId="SELECT * FROM emp_project_allocation where user_id="+userId+" AND project_id=";
		
		String findbenchProj = "SELECT project_id FROM emp_project where project_name='Bench Project'";
		String benchConfirmation = "SELECT * FROM emp_avail_resource where emp_access not in (2,6,7) "
				+ "and user_id="
				+ userId
				+ " and user_id not in (SELECT user_id FROM emp_proj_map where (working_hours<>0 "
				+ "or project_name  in('Internal Project','Bench Project','LMS Project')) and flag='C')";
		String benchAllocation = "INSERT INTO emp_project_allocation(user_id,project_id)VALUES("
				+ userId + ",";
		System.out.println("findbenchProj " + findbenchProj);
		rs = null;
		rs = connection.getResultSet(findbenchProj);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			int projectId = (int) rs.getObject("project_id");
			System.out.println("benchConfirmation " + benchConfirmation);
			rs = null;
			rs = connection.getResultSet(benchConfirmation);
			if (rs.next() == false) {
				
			} else {
				benchAllocation += projectId + ")";
				System.out.println("benchAllocation " + benchAllocation);
				connection.getICDM(benchAllocation);
			}
			
			System.out.println("checkReleaseBench " +checkReleaseBench);
			rs = null;
			rs = connection.getResultSet(checkReleaseBench);
			if (rs.next() == false) {

			} else {
				rs.absolute(1);
				rsDuplicate=null;
				System.out.println("findBecnhAllocId "+findBecnhAllocId+projectId);
				rsDuplicate = connection.getResultSet(findBecnhAllocId+projectId);
				if (rsDuplicate.next() == false) {

				} else {
					rsDuplicate.absolute(1);
					int allocId=(int) rsDuplicate.getObject("allocation_id");
					System.out.println("Query "+releaseBenchQuery+allocId);
					connection.getICDM(releaseBenchQuery+allocId);
				}
			}
		}

	}

	@Override
	public boolean ReleaseResourceDao(List<UsersBean> selectedUsers,
			int projectId) throws SQLException {
		boolean flag = false;
		String selectQuery = "SELECT allocation_id,working_hours FROM emp_project_allocation where project_id="
				+ projectId + " and user_id=";
		String updateQuery = "DELETE FROM emp_project_allocation WHERE allocation_id =";
		String selectQuery1 = "SELECT emp_remainHours FROM emp_authentication where user_id=";
		String updateQuery1 = "UPDATE emp_authentication SET emp_remainHours = ";
		String updateQuery1Clause = " WHERE user_id =";
		int workingHours = 0;
		int remainHours = 0;
		int allocId = -1;
		for (UsersBean usersBean : selectedUsers) {
			workingHours = 0;
			remainHours = 0;
			allocId = -1;
			System.out.println("query1 " + selectQuery + usersBean.getUserId());
			rs = null;
			rs = connection.getResultSet(selectQuery + usersBean.getUserId());
			if (rs.next() == false) {

			} else {
				rs.absolute(1);
				workingHours = (int) rs.getObject("working_hours");
				allocId = (int) rs.getObject("allocation_id");
			}
			System.out
					.println("query2 " + selectQuery1 + usersBean.getUserId());
			rs = null;
			rs = connection.getResultSet(selectQuery1 + usersBean.getUserId());
			if (rs.next() == false) {

			} else {
				rs.absolute(1);
				remainHours = (int) rs.getObject("emp_remainHours");
			}
			System.out.println("query3 " + updateQuery + allocId);
			if (connection.getICDM(updateQuery + allocId) > 0) {
				flag = true;
				System.out.println("query4 " + updateQuery1
						+ (remainHours + workingHours) + updateQuery1Clause
						+ usersBean.getUserId());
				if (connection.getICDM(updateQuery1
						+ (remainHours + workingHours) + updateQuery1Clause
						+ usersBean.getUserId()) > 0) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean RequestResourceDao(String resourceType, int resourceNo,int projectId)
			throws SQLException {
		String query="INSERT INTO emp_request (request_type, request_no,project_id) VALUES ("
				+"'"+resourceType+"',"
				+""+resourceNo+","
				+""+projectId+""
				+ ");";
		System.out.println("query "+query);
		boolean flag=false;
		if(connection.getICDM(query)>0){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
}
