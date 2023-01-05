package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_10_practice {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By links = By.xpath("//div[@id='navFooter']//div[@class='navFooterLinkCol navAccessibility']//li");
		
//		List<String> linksList = getElementList(links);
//		System.out.println(linksList.size());
//		for(String e : linksList)
//		{
//			System.out.println(e);
//		}
		
		clickOnElement(links, "Reload Your Balance");
	}

	public static List<String> getElementList(By locator)
	{
		List<WebElement> linksList = driver.findElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		for(WebElement e : linksList)
		{
			String text = e.getText();
			linksTextList.add(text);
		}
		return linksTextList;
	}
	
	public static void clickOnElement(By locator,String value)
	{
		List<WebElement> linksList = driver.findElements(locator);
		for(WebElement e : linksList)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
	}
}
