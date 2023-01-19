package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToPropertiesFile 
{
public static void main(String[] args) throws IOException 
{
	FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");	
	Properties p=new Properties();
	p.load(fis);
	//used to write data into properties file
	p.put("username", "dhruva");
	FileOutputStream fos=new FileOutputStream("./src/test/resources/commonData.properties");
	//Save data into properties file
	p.store(fos, "Username Modified");
}
}
