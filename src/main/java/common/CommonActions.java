package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.authorization.AuthorizationPage;
import pages.repository.RepositoryPage;
import java.util.concurrent.TimeUnit;
import static constants.Constants.TimoutVeriables.IMPLICIT_WAIT;

public class CommonActions {

	public WebDriver driver;

	AuthorizationPage authorizationPage;
	RepositoryPage repositoryPage;

	public CommonActions(){
		initDriver();
	}

	// инициализация driver'a
	public WebDriver initDriver() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		assert driver != null;
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		return driver;
	}

	//Блок кода, где прокидываем в экземпляр страниц driver
	public AuthorizationPage getAuthorizationPage() {
		if (authorizationPage == null) {
			return new AuthorizationPage(driver);
		} else {
			return authorizationPage;
		}
	}

	public RepositoryPage getRepositoryPage() {
		if (repositoryPage == null) {
			return new RepositoryPage(driver);
		} else {
			return repositoryPage;
		}
	}
}
