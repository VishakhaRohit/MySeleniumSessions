package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");

		By parentMenu = By.cssSelector(".menulink");
		By childMenu = By.linkText("COURSES");

		doMoveToElement(parentMenu);
		Thread.sleep(2000);
		doClickOnChildMenu(parentMenu, childMenu);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doMoveToElement(By locator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}

	public static void doClickOnChildMenu(By parentMenu, By childMenu) throws InterruptedException
	{
		doMoveToElement(parentMenu);
		Thread.sleep(3000);
		driver.findElement(childMenu).click();
	}
}
