package tests.base;

import common.CommonActions;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.authorization.AuthorizationPage;

import java.io.File;
import java.io.IOException;

public class BaseTest {

	protected CommonActions commonActions = CommonActions.getInstance();
	protected WebDriver driver = commonActions.driver;
	protected BasePage basePage = new BasePage(driver);
	protected AuthorizationPage authorizationPage = new AuthorizationPage(driver);


	@Rule
	public TestRule screenshotRule = new TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			captureScreenshot(description.getMethodName());
		}
	};

	private void captureScreenshot(String name) {
		File screenshot = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		String path = "./target/screenshots/" + screenshot.getName();
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {

		}
	}
}
