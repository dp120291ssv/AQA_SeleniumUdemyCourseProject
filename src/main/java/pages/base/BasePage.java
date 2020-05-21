package pages.base;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.repository.RepositoryPage;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariables.EXPLICIT_WAIT;
import static constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToURL(String URL) {
        driver.get(URL);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
