package codeGenFeatureTesting;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class standardUser_RandomClicks {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			//BrowserContext context = browser.newContext();
			Page page = browser.newPage();
			page.navigate("https://demo.playwright.dev/todomvc/");
			page.navigate("https://demo.playwright.dev/todomvc/#/");
			page.navigate(
					"https://www.google.com/search?q=swag+labs&oq=swag+labs&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDI5MDZqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.navigate("https://www.saucedemo.com/v1/");
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("standard_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All Items")).click();
			page.close();
			browser.close();
		}
	}

}
