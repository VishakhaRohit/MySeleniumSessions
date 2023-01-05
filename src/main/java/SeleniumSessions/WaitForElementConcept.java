package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		By userName = By.name("username11");
//		By userName = By.name("username");

		By xPathList = By.xpath("//div[@role='presentation']//ul//a");
		List<String> linksList = getElementsTextListWithWait(xPathList, 10, 2000);
		for(String e : linksList)
		{
			System.out.println(e);
		}
		
//		doSendKeys(userName, "Test", 10);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement userName_Ele = wait.until(ExpectedConditions.presenceOfElementLocated(userName));
//		
//		userName_Ele.sendKeys("Test");
		
//		driver.findElement(By.name("password")).sendKeys("Test@123");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	public static void doClick(By locator,int timeOut,long intervalTime)
	{
		doPresenceOfElementLocated(locator, timeOut,intervalTime).click();
	}
	public static void doClick(By locator,int timeOut)
	{
		doPresenceOfElementLocated(locator, timeOut).click();
	}
	public static void doSendKeys(By locator,String value,int timeOut)
	{
		doPresenceOfElementLocated(locator, timeOut).sendKeys(value);
	}
	public static void doSendkeys(By locator,String value,int timeOut,long intervalTime)
	{
		doPresenceOfElementLocated(locator, timeOut, intervalTime).sendKeys(value);
	}
	public static WebElement doPresenceOfElementLocated(By locator,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement doPresenceOfElementLocated(By locator,int timeOut,long intervalTime)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement waiForElementToBeVisible(By locator,int timeOut,long intervalTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static List<WebElement> waitForElementsToBeVisisble(By locator,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static List<WebElement> waitForElementsToBeVisisble(By locator,int timeOut,long intervalTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static List<String> getElementsTextListWithWait(By locator,int timeOut)
	{
		List<WebElement> linksList = waitForElementsToBeVisisble(locator, timeOut);
		List<String> linksTextList = new ArrayList<String>();
		for(WebElement e : linksList)
		{
			String text = e.getText();
			linksTextList.add(text);
		}
		return linksTextList;
	}
	public static List<String> getElementsTextListWithWait(By locator,int timeOut,long intervalTime)
	{
		List<WebElement> linksList = waitForElementsToBeVisisble(locator, timeOut,intervalTime);
		List<String> linksTextList = new ArrayList<String>();
		for(WebElement e : linksList)
		{
			String text = e.getText();
			linksTextList.add(text);
		}
		return linksTextList;
	}
	
}
