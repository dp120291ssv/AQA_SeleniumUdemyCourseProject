package common;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback {

	CommonActions commonActions = new CommonActions();
	protected WebDriver driver = commonActions.driver;
	private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

	@Override
	public void beforeAll(ExtensionContext extensionContext) throws Exception {
		extensionContext.getRoot().getStore(GLOBAL).put(true, this);
	}

	@Override
	public void afterEach(ExtensionContext extensionContext) throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
//		captureScreenshot();
		attachScreenshotToAllure();
	}

	@Attachment(value = "Attachment Screenshot", type = "image/png")
	public byte[] attachScreenshotToAllure() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Rule
	public TestRule screenshotRule = new org.junit.rules.TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			captureScreenshot(description.getMethodName());
		}
	};

	private void captureScreenshot(String name) {
		File screenshot = ((TakesScreenshot) driver)
			.getScreenshotAs(OutputType.FILE);
		String path = "./screenshots/" + screenshot.getName();
		try {
			FileUtils.copyFile(screenshot, new File(path));
		} catch (IOException e) {

		}
	}
}
