package codeGenFeatureTesting;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.regex.Pattern;

public class problemUser_OrderFlow {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			//BrowserContext context = browser.newContext();
			Page page = browser.newPage();
			page.navigate("https://demo.playwright.dev/todomvc/");
			page.navigate("https://demo.playwright.dev/todomvc/#/");
			page.navigate(
					"https://www.google.com/search?q=saucelabs&oq=saucelabs&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDM5MDVqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.navigate(
					"https://www.google.com/search?q=swag+labs&oq=swag+labs&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDE2MjZqMGo5qAIAsAIB&sourceid=chrome&ie=UTF-8");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Swag Labs Swag Labs https://")).click();
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("problem_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.locator("div")
					.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^\\$29\\.99ADD TO CART$")))
					.getByRole(AriaRole.BUTTON).click();
			page.locator("div")
					.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^\\$9\\.99ADD TO CART$")))
					.getByRole(AriaRole.BUTTON).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CHECKOUT")).click();
			page.locator("[data-test=\"firstName\"]").click();
			page.locator("[data-test=\"firstName\"]").fill("S");
			page.locator("[data-test=\"firstName\"]").press("Tab");
			page.locator("[data-test=\"lastName\"]").fill("U");
			page.locator("[data-test=\"lastName\"]").press("Tab");
			page.locator("[data-test=\"firstName\"]").click();
			page.locator("[data-test=\"firstName\"]").fill("S");
			page.locator("[data-test=\"postalCode\"]").click();
			page.locator("[data-test=\"postalCode\"]").fill("508988");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CONTINUE")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FINISH")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
			page.close();
			//context.close();
			browser.close();
		}
	}
}