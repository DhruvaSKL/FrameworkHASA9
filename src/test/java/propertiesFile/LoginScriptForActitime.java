package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScriptForActitime 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	//Step 1: Convert physical file into java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		//Step 2: Create an instance for Properties class
		//Properties class is available in java.util.package
		Properties p=new Properties();
		//Step 3: Load all the key value pairs to property object
		p.load(fis);//IOException
		//Java concept involved is map interface- HashTable
		//Step 4:Read data
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(p.getProperty("timeouts"))));
		driver.findElement(By.id("username")).sendKeys(p.getProperty("user"));
		driver.findElement(By.name("pwd")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		if(driver.getTitle().contains("Enter"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		driver.quit();
	}		
}
