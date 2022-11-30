package qa.luma.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	public static Properties prop;

	public readConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail() {
		String email = prop.getProperty("email");
		System.out.println(email);
		return email;
	}
	
	public String getUserPassword() {
		String pwd = prop.getProperty("password");
		System.out.println(pwd);
		return pwd;
	}

	
	public String getChromeDriverPath() {
		String chromePath = prop.getProperty("chromeDriverPath");
		return chromePath;
	}
	
	public String getFirefoxDriverPath() {
		String firefoxPath = prop.getProperty("firefoxDriverPath");
		return firefoxPath;
	}
}
