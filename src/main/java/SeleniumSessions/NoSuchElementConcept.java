package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
//		WebElement firstName = driver.findElement(By.id("Form_getForm_Name11"));
//		firstName.sendKeys("Test");//NoSuchElementException
		
		List<WebElement> linkList = driver.findElements(By.tagName("0a"));
		System.out.println(linkList.size());//0
	}

}
