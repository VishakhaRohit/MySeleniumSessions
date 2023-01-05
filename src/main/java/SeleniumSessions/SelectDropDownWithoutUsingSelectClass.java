package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownWithoutUsingSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");

//		List<WebElement> countryList = driver.findElements(By.xpath("//select[@id=\"Form_getForm_Country\"]/option"));
//
//		for (WebElement e : countryList) {
//			String text = e.getText();
//			if (text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
		By country = By.xpath("//select[@id=\"Form_getForm_Country\"]/option");
		
		selectDropDownWithoutUsingSelectClass(country, "India");
	}

	public static void selectDropDownWithoutUsingSelectClass(By locator,String value) {
		List<WebElement> countryList = driver.findElements(locator);

		for (WebElement e : countryList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
