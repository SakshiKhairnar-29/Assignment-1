package org.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


	public String configReader(String key)
	{
		try {
			FileInputStream fis = new FileInputStream("./property/config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);	
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
}
}