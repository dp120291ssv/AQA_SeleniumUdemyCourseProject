package common;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import static common.Config.CLEAR_COOKIES;
import static common.Config.HOLD_BROWSER_OPEN;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback, ExtensionContext.Store.CloseableResource {

    CommonActions commonActions = CommonActions.getInstance();
    private WebDriver driver = commonActions.driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot().getStore(GLOBAL).put(true, this);
    }

	/**
	 * CloseableResource implementation, adding value into GLOBAL context is required to registers a callback hook
	 * With such steps close() method will be executed only once in the end of test execution
	 */
	@Override
	public void close(){
    	if(!HOLD_BROWSER_OPEN){
			driver.quit();
    	}
	}

    @Override
    public void afterEach(ExtensionContext extensionContext) {
    	if(CLEAR_COOKIES) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			driver.manage().deleteAllCookies();
			executor.executeScript("window.sessionStorage.clear()");
		}
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - FAILED!", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() + "_" + String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("Trying to tace screenshot...");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/tests/" + screenshotName + ".png"));
            LOGGER.info("Screenshot \"{}\" was saved in build/reports/tests ", screenshotName);
        } catch (IOException e) {
			LOGGER.info("Exception on saving screenshot!");
            e.printStackTrace();
        }
        attachScreenshotToAllure(ts);
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}