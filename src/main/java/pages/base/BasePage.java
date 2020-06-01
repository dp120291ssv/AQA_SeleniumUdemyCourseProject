package pages.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loans.CarLoans;

import static constants.Constants.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    public WebDriver driver;

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
	 * A method for operating the slider
	 * @param element the element slider which is necessary to pull
	 * @param x the x-axis
	 * @param y the y-axis
	 */
	public void dragAndDropSum(WebElement element, int x, int y) {
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(element, x, x).perform();
	}
}
