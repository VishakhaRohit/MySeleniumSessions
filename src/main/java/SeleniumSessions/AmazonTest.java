package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.enterUrl("https://www.google.com");
		String url = br.getUrl();
		System.out.println(url);
		
		String title = br.getTitle();
		System.out.println("Title is : " + title);
		if(title.equals("Google"))
		{
			System.out.println("Pass-Title is correct");
		}
		else
		{
			System.out.println("Fail-Incorrect Title");
		}
		
		br.closeBrowser();
	}

}
