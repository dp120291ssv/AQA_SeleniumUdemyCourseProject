package tests.base;

import common.CommonActions;
import common.Config;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoans;
import pages.telecommunication.MobilePhoneReplenishment;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

import static common.Config.CLEAR_COOKIES;
import static common.Config.HOLD_BROWSER_OPEN;

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
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
        if (Config.CLEAR_REPORTS_DIR) {
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

    @AfterEach
    void clearBrowserCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            executor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void close() {
        if (HOLD_BROWSER_OPEN) driver.close();
    }
}