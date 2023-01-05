package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		//1
//		By formFields = By.className("text");
//		int fieldsCount =  driver.findElements(formFields).size();
//		if(fieldsCount>=0)
//		{
//			System.out.println("FormFields are zero");
//		}
//		else
//		{
//			System.out.println("FormFields are present");
//		}
		
		//2
		By formField = By.linkText("Contact Sales");
//		boolean flag = driver.findElement(formField).isDisplayed();
//		System.out.println(flag);
//		
//		if(driver.findElements(formField).size()>=1)
//		{
//			System.out.println("FormField is present on the page");
//		}
		
		System.out.println(isElementExist(formField));
	}

	public static boolean isElementExist(By locator)
	{
		int elementCount = driver.findElements(locator).size();
		if(elementCount>=1)
		{
			System.out.println("Element is present on the page");
			return true;
		}
		else
		{
			System.out.println("Element is not present on the page");
			return false;
		}
	}
	
}
