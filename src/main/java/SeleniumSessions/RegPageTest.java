package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String title = br.getTitle();
		System.out.println(title);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By emailId = By.id("input-email");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Test");
		eleUtil.doSendKeys(lastName, "Patel");
		eleUtil.doSendKeys(emailId, "test123@gmail.com");
		
		Thread.sleep(5000);
		
		br.closeBrowser();
	}

}
