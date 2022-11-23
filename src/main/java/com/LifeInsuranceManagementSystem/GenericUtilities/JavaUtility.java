package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * 	This method is used to get random number
	 * @author Rohit V Rao
	 * @return 
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(10000);
		return random;
	}
	
	/**
	 * This method is used to get system date
	 * @author Rohit V Rao
	 * @return
	 */
   public String getSystemDate() {
	   Date date = new Date();
	   String systemdate = date.toString();
	   return systemdate;
	   
	   
   }
   /**
    * This method is used to get system date and date in format
    * @author Rohit V Rao
    * @return
    */
   public String getSystemDateAndTimeFormat() {
	   SimpleDateFormat dateformat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	   Date systemdate = new Date();
	   String getDateAndTime = dateformat.format(systemdate);
	   System.out.println(getDateAndTime);
	   return getDateAndTime.replaceAll(":","-");
	   
	   
   }
}