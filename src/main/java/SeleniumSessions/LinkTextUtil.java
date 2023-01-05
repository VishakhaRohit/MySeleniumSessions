package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTextUtil {

	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		By linkTag = By.tagName("a");
		
		List<String> textList = getElementTextList(linkTag);
		for(String e : textList)
		{
			System.out.println(e);
		}
	}
	
	public static List<String> getElementTextList(By locator)
	{
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e:eleList)
		{
			String text = e.getText();
			if(!text.isEmpty())
			{
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}

}
