/**
 * Test case name: lockedOutUser_OrderFlow
 * Description   : Locked out user should not be able to sign in to the Swag Labs website.
 * Precondition  : Before running test file, trace viewer should be configured.
 * Test priority : Medium
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

public class lockedOutUser_loginFlow {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();

			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true)); // tracing
																											// initialisation

			Page page = context.newPage();
			page.navigate("https://www.saucedemo.com/v1/");
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("locked_out_user");
			page.locator("[data-test=\"username\"]").press("Tab");
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.locator("[data-test=\"password\"]").press("Enter");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();

			context.tracing().stop(
					new Tracing.StopOptions().setPath(Paths.get("./src/main/java/traceViewerResults/traceLUOF.zip")));
			//configure trace file location and close tracing as well, before closing context, browser and page.

			context.close();
			page.close();
			browser.close();

		}
	}
}
