package emp.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.connection.SQLConnection;
import emp.dao.ClientDao;
import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.UsersBean;

public class ClientDaoImpl implements ClientDao {
	private static SQLConnection connection = null;
	private ResultSet rs = null;
	static {
		connection = new SQLConnection();
	}

	@Override
	public boolean CreateProjectDao(ClientProjViewBean projViewBean,UsersBean usersbean) throws SQLException {
		boolean flag = false;
		System.out.println("client dao create new " + projViewBean);
		char projectType = 0;

		try {
			Date currDate;
			currDate = new SimpleDateFormat("dd/MMM/yy")
					.parse(new SimpleDateFormat("dd/MMM/yy").format(new Date()));
			System.out.println("currDate " + currDate);
			String[] startdate = projViewBean.getStartDate().split(" ");
			String tempStartDate = startdate[2] + "/" + startdate[1] + "/"
					+ startdate[5];
			Date startDate = new SimpleDateFormat("dd/MMM/yy")
					.parse(tempStartDate);
			System.out.println("startDate " + startDate);
			if (startDate.compareTo(currDate) == 0) {
				projectType = 'C';
			} else if (startDate.compareTo(currDate) > 0) {
				projectType = 'U';
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "INSERT INTO emp_project ( project_name, start_date, end_date, resources,budget,client_name,flag) VALUES ("
				+ "'"
				+ projViewBean.getProjectName()
				+ "',"
				+ "'"
				+ projViewBean.getStartDate()
				+ "',"
				+ "'"
				+ projViewBean.getEndDate()
				+ "',"
				+ ""
				+ projViewBean.getResources()
				+ ""
				+ ","
				+ projViewBean.getBudget()
				* projViewBean.getResources()
				+ ""
				+ ",'" + usersbean.getEmpName() + "'" + ",'" + projectType + "' );";
		System.out.println("query " + query);
		String queryProjId="SELECT project_id FROM emp_project order by project_id DESC";
		
		int projectId = 0;
		if (connection.getICDM(query) > 0) {
			flag = true;
		}else{
			flag=false;
		}
		rs = null;
		rs = connection.getResultSet(queryProjId);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			projectId=(Integer) rs.getObject("project_id");
		}
		System.out.println("projectId "+projectId);
		String query1="INSERT INTO emp_project_allocation(user_id,project_id) VALUES ("
				+usersbean.getUserId()
				+","+projectId+")";
		String query2="INSERT INTO emp_project_allocation(user_id,project_id) VALUES ("
				+"AD_EMP_ADMIN_HR_USERID"
				+","+projectId+")";
		String queryUserId="SELECT user_id FROM emp_authentication where emp_access= 2 or emp_access=6";
		if(usersbean.getAccessVal().equals("HR")){
			rs = null;
			rs = connection.getResultSet(queryUserId);
			if (rs.next() == false) {

			} else {
				rs.absolute(1);
				do{
					String update_query2=query2.replace("AD_EMP_ADMIN_HR_USERID",
							String.valueOf((Integer) rs.getObject("user_id")));
					System.out.println("update_query2 "+update_query2);
					if (connection.getICDM(update_query2) > 0) {
						flag = true;
					}else{
						flag=false;
					}
				}while(rs.next());
			}
		}else if(usersbean.getAccessVal().equals("Client")){
			if (connection.getICDM(query1) > 0) {
				flag = true;
			}else{
				flag=false;
			}
		}else{
			flag=false;
		}
		
		return flag;
	}

	@Override
	public ClientProjListBean LoadDataDao(String username) throws SQLException {

		ClientProjViewBean projViewBean;
		List<ClientProjViewBean> tempProjList = new ArrayList<ClientProjViewBean>();
		List<ClientProjViewBean> tempProjList1 = new ArrayList<ClientProjViewBean>();
		List<ClientProjViewBean> tempProjList2 = new ArrayList<ClientProjViewBean>();
		Date currDate = new Date();
		String currQuery = "SELECT * FROM emp_project " + "WHERE flag='C"
				+ "' AND client_name='" + username + "'";
		String upcQuery = "SELECT * FROM emp_project " + "WHERE flag='U"
				+ "' AND client_name='" + username + "'";
		String oldQuery = "SELECT * FROM emp_project " + "WHERE flag='O"
				+ "' AND client_name='" + username + "'";

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
				projViewBean = new ClientProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						String.valueOf(rs.getObject("project_name")),
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						Integer.valueOf(String.valueOf(rs
								.getObject("resources"))),
						Double.valueOf(String.valueOf(rs.getObject("budget"))),
						String.valueOf(rs.getObject("client_name")));
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
				projViewBean = new ClientProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						String.valueOf(rs.getObject("project_name")),
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						Integer.valueOf(String.valueOf(rs
								.getObject("resources"))),
						Double.valueOf(String.valueOf(rs.getObject("budget"))),
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
				projViewBean = new ClientProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						String.valueOf(rs.getObject("project_name")),
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						Integer.valueOf(String.valueOf(rs
								.getObject("resources"))),
						Double.valueOf(String.valueOf(rs.getObject("budget"))),
						String.valueOf(rs.getObject("client_name")));
				tempProjList2.add(projViewBean);
			} while (rs.next());
		}

		return new ClientProjListBean(tempProjList, tempProjList1,
				tempProjList2);
	}

}
