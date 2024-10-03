package playwright.projects;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {
    protected Browser browser;
    protected Page page;
    Playwright playwright;

    public void setup() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false); // For non-headless execution
        browser = playwright.chromium().launch(options);
        page = browser.newPage();
    }

    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
