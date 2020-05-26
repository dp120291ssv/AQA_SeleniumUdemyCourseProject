package common;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback {

	CommonActions commonActions;
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
		attachScreenshotToAllure();
	}

	@Attachment(value = "Attachment Screenshot", type = "image/png")
	public byte[] attachScreenshotToAllure() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
