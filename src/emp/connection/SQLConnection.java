package emp.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class SQLConnection {
	private static Connection connection;
	//private static final Logger LOGGER = Logger.getLogger(SQLConnection.class);

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		SQLConnection.connection = connection;
	}

	public SQLConnection() {
		super();
		InputStream is = null;
		try {
			is = SQLConnection.class.getClassLoader().getResourceAsStream(
					"config.properties");
			Properties prop = new Properties();
			prop.load(is);

			Class.forName(prop.getProperty("DB_CLASS_NAME"));
			connection = DriverManager.getConnection(
					prop.getProperty("DB_URL"),
					prop.getProperty("DB_USERNAME"),
					prop.getProperty("DB_PASSWORD"));
			System.out.println("Suucess connection");
		} catch (Exception e) {
			//LOGGER.error("Error Occured : ".concat(e.getMessage()), e);
			System.out.println("Error connection");
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e1) {
				//LOGGER.error("Error Occured : ".concat(e1.getMessage()), e1);
			}

		}
	}

	public int getICDM(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeUpdate(query);
	}

	public ResultSet getResultSet(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	}

	public int getICDMWithKey(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);
	}

	public void setAutoCommitFalse() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("SET autocommit = 0");
	}

	public void setAutoCommitTrue() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("SET autocommit = 1");
	}

	public void startTransaction() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("START TRANSACTION");
	}

	public void commit() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("COMMIT");
	}

	public void rollback() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("ROLLBACK");
	}

	public void setSavepoint(String savepointName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("SAVEPOINT ".concat(savepointName));
	}

	public void rollbackToSavepoint(String savepointName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("ROLLBACK TO ".concat(savepointName));
	}

	public void releaseSavepoint(String savepointName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("RELEASE SAVEPOINT ".concat(savepointName));
	}
}
