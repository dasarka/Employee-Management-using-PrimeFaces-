package emp.dao;

import java.util.HashMap;
import java.util.Map;

public interface ProjectReportDao {

	Double GetProgressStatus(int projectId) throws Exception;

	HashMap<String, Integer> GetResourcesMap(int projectId) throws Exception;

	HashMap<Integer, Map<String, Number>> GetTasksMap(int projectId) throws Exception;

}
