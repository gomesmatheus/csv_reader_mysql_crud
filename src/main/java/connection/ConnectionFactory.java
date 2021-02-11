package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection connection;
	
	public static Connection retornaConexao() {
		try {
			if (connection == null) {
				Properties prop = new Properties();
				InputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/database.properties");
		        prop.load(fis);
		        
		        String url = prop.getProperty("url");
		        String username = prop.getProperty("username");
		        String password = prop.getProperty("password");
		        
		        Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}	
}