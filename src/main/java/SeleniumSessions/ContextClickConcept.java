package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act = new Actions(driver);
		act.contextClick(rightClick).build().perform();

		By clickElementList = By.xpath("//ul[@class='context-menu-list context-menu-root']//li//span");

		clickList(clickElementList, "all");
	}

	public static void clickList(By locator, String value) throws InterruptedException {

		List<WebElement> clickList = driver.findElements(locator);

		if (!value.equalsIgnoreCase("all")) {

			for (WebElement e : clickList) {
				String text = e.getText();
				System.out.println(text);
				if (text.equals(value)) {
					e.click();
					Thread.sleep(2000);
					Alert alert = driver.switchTo().alert();
					alert.accept();
					break;

				}
			}
		} else {
			for (int i = 0; i < clickList.size(); i++) {
				String text = clickList.get(i).getText();
				System.out.println(text);
				clickList.get(i).click();
				Thread.sleep(2000);
				Alert alert = driver.switchTo().alert();
				alert.accept();

				if (i == clickList.size() - 1) {
					break;
				}

				rightClickMethod();
			}
		}
	}

	public static void rightClickMethod() {
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClick).build().perform();
	}

}
