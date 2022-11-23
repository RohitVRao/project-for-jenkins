package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This method is used to read the data from property file
	 * @author Rohit V Rao
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws Throwable{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pobj = new Properties();
		pobj.load(fis);

		String value = pobj.getProperty(key);
		return value;

	}
}
