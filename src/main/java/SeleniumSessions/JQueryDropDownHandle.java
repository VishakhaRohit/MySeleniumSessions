package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.cssSelector("#justAnInputBox.comboTreeInputBox")).click();

		By choices = By.cssSelector("span.comboTreeItemTitle");

//		single element
		selectChoice(choices, "choice 10");

//		multiple element
//		selectChoice(choices, "choice 1","choice 2 1","choice 6 2");

//		all element
//		selectChoice(choices, "all");
	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);

		boolean flag = false;
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						flag = true;
						break;
					}
				}
			}
			
		} else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("choice is over...");
			}
		}
		if(flag == false)
		{
			System.out.println("choice is not available...");
		}

	}

}
