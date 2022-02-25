package configExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromConfigFile {

	Properties prop;

	public ReadDataFromConfigFile() throws IOException {

		//FileInputStream fis = new FileInputStream("./testdata/data.properties");
		FileInputStream fis = new FileInputStream("./testdata/NOPData.properties");
		

		prop = new Properties();

		prop.load(fis);

	}

	public String getAppURL() {

		String appURL = prop.getProperty("url");
		return appURL;
	}

	public String getAdminUSer() {

		return prop.getProperty("username");
	}

	public String getAdminPassword() {

		return prop.getProperty("password");
	}

}
