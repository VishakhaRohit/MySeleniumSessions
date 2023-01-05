package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		String browser = "chrome";
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohit\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please pass the right browser...");
		}
		
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Google")) {
			System.out.println("Pass-Correct title");
		}
		else
		{
			System.out.println("Fail-Incorrect Title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
}
