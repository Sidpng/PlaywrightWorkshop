/**
 * Test case name: problemUser_OrderFlow
 * Description   : Problem user should be able to sign in and place an order in Swag Labs website.
 * Precondition  : Before running test file, trace viewer should be configured.
 * Test priority : Medium
 * Test category : Functional testing
 * Author        : Siddhartha Upadhyay (Sidpng@Github)
 * Date          : 20 October, 2024
 */

package traceViewerFeaturesTesting;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class problemUser_OrderFlow {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();

			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true)); // tracing

			Page page = context.newPage();
			page.navigate("https://www.saucedemo.com/v1/");
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("problem_user");
			page.locator("[data-test=\"username\"]").press("Tab");
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.locator("[data-test=\"password\"]").press("Enter");
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
			page.locator("[data-test=\"postalCode\"]").fill("676565");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CONTINUE")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FINISH")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();

			context.tracing().stop(
					new Tracing.StopOptions().setPath(Paths.get("./src/main/java/traceViewerResults/tracePUOF.zip")));
			// configure trace file location and close tracing as well, before closing
			// context, browser and page.

			page.close();
			context.close();
			browser.close();
		}
	}
}