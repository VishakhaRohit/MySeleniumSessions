package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dress");
		
		Thread.sleep(5000);
		
		List<WebElement> searchList = driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@role='button']"));
		for(WebElement e : searchList)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.equals("dresses"))
			{
				e.click();
				break;
			}
		}
	
	}

}
