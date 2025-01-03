/**
 * Test case name: performanceGlitchUser_OrderFlow
 * Description   : Performance glitch user should be able to sign in and place an order in Swag Labs website.
 * Test priority : Medium
 * Test category : Functional testing
 * Author        : Siddhartha Upadhyay (Sidpng@Github)
 * Date          : 20 October, 2024
 */

package codeGenFeatureTesting;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.regex.Pattern;

public class performanceGlitchUser_OrderFlow {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			//BrowserContext context = browser.newContext();
			Page page = browser.newPage();
			page.navigate("https://demo.playwright.dev/todomvc/");
			page.navigate("https://demo.playwright.dev/todomvc/#/");
			page.navigate(
					"https://www.google.com/search?q=swag+labs&oq=swag+labs&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDYwNjVqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Swag Labs Swag Labs https://")).click();
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("performance_glitch_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.locator("div")
					.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^\\$29\\.99ADD TO CART$")))
					.getByRole(AriaRole.BUTTON).click();
			page.locator("div")
					.filter(new Locator.FilterOptions().setHasText(Pattern.compile("^\\$9\\.99ADD TO CART$")))
					.getByRole(AriaRole.BUTTON).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("2")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CHECKOUT")).click();
			page.locator("[data-test=\"firstName\"]").click();
			page.locator("[data-test=\"firstName\"]").fill("S");
			page.locator("[data-test=\"lastName\"]").click();
			page.locator("[data-test=\"lastName\"]").fill("U");
			page.locator("[data-test=\"postalCode\"]").click();
			page.locator("[data-test=\"postalCode\"]").fill("65676");
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