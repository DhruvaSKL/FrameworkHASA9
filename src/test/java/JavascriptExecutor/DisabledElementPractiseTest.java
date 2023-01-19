package JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledElementPractiseTest 
{
public static void main(String[] args) throws InterruptedException
{
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("file:///C:/Users/dhruva%20skl/Desktop/srin.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement element=driver.findElement(By.id("abc"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].value=arguments[1]", element,"abc");
Thread.sleep(3000);
js.executeScript("document.getElementById('abc').value='selenium'");
Thread.sleep(3000);
js.executeScript("document.getElementById('abc').value=''");
}
}
