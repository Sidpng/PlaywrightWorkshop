/**
 * Test case name: standardUser_OrderFlow
 * Description   : Standard user should be able to sign in and place an order in Swag Labs website.
 * Precondition  : Before running test file, trace viewer should be configured.
 * Test priority : Medium
 * Test category : Functional testing
 * Author        : Siddhartha Upadhyay (Sidpng@Github)
 * Date          : 20 October, 2024
 */


package traceViewerFeaturesTesting;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class standardUser_OrderFlow {

	public static void main(String args[]) {
		try (Playwright playwright = Playwright.create()) {

			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();

			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

			Page page = context.newPage();
			page.navigate(
					"https://www.google.com/search?q=suacedemo&oq=suacedemo&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDIwOTdqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Swag Labs Swag Labs https://")).click();
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("standard_user");
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
			page.locator("[data-test=\"lastName\"]").press("Tab");
			page.locator("[data-test=\"postalCode\"]").fill("567676");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CONTINUE")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FINISH")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();

			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("./src/main/java/traceViewerResults/trace.zip")));

			context.close();
			page.close();
			browser.close();
		}
	}
}