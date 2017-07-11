import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpleDataSource {
    public static void init(String fname) throws IOException, ClassNotFoundException
    {
    	Properties prop = new Properties();
    	FileInputStream in = new FileInputStream(fname);
    	prop.load(in);
    	String driver = prop.getProperty("jbdc.driver");
    	url = prop.getProperty("jdbc.url");
    	username = prop.getProperty("jdbc.username");
    	if (username == null)
    	{
    		username = "";
    	}
    	password = prop.getProperty("jdbc.password");
    	if (password == null)
    	{
    		password = "";
    	}
    	if (driver != null)
    	{
    		Class.forName(driver);
    	}
    }
    public static Connection getConnection() throws SQLException
    {
    	return DriverManager.getConnection(url, username, password);
    }
    private static String username;
    private static String password;
    private static String url;
}
