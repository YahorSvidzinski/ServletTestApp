package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class DbUtil {

	private static final String DB_PROPERTIES_FILE = "db.properties";
	private static final String DB_DRIVER = "dbDriver";
	private static final String URL = "connectionUrl";
	private static final String USER_NAME = "userName";
	private static final String PASSWORD = "password";
	private static Connection dbConnection = null;
	private static final Logger log = Logger.getLogger(DbUtil.class.getName());


	public static Connection getConnection() {
		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
				InputStream inputStream = DbUtil.class.getClassLoader()
						.getResourceAsStream(DB_PROPERTIES_FILE);
				Properties properties = new Properties();
				properties.load(inputStream);

				String dbDriver = properties.getProperty(DB_DRIVER);
				String connectionUrl = properties.getProperty(URL);
				String userName = properties.getProperty(USER_NAME);
				String password = properties.getProperty(PASSWORD);
				Class.forName(dbDriver).newInstance();
				dbConnection = DriverManager.getConnection(connectionUrl, userName, password);
			} catch (Exception e) {
				log.severe(e.getMessage());
			}
			return dbConnection;
		}
	}
}
