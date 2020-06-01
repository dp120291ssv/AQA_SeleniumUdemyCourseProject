package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    public WebDriver driver;
	private final By authWidgetP24New = By.xpath("//iframe[starts-with(@src,'https://login-widget')]");

	public BasePage(WebDriver driver){
        this.driver = driver;
    }

	/**
	 * A method for navigating to a specific URL
	 */
    public void goToURL(String URL) {
        driver.get(URL);
    }

	/**
	 * Waiting for visibility of element in DOM model
	 */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

	/**
	 * A method that cleans the element of the text and enters the desired text
	 * @param element Selenium WebElement
	 * @param value text
	 */
	protected void clearAndType(WebElement element, String value){
		while (!element.getAttribute("value").equals("")) element.sendKeys(Keys.BACK_SPACE);
		element.sendKeys(value);
	}

	/**
	 * Checking whether a frame for authorization
	 */
	public void checkIsDisplayedAuthWidget(){
		WebElement authFrame = driver.findElement(authWidgetP24New);
		waitElementIsVisible(authFrame);
	}
}
