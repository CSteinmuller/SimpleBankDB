import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Bank {
    public Customer findCustomer( int custNum, int pin) throws SQLException
    {
    	Connection conn = SimpleDataSource.getConnection();
    	try
    	{
    		Customer c = null;
    		PreparedStatement stat = conn.prepareStatement("SELECT * FROM BankCustomer WHERE Customer_Number = ?");
    		stat.setInt(1, custNum);
    		ResultSet result = stat.executeQuery();
    		if (result.next() && pin == result.getInt("PIN"))
    		{
    			c = new Customer(custNum, result.getInt("Checking_Account_Number"), result.getInt("Savings_Account_Number"));
    		}
    		return c;
    		
    	}
    	finally
    	{
    		conn.close();
    	}
    }
}
