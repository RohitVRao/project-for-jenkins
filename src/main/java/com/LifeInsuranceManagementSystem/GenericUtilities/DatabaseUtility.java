package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con = null;
	
	/**
	 * This method is used to connect to DB
	 * @author Rohit V Rao
	 * @throws Throwable
	 */
	public void connecttoDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
		
	}
	/**
	 * This method is used to executeQueryAndGetData
	 * @author Rohit V Rao
	 * @param query
	 * @param ColumnIndex
	 * @param expdata
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int ColumnIndex, String expdata, String data) throws SQLException
	{
		boolean flag = false;
		
		ResultSet result = con.createStatement().executeQuery(query);
		while (result.next())
		{
			data = result.getString(ColumnIndex);
			if(data.equalsIgnoreCase(expdata))
			{
				flag = true;
				break;
						
			}
			
		}
		if(flag)
		{
			System.out.println(data+"---->data verified");
			return expdata;
		}
		else
		{
			System.out.println(data+"---->data not verified");
			return"";
		}
	}
	/**
	 * This method is used to closeDB
	 * @author Rohit V Rao
	 * @throws SQLException
	 */
   public void closeDB() throws SQLException
   {
	   con.close();
   }
}
