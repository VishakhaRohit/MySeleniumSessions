package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllDropDownValuesWithSelectTag {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		 
		Select select = new Select(country);
		List<WebElement> countryList = select.getOptions();
		
		if(countryList.size()-1 == 231)
		{
			System.out.println("country count is correct");
		}
		
//		for(WebElement e:countryList)
//		{
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		for(int i = 0 ; i<=countryList.size()-1;i++)
		{
			String text = countryList.get(i).getText();
			System.out.println(i+ " : " + text);
		}
	}

}
