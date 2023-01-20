package synchronization;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitPractice1
{
	public static void main(String[] args) 
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com/login.do");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	boolean status = wait.until(ExpectedConditions.titleContains("actiTIME"));
	if(status)
		System.out.println("Pass");
	else
		System.out.println("Fail");
	driver.quit();
}
}
