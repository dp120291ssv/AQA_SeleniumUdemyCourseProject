package base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.authorization.AuthorizationPage;
import pages.repository.RepositoryPage;

public class BaseTest {
	WebDriver driver;
	public BasePage basePage = new BasePage(driver);
	public CommonActions commonActions = new CommonActions();
}
