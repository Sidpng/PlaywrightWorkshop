package codeGenFeatureTesting;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class lockedOutUser_loginAttempt {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			//BrowserContext context = browser.newContext();
			Page page = browser.newPage();
			page.navigate("https://demo.playwright.dev/todomvc/");
			page.navigate("https://demo.playwright.dev/todomvc/#/");
			page.navigate(
					"https://www.google.com/search?q=saucelabsdemo&oq=saucelabsdemo&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDMyNzRqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Swag Labs Swag Labs https://")).click();
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("locked_out_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.close();
			//context.close();
			browser.close();
		}
	}
}