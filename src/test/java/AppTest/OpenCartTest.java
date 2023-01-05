package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{

	@Test(priority=1)
	public void searchBtnTest() {
//		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		boolean flag = driver.findElement(By.cssSelector(".btn.btn-light.btn-lg")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void linkTest() {
		boolean flag = driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("account/login"));

	}

}
