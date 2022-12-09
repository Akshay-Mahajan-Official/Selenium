package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	public static final String propfilepath = System.getProperty("user.dir") + "\\application.properties";

	public static String getValue(String key) throws IOException {

		FileInputStream fis = new FileInputStream(propfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
