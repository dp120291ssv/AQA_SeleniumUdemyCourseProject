package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecomunications.MobilePhoneReplenishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.CLEAR_COOKIES;
import static common.Config.CLEAR_REPORTS_DIR;
import static common.Config.HOLD_BROWSER_OPEN;

@ExtendWith(Listener.class)
//@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

	protected WebDriver driver = CommonActions.createDriver();
	protected BasePage basePage = new BasePage(driver);
	protected CarLoansPage carLoansPage = new CarLoansPage(driver);
	protected MobilePhoneReplenishmentPage mobilePhoneReplenishmentPage = new MobilePhoneReplenishmentPage(driver);
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);


	/***/
	static {
		LOGGER.info("START TIME:" + LocalTime.now());
		LOGGER.info("Start clear reports dir: build/reports ...");
		File allureResults = new File("allure-results");
		if(allureResults.isDirectory()){
			for (File item : Objects.requireNonNull(allureResults.listFiles()))
				item.delete();
		}

		if(CLEAR_REPORTS_DIR){
			File allureScreenshots = new File("build/reports/tests");
			for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
				item.delete();
		}
	}

	@AfterEach
	void clearCookiesAndLocalStorage(){
		if(CLEAR_COOKIES){
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			driver.manage().deleteAllCookies();
			javascriptExecutor.executeScript("window.sessionStorage.clear()");
		}
	}

	@AfterAll
	void close(){
		if(!HOLD_BROWSER_OPEN){
			driver.close();
		}
	}
}
