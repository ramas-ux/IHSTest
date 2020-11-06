package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	
	public ConfigReader() {
		
		File src =new File("./Configuration/Config.property");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		
		} catch (Exception e) {
		System.out.println(e.getMessage());
			
		}
		
	}
	
	public String getChromePath() {
		return pro.getProperty("ChromeDriver");
	}
	
	public String getUrl() {
		return pro.getProperty("Url");
	}
	

}
