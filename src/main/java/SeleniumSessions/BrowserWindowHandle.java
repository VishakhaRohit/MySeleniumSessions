package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		  WebDriverManager.chromedriver().setup();
		  
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		  Thread.sleep(5000);
		  
		  driver.findElement(By.xpath("(//*[local-name()='svg' and @role='presentation'])[1]")).click();
		  
		  Set<String> handles = driver.getWindowHandles();
		  Iterator<String> it = handles.iterator();
		  String parentWindowId =  it.next();
		  System.out.println("Parent Window Id : " + parentWindowId);
		  
		 String childWindowId =  it.next();
		 System.out.println("Child Window Id : " + childWindowId);
		 
		 driver.switchTo().window(childWindowId);
		 System.out.println("ParentPage url" + driver.getCurrentUrl());
		 driver.close();
		 
		 driver.switchTo().window(parentWindowId);
		 System.out.println("ChildPage url" + driver.getCurrentUrl());
		 
	}

}
