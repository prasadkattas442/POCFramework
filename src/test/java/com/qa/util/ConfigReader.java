package com.qa.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;
	public static void configprop() throws Exception 
	{
	try{
	prop=new Properties();
	//FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
   FileInputStream ip=new FileInputStream("C:\\Users\\pkatta\\eclipse-workspace\\POCFrameWork\\Configuration\\Config.properties");
	prop.load(ip);
	}
	catch(Exception e){
	e.printStackTrace();
	}	
	}	
}
