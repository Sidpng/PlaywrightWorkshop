package practiceSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class firstTest {

	public static void main(String args[]) {
		Playwright pw = Playwright.create();
		Browser browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
		Page page = browser.newPage();
		// Navigate to Google
		page.navigate("https://www.google.com");
		String title = page.title();
		System.out.println(title);
		System.out.println(page.url());
		page.close();
		browser.close();
		pw.close();

		//need to add further
	}
}

