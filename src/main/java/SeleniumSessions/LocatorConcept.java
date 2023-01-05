package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		//1st
//		driver.findElement(By.id("input-email")).sendKeys("test12345@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@12345");
		
		//2nd
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test12345@gmail.com");
//		password.sendKeys("test@12345");
		
		//3rd
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement email = driver.findElement(emailId);
//		WebElement pswd = driver.findElement(password);
//		
//		email.sendKeys("test12345@gmail.com");
//		pswd.sendKeys("test212345");
		
		//4th
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("test12345@gmail.com");
//		getElement(password).sendKeys("test@12345");
		
		//5th
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId, "test12345@gmail.com");
//		doSendKeys(password, "test@12345");
		
		//6th
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "test123@gmail.com");
//		eleUtil.doSendKeys(password, "test@123");
		
		//7th
		String userName = "input-email";
		String password = "input-password";
		
		doSendKeys("id", userName,"test123@gmail.com");
		doSendKeys("id", password,"test@123");
		
	}

	public static By getBy(String locatorType,String locatorValue)
	{
		By locator = null;
		
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			System.out.println("Please pass the right locator...");
			break;
		}
		return locator;
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static WebElement getElement(String locatorType,String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	public static void doSendKeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}
	public static void doSendKeys(String locatorType,String locatorValue,String value)
	{
		getElement(locatorType, locatorValue).sendKeys(value);
	}
}
