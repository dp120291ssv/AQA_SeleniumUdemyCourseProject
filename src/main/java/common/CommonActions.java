package common;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_NAME;
import static constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public WebDriver driver;
    public static CommonActions instance = null;

    public CommonActions() {
        switch (BROWSER_NAME) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    // static method to create instance of Singleton class
    public static CommonActions getInstance() {
        if (instance == null)
            instance = new CommonActions();
        return instance;
    }

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
