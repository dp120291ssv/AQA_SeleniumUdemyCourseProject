package pages.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarLoansPage {

	WebDriver driver;
	public CarLoansPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By tabAgreements = By.xpath("//div[contains(text(), 'Agreements')]");

	public CarLoansPage selectAgreemntsTab(){
		driver.findElement(tabAgreements).click();
		return this;
	}
}
