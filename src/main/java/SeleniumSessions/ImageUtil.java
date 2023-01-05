package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUtil {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		By images = By.tagName("img");
		List<String> attText = getAttributeTextList(images, "src");
		for (String e : attText) {
			System.out.println(e);
		}
	}

	public static List<String> getAttributeTextList(By locator, String attName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getAttribute(attName);
			eleTextList.add(text);
		}
		return eleTextList;
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
