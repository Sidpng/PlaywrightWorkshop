package codeGenFeatureTesting;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class standardUser_AboutUsFlow {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.saucedemo.com/v1/");
			page.locator("[data-test=\"username\"]").click();
			page.locator("[data-test=\"username\"]").fill("standard_user");
			page.locator("[data-test=\"password\"]").click();
			page.locator("[data-test=\"password\"]").fill("secret_sauce");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About")).click();
			page.close();
			browser.close();
		}
	}

}
