package emp.daoImpl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import emp.connection.SQLConnection;
import emp.dao.ProjectReportDao;

public class ProjectReportDaoImpl implements ProjectReportDao {

	private static SQLConnection connection = null;
	private ResultSet rs = null;
	static {
		connection = new SQLConnection();
	}

	@Override
	public Double GetProgressStatus(int projectId) throws Exception {
		Double result = 0.00;
		String query = "SELECT  avg(task_status) AS progress_raw,count(distinct task_id) from emp_task where project_id= "
				+ projectId;
		System.out.println("query " + query);
		rs = null;
		rs = connection.getResultSet(query);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			try{
			result = Double
					.valueOf(String.valueOf(rs.getObject("progress_raw")));
			
			result = Math.ceil(result  * 10);
			System.out.println("result "+result);
			}catch(Exception e){
				
			}
		}
		return result;
	}

	private HashMap<String, Integer> GetAccessList(int projectId)
			throws Exception {
		HashMap<String, Integer> accessList = new HashMap<String, Integer>();
		String accessQuery = "SELECT * FROM emp_access";
		System.out.println("accessQuery " + accessQuery);
		rs = null;
		rs = connection.getResultSet(accessQuery);
		if (rs.next() == false) {

		} else {
			rs.absolute(1);
			do {
				accessList
						.put(String.valueOf(rs.getObject("accessVal")), Integer
								.valueOf(String.valueOf(rs
										.getObject("accessId"))));
			} while (rs.next());
		}
		return accessList;
	}

	@Override
	public HashMap<String, Integer> GetResourcesMap(int projectId)
			throws Exception {
		HashMap<String, Integer> resourcesMap = GetAccessList(projectId);
		for (String keyVal : resourcesMap.keySet()) {

			String query = "SELECT  count(distinct alloc.user_id) from emp_project_allocation alloc INNER JOIN emp_authentication auth "
					+ "where alloc.user_id=auth.user_id and "
					+ "alloc.project_id= "
					+ projectId
					+ " and auth.emp_access=" + resourcesMap.get(keyVal);
			System.out.println("query " + query);
			rs = null;
			rs = connection.getResultSet(query);
			if (rs.next() == false) {
				resourcesMap.put(keyVal, 0);
			} else {
				rs.absolute(1);
				resourcesMap.put(keyVal,
						Integer.valueOf(String.valueOf(rs.getObject(1))));
			}

		}
		return resourcesMap;
	}

	
	@Override
	public HashMap<String, Integer> GetTaskStatus(int projectId)
			throws Exception {
		HashMap<String, Integer> taskStatus = new HashMap<String,Integer>();

			String query = "SELECT task_name,task_status FROM emp_task where project_id="+projectId;
			System.out.println("query " + query);
			rs = null;
			rs = connection.getResultSet(query);
			if (rs.next() == false) {
			} else {
				rs.absolute(1);
				do{
					taskStatus.put(String.valueOf(rs.getObject("task_name")),
						Integer.valueOf(String.valueOf(rs.getObject("task_status"))));
				}while(rs.next());
			}

		return taskStatus;

	}
}
