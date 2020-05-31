package tests.base;

import common.CommonActions;
import common.Config;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoans;
import pages.telecommunication.MobilePhoneReplenishment;
import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

public class BaseTest {

	protected CommonActions commonActions = CommonActions.getInstance();
	protected WebDriver driver = commonActions.driver;
	protected BasePage basePage = new BasePage(driver);
	protected CarLoans carLoans = new CarLoans(driver);
	protected MobilePhoneReplenishment mobilePhoneReplenishment = new MobilePhoneReplenishment(driver);
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

	/**
	 * A static initialization block in order to clean the folders with reports and screenshots before starting the build
	 */
	static {
		LOGGER.info("START TIME - " + LocalTime.now());
		LOGGER.info("Clear reports directory build/reports/ ...");
		File allureResults = new File("allure-results");
		if (allureResults.isDirectory()) {
			for (File item : Objects.requireNonNull(allureResults.listFiles())) {
				item.delete();
			}
		}
		if(Config.CLEAR_REPORTS_DIR) {
			File reports = new File("build/reports/tests/");
			if (reports.isDirectory()) {
				for (File item : Objects.requireNonNull(reports.listFiles())) {
					item.delete();
				}
			}
			File downloads = new File("build/downloads/");
			if (downloads.isDirectory()) {
				for (File item : Objects.requireNonNull(reports.listFiles())) {
					item.delete();
				}
			}
		}
	}
}