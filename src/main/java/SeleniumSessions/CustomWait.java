package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");

		By firstName = By.id("input-firstname1");
		retryingElement(firstName,10,500).sendKeys("Test");
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static WebElement retryingElement(By locator,int timeOut)
	{
		WebElement element = null;
		int attempt = 0;
		
		while(attempt<timeOut)
		{
			try {
				element = getElement(locator);
				break;
			}
			catch(Exception e)
			{
				System.out.println("NoSuchElementException..." + attempt);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempt++;
			
		}
		if(element==null)
		{
			try {
				throw new Exception("ELEMENTISNOTFOUNDEXCEPTION");
			}
			catch(Exception e)
			{
				System.out.println("Element is not found exception...tried for " + timeOut );
			}
		}
		return element;
	}
	public static WebElement retryingElement(By locator,int timeOut,long pollingTime)
	{
		WebElement element = null;
		int attempt = 0;
		
		while(attempt<timeOut)
		{
			try {
				element = getElement(locator);
				break;
			}
			catch(Exception e)
			{
				System.out.println("NoSuchElementException..." + attempt);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempt++;
			
		}
		if(element==null)
		{
			try {
				throw new Exception("ELEMENTISNOTFOUNDEXCEPTION");
			}
			catch(Exception e)
			{
				System.out.println("Element is not found exception...tried for " + timeOut +
						" with the interval of " + pollingTime);
			}
		}
		return element;
	}
}
