package configExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public static void main(String[] args) throws IOException {
		
		
		
		//File 
		//File filePath = new File("./data.properties");
		FileInputStream fis = new FileInputStream("./data.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("password"));
		

	}

}
