package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	
		driver.findElement(By.name("q")).sendKeys("Naveen Automation");
		
		Thread.sleep(5000);
		
		By search = By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']//span");
		List<WebElement> searchList = driver.findElements(search);
		for(WebElement e : searchList)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.equals("naveen automationlabs"))
			{
				e.click();
				break;
			}
		}
	}

}
