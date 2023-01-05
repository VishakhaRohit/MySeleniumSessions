package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicityWaitConcept {

		static WebDriver driver;
		
		public static void main(String[] args) {

			//imp wait
			//dynamic wait
			//global wait -- > it will be applicable only for all the WebElements by default
			//can not be applied for non - WebElements -->url,title,alert
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://crmpro.com/index.html");
			
			//login page : 10 secs
			driver.findElement(By.name("username")).sendKeys("groupautomation");
			driver.findElement(By.name("password")).sendKeys("Test@12345");
			
			//Home page : 15 secs
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			//e4
			//e5
			//e6
			
			//contacts page : 5 secs
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//e7
			//e8
			
			//home page : 5 secs
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//click on logout
			//login page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//registration page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			//0 sec : nullify of implicitly wait
			//e10
			//e11

		}

}
