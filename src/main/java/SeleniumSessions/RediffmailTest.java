package SeleniumSessions;

public class RediffmailTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.enterUrl("https://mail.rediff.com/cgi-bin/login.cgi");
		String url = br.getUrl();
		System.out.println(url);
		
		String title = br.getTitle();
		System.out.println("Title is : " + title);
		if(title.contains("Rediff"))
		{
			System.out.println("Pass-Title is correct");
		}
		else
		{
			System.out.println("Fail-Incorrect Title");
		}
	}

}
