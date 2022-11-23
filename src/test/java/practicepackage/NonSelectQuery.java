package practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws SQLException {
int result = 0;
		Driver driver = new Driver();
		
		//step 1 : register the database
		DriverManager.registerDriver(driver);
		
		//step 2 : get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icc", "root", "root");
		
		//step 3 : issue create statement
				Statement stat = con.createStatement();
				String query = "insert into india values('RCB', 'Rohit', 8)";
				
				
	   //step 4 : execute query
	    result = stat.executeUpdate(query);
	    
	    if(result==1)
	    {
	    	System.out.println("data updated");
	    	
	    }
	    else
	    {
	    	System.out.println("data not updated");
	    }
		
		//step 5 : close database connection
		con.close();
		
				

	}

}
