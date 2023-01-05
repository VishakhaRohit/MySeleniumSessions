package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		By firstname = By.id("input-firstname");
		By checkBox = By.xpath("//button[text()='Continue']");
		
		doActionsSendKeys(firstname, "Rohit");
		Thread.sleep(3000);
		doActionsClick(checkBox);
		
	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator,String value)
	{
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();		
	}
	public static void doActionsClickSendKeys(By locator,String value)
	{
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	public static void doActionsClick(By locator) 
	{
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	public static void doActionsMoveToElementClick(By locator)
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}
}
