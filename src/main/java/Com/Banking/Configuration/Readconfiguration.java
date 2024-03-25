package Com.Banking.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfiguration {

	Properties pro;
	File src;
	FileInputStream fis;

	public Readconfiguration() {

		src = new File(
				"C:\\Users\\Ramesh\\eclipse-workspace\\Automation_DataDriven_Framework\\src\\main\\java\\Com\\Banking\\Configuration\\config.properties");

		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

}