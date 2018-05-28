package emp.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import emp.connection.SQLConnection;
import emp.dao.ResourceDao;
import emp.model.ClientProjListBean;
import emp.model.ClientProjViewBean;
import emp.model.ResourcesAllocBean;
import emp.model.UsersBean;

public class ResourceDaoImpl implements ResourceDao {
	private static SQLConnection connection = null;
	private ResultSet rs = null;
	static {
		connection = new SQLConnection();
	}

	@Override
	public ClientProjListBean LoadDataDao() throws SQLException {
		ClientProjViewBean projViewBean;
		List<ClientProjViewBean> tempProjList = new ArrayList<ClientProjViewBean>();
		List<ClientProjViewBean> tempProjList1 = new ArrayList<ClientProjViewBean>();
		List<ClientProjViewBean> tempProjList2 = new ArrayList<ClientProjViewBean>();
		Date currDate = new Date();
		String currQuery = "SELECT * FROM emp_project "
				+ "WHERE flag='C' and project_name not in ('Internal Project', 'Bench Project', 'LMS Project');";
		String upcQuery = "SELECT * FROM emp_project " + "WHERE flag='U' and project_name not in ('Internal Project', 'Bench Project', 'LMS Project');";
		String oldQuery = "SELECT * FROM emp_project " + "WHERE flag='O' and project_name not in ('Internal Project', 'Bench Project', 'LMS Project');";

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

	@Override
	public ResourcesAllocBean LoadFormDataDao() throws SQLException {
		List<ClientProjViewBean> projectList = new ArrayList<ClientProjViewBean>();
		List<UsersBean> onsiteManager = new ArrayList<UsersBean>();
		List<UsersBean> manager = new ArrayList<UsersBean>();
		List<UsersBean> lead = new ArrayList<UsersBean>();
		List<UsersBean> developer = new ArrayList<UsersBean>();
		List<UsersBean> perfTester = new ArrayList<UsersBean>();
		List<UsersBean> tester = new ArrayList<UsersBean>();

		//Date currDate = new Date();
		String projQuery = "SELECT * FROM emp_project " + "WHERE "
				+ "project_name not in ('Internal Project', 'Bench Project', 'LMS Project')"
				+ "AND project_id NOT IN "
				+ "(SELECT distinct alloc.project_id  from emp_project_allocation alloc, "
				+ "emp_authentication auth where alloc.user_id=auth.user_id and auth.emp_access <> 7)"
				+ " AND flag <> 'O'";
		String omQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 10 ";
		String mQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 5 ";
		String lQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 4 ";
		String dQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 3 ";
		String ptQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 8 ";
		String tQuery = "SELECT * FROM emp_avail_resource "  
				+"WHERE emp_access = 9 ";
		System.out.println("projQuery "+projQuery);
		System.out.println("omQuery "+omQuery);
		System.out.println("mQuery "+mQuery);
		System.out.println("lQuery "+lQuery);
		System.out.println("dQuery "+dQuery);
		System.out.println("ptQuery "+ptQuery);
		System.out.println("tQuery "+tQuery);
		
		rs = null;
		rs = connection.getResultSet(projQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				String projName=(String) rs.getObject("project_name");
				System.out.println("projName "+projName);
				projectList.add(new ClientProjViewBean(Integer.valueOf(String
						.valueOf(rs.getObject("project_id"))),
						projName,
						String.valueOf(rs.getObject("start_date")),
						String.valueOf(rs.getObject("end_date")),
						Integer.valueOf(String.valueOf(rs
								.getObject("resources"))),
						Double.valueOf(String.valueOf(rs.getObject("budget"))),
						String.valueOf(rs.getObject("client_name"))));
				System.out.println("projectList "+projectList);
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(omQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				onsiteManager.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(mQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				manager.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(lQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				lead.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(dQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				developer.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(ptQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				perfTester.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		
		rs = null;
		rs = connection.getResultSet(tQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				tester.add(new UsersBean(Integer.valueOf(String
						.valueOf(rs.getObject("user_id"))),
						String.valueOf(rs.getObject("emp_name")), 
						String.valueOf(rs.getObject("emp_desg")),
						String.valueOf(rs.getObject("accessVal")),
						Integer.valueOf(String.valueOf(rs.getObject("emp_remainHours")))));
				
			} while (rs.next());
		}
		return new ResourcesAllocBean(projectList, onsiteManager, manager, lead, developer, perfTester, tester);
	}

	@Override
	public boolean NewAllocationDao(ResourcesAllocBean resourceBean) throws SQLException {
		System.out.println("Inside NewAllocationDao");
		System.out.println("resourceBean "+resourceBean);
		boolean flag=false;
		String completeQuery="";
		String insertQuery="INSERT INTO emp_project_allocation ( user_id, project_id, working_hours) VALUES ( ";
		String updateQuery="UPDATE emp_authentication SET emp_remainHours=emp_remainHours-"; 
		String updateClause=" WHERE user_id=";
		
		
		completeQuery= insertQuery
				+resourceBean.getSelectedOnsiteManagerId()
				+", "
				+resourceBean.getSelectedProjectId()
				+", "
				+resourceBean.getHours_om()+")";
		System.out.println("completeQuery "+completeQuery);
		if (connection.getICDM(completeQuery) > 0) {
			flag = true;
			completeQuery=updateQuery+resourceBean.getHours_om()+updateClause+resourceBean.getSelectedOnsiteManagerId();
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		completeQuery= insertQuery
				+resourceBean.getSelectedManagerId()
				+", "
				+resourceBean.getSelectedProjectId()
				+", "
				+resourceBean.getHours_m()+")";
		System.out.println("completeQuery "+completeQuery);
		if (connection.getICDM(completeQuery) > 0) {
			flag = true;
			completeQuery=updateQuery+resourceBean.getHours_m()+updateClause+resourceBean.getSelectedManagerId();
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		completeQuery= insertQuery
				+resourceBean.getSelectedLeadId()
				+", "
				+resourceBean.getSelectedProjectId()
				+", "
				+resourceBean.getHours_l()+")";
		System.out.println("completeQuery "+completeQuery);
		if (connection.getICDM(completeQuery) > 0) {
			flag = true;
			completeQuery=updateQuery+resourceBean.getHours_l()+updateClause+resourceBean.getSelectedLeadId();
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		for ( Integer id : resourceBean.getSelectedDeveloperList().keySet()) {
			completeQuery= insertQuery
					+id
					+", "
					+resourceBean.getSelectedProjectId()
					+", "
					+resourceBean.getSelectedDeveloperList().get(id).getValue3()+")";
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
				completeQuery=updateQuery+resourceBean.getSelectedDeveloperList().get(id).getValue3()+updateClause+id;
				System.out.println("completeQuery "+completeQuery);
				if (connection.getICDM(completeQuery) > 0) {
					flag = true;
				}else{
					flag = false;
				}
			}else{
				flag = false;
			}
		}
		for ( Integer id : resourceBean.getSelectedPerfTesterList().keySet()) {
			completeQuery="";
			completeQuery= insertQuery
					+id
					+", "
					+resourceBean.getSelectedProjectId()
					+", "
					+resourceBean.getSelectedPerfTesterList().get(id).getValue3()+")";
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
				completeQuery=updateQuery+resourceBean.getSelectedPerfTesterList().get(id).getValue3()+updateClause+id;
				System.out.println("completeQuery "+completeQuery);
				if (connection.getICDM(completeQuery) > 0) {
					flag = true;
				}else{
					flag = false;
				}
			}else{
				flag = false;
			}
		}
		for ( Integer id : resourceBean.getSelectedTesterList().keySet()) {
			completeQuery="";
			completeQuery= insertQuery
					+id
					+", "
					+resourceBean.getSelectedProjectId()
					+", "
					+resourceBean.getSelectedTesterList().get(id).getValue3()+")";
			System.out.println("completeQuery "+completeQuery);
			if (connection.getICDM(completeQuery) > 0) {
				flag = true;
				completeQuery=updateQuery+resourceBean.getSelectedTesterList().get(id).getValue3()+updateClause+id;
				System.out.println("completeQuery "+completeQuery);
				if (connection.getICDM(completeQuery) > 0) {
					flag = true;
				}else{
					flag = false;
				}
			}else{
				flag = false;
			}
		}
		return flag;
	}

}
