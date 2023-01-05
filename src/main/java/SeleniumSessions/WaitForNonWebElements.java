package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Contact us']")).click();
		
//		if(waitForUrlToContain("controller=contact", 5))
//		{
//			System.out.println("Pass");
//		}
		
		if(waitForTitleToBe("Contact us - My Store", 10))
		{
			System.out.println("Pass");
		}
		
	}
	
	public static String doGetTitleWithFraction(String urlFraction,int timeOut)
	{
		if(waitForTitleContain(urlFraction, timeOut))
		{
			return driver.getTitle();
		}
		return null;
	}
	public static String doGetTitle(String title,int timeOut)
	{
		if(waitForTitleToBe(title, timeOut))
		{
			return driver.getTitle();
		}
		return null;
	}
	
	public static boolean waitForUrlToContain(String urlFraction,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	public static boolean waitForUrlToBe(String url,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public static boolean waitForTitleContain(String titleFraction,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	
	public static boolean waitForTitleToBe(String title,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
}
