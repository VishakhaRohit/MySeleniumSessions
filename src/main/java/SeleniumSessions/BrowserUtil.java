package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;
	
		public WebDriver launchBrowser(String browserName)
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\geckodriver\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("Please pass the right browser...");
			}
			return driver;
		}
		
		public void enterUrl(String url)
		{
			if(url==null)
			{
				System.out.println("url is null...");
				return;
			}
			if(url.indexOf("https")==-1)
			{
				System.out.println("https is missing...");
				return;
			}
			driver.get(url);
		}
		public String getUrl()
		{
			return driver.getCurrentUrl();
		}
		public String getTitle()
		{
			return driver.getTitle();
		}
		
		public void closeBrowser()
		{
			driver.close();
		}
}
