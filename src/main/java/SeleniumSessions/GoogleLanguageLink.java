package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLink {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		By language = By.xpath("//div[@id='SIvCob']/a");
//		clickOnElement(language, "Français");
		
		List<String> languageList = getLinksTextList(language);
		for(String e : languageList)
		{
			System.out.println(e);
		}
		
//		List<WebElement> languageList = driver.findElements(language);
//
//		System.out.println(languageList.size());
//
//		for (WebElement e : languageList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
	}

	public static List<String> getLinksTextList(By locator)
	{
		List<WebElement> languageList = driver.findElements(locator);
		List<String> languageTextList = new ArrayList<String>();
		for(WebElement e:languageList)
		{
			String text = e.getText().trim();
			languageTextList.add(text);
		}
		return languageTextList;
	}
	
	
	public static void clickOnElement(By locator,String value) {
		List<WebElement> languageList = driver.findElements(locator);

		System.out.println(languageList.size());

		for (WebElement e : languageList) {
			String text = e.getText().trim();
			System.out.println(text);
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
	}

}
