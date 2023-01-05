package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.meesho.com/");
		
		String attrValue = driver.findElement(By.linkText("Online Shopping")).getAttribute("href");
		System.out.println(attrValue);
		
		if(attrValue.contains("meesho"))
		{
			System.out.println("This is correct href...");
		}
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static String getAttributeValue(By locator,String attrName)
	{
		String attrValue = getElement(locator).getAttribute(attrName);
		System.out.println("Attribute Value ; " + attrValue);
		return attrValue;
	}
	
}
