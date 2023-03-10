package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {

		static WebDriver driver;
		
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			
			List<WebElement> imageList = driver.findElements(By.tagName("img"));
			System.out.println(imageList.size());
			
			for(int i = 0 ; i<imageList.size();i++)
			{
				String srcValue = imageList.get(i).getAttribute("src");
				System.out.println(srcValue);
			}
	}

}
