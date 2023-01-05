package SeleniumSessions;

public class ExplicitWait {

	public static void main(String[] args) {

		//Explicit Wait : is a high level wait concept
				//its a concapt
				//its dynamic
				//not a global wait
				//it can be appiled for a specific element as per the use case
				//e1 --> 5 sec
				//e2 --> no wait
				//e3 --> 10 sec
				
				//it can be applied for all non webelements : alert,url,title
				
				//WebDriverWait(C) -extends-> FluentWait(C) -implements-> Wait(I) --> until()methods
				
				//FluentWait(C) --> imp -->Wait(I) -->until();method
				//1.until -- overridden
				//2.individual methods : ignoring(),withMessage(),pollingEvery()
				
				//WebDriverWait(C) - extends -> FluentWait(C)
				//timeoutException() -- protected
				//1.until() -- inherited
				//2.inherited methods : ignoring(),withMessage(),pollingEvery()
		
	}

}
