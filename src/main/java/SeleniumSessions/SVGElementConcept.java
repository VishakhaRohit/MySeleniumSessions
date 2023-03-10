package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		Thread.sleep(5000);
		
		List<WebElement> eleList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g']/*[name()='path']"));
		
		Actions act = new Actions(driver);
		for(WebElement e : eleList)
		{
			act.moveToElement(e).build().perform();
			String name = e.getAttribute("name");
			System.out.println(name);
			if(name.equals("Delaware"))
			{
				e.click();
				break;
			}	
		}
	}

}
