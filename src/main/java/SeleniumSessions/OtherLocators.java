package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OtherLocators {

	static WebDriver driver;
	
	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		//name
//		By firstName = By.name("firstname");
//		By lastName = By.name("lastname");
//		
//		doSendKeys(firstName, "Test");
//		doSendKeys(lastName, "Patel");
		
		//classname
//		By search = By.className("form-control");
//		doSendKeys(search, "Macbook");
		
		//xpath
		//*[@id="input-firstname"]
//		/html/body/main/div[2]/div/div/form/fieldset[1]/div[2]/div/input
		
//		By firstName = By.xpath("//*[@id=\"input-firstname\"]");
//		By firstName = By.xpath("/html/body/main/div[2]/div/div/form/fieldset[1]/div[2]/div/input");
//		doSendKeys(firstName,"Test");
		
		//cssSelector
//		By firstName = By.cssSelector("#input-firstname");
//		doSendKeys(firstName, "Test");
		
		//linkText
//		By forgottenPassword = By.linkText("Forgotten Password");
//		doClick(forgottenPassword);
		
		//partial linkText
//		By orderHistory = By.partialLinkText("Order");
//		doClick(orderHistory);
		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(orderHistory);

		//tagName
//		String header = driver.findElement(By.tagName("h1")).getText();
//		if(header.contains("Register Account"))
//		{
//			System.out.println("Header is Correct...");
//		}
		
		By header = By.tagName("h1");
		if(doGetText(header).contains("Register Account"))
		{
			System.out.println("Header is Correct...");
		}
	}


	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doSendKeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}
	public static void doClick(By locator)
	{
		getElement(locator).click();
	}
	public static String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
}
