package com.orangeHRM.base;

import java.io.FileInputStream;
import java.util.Properties;

public class readProperty implements ApplicationConstants{

	Properties pro;
	FileInputStream fis;
	
	public String readProperty1() throws Exception
	{
		pro = new Properties();
		fis = new FileInputStream(property_Path);
		pro.load(fis);
		String url = pro.getProperty("testURL");
		return url;
		
	}
}
