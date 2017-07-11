import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAccount {

	public BankAccount(int num)
	{
		accountNum = num;
	}
	public void deposit(double amount) throws SQLException
	{
		Connection conn = SimpleDataSource.getConnection();
		try
		{
			PreparedStatement stat = conn.prepareStatement("UPDATE Account"+" SET Balance = Balance + ?"+" WHERE Account_Number = ?");
			stat.setDouble(1, amount);
			stat.setInt(2, accountNum);
			stat.executeUpdate();
		}
		finally
		{
			conn.close();
		}
	}
	public void withdraw(double amount) throws SQLException
	{
		Connection conn = SimpleDataSource.getConnection();
		try
		{
			PreparedStatement stat = conn.prepareStatement("UPDATE Account"+" SET Balance = Balance - ?"+" WHERE Account_Number = ?");
			stat.setDouble(1, amount);
			stat.setInt(2, accountNum);
			stat.executeUpdate();
		}
		finally
		{
			conn.close();
		}
	}
	 public double displayBalance() throws SQLException
	 {
		 Connection conn = SimpleDataSource.getConnection();
		 try
		 {
			 double balance = 0;
			 PreparedStatement stat = conn.prepareStatement("SELECT Balance FROM Account WHERE Account_Number = ?");
			 stat.setInt(1, accountNum);
			 ResultSet result = stat.executeQuery();
			 if (result.next())
			 {
				 balance = result.getDouble(1);
			 }
			 return balance;
		 }
		 finally
		 {
			 conn.close();
	     }
     }
	 
	 private int accountNum;
}
