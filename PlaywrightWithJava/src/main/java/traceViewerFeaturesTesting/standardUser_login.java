/**
 * Test case name: standardUser_login
 * Description   : Standard user should be able to login in Swag Labs website.
 * Precondition  : Before running test file, trace viewer should be configured.
 * Test priority : Low
 * Test category : Functional testing
 * Author        : Siddhartha Upadhyay (Sidpng@Github)
 * Date          : 20 October, 2024
 */

package traceViewerFeaturesTesting;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class standardUser_login {

	public static void main(String args[]) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();

			// to start the tracing

			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

			Page page = context.newPage();
			page.navigate(
					"https://www.google.com/search?q=saucedemo&oq=suacedemo&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDIwOTdqMGo0qAIAsAIA&sourceid=chrome&ie=UTF-8");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Swag Labs Swag Labs https://")).click();
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("standard_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();

			// to close the tracing

			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("./src/main/java/traceViewerResults/trace.zip")));

			context.close();
			page.close();
			browser.close();
		}
	}

}
