package pages.telecommunication;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MobilePhoneReplenishment extends BasePage {

	public MobilePhoneReplenishment(WebDriver driver) {
		super(driver);
	}

	private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
	private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
	private final By inputCardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
	private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
	private final By inputCardCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
	private final By buttonSubmitPayment = By.xpath("//button[@data-qa-node='submit']");
	private final By cardNumberInTheCart = By.xpath("//td[@data-qa-node='card']");
	private final By recipientNameInTheCart = By.xpath("//span[@data-qa-node='nameB']");
	private final By amountInTheCart = By.xpath("//span[@data-qa-node='amount']");
	private final By commissionInTheCart = By.xpath("//span[@data-qa-node='commission']");
	private final By amountCurrencyInTheCard = By.xpath("//small[@data-qa-node='currency']");
	private final By commissionCurrencyInTheCard = By.xpath("//small[@data-qa-node='commission-currency']");

	/**
	 *
	 */
	public MobilePhoneReplenishment enterPhoneNumber(String phone){
		WebElement phoneNumber = driver.findElement(inputPhoneNumber);
		clearAndType(phoneNumber, phone);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment enterAmount(String sum){
		WebElement amount = driver.findElement(inputAmount);
		clearAndType(amount, sum);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment enterCardNumber(String number){
		WebElement cardNumber = driver.findElement(inputCardNumber);
		clearAndType(cardNumber, number);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment enterExpDate(String expDate){
		WebElement expiredDate = driver.findElement(inputCardExpDate);
		clearAndType(expiredDate, expDate);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment enterCvvCode(String cvv){
		WebElement cvvCode = driver.findElement(inputCardCvv);
		clearAndType(cvvCode, cvv);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment submitMobileReplenishment(){
		driver.findElement(buttonSubmitPayment).click();
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment checkPaymentCardAndRecipient(String cardFrom, String recipient){

		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment checkPaymentAmountAndCommission(String amount, String commission){
		Assertions.assertEquals(driver.findElement(amountInTheCart).getText(), amount);
		Assertions.assertEquals(driver.findElement(commissionInTheCart).getText(), commission);
		return this;
	}

	/**
	 *
	 */
	public MobilePhoneReplenishment checkPaymentCurrency(String Amount, String commission){

		return this;
	}
}