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
	private final By walletButton = By.xpath("//div[@data-qa-node='debitSourceSource']");

	/**
	 * Enter a phone number excluding country code
	 * @param phone phone number
	 */
	public MobilePhoneReplenishment enterPhoneNumber(String phone){
		WebElement phoneNumber = driver.findElement(inputPhoneNumber);
		clearAndType(phoneNumber, phone);
		return this;
	}

	/**
	 * Enter the amount of replenishment of the mobile phone number
	 * @param sum amount of replenishment
	 */
	public MobilePhoneReplenishment enterAmount(String sum){
		WebElement amount = driver.findElement(inputAmount);
		clearAndType(amount, sum);
		return this;
	}

	/**
	 * Enter the card number for payment
	 * @param number card number
	 */
	public MobilePhoneReplenishment enterCardNumber(String number){
		WebElement cardNumber = driver.findElement(inputCardNumber);
		clearAndType(cardNumber, number);
		return this;
	}

	/**
	 * Enter the card expiry date for payment
	 * @param expDate expiry date
	 */
	public MobilePhoneReplenishment enterExpDate(String expDate){
		WebElement expiredDate = driver.findElement(inputCardExpDate);
		clearAndType(expiredDate, expDate);
		return this;
	}

	/**
	 * Enter the cvv code from the card for payment
	 * @param cvv the cvv code
	 */
	public MobilePhoneReplenishment enterCvvCode(String cvv){
		WebElement cvvCode = driver.findElement(inputCardCvv);
		clearAndType(cvvCode, cvv);
		return this;
	}

	/**
	 * Acceptance of payment
	 */
	public MobilePhoneReplenishment submitMobileReplenishment(){
		driver.findElement(buttonSubmitPayment).click();
		return this;
	}

	/**
	 * Choose a card from the wallet
	 */
	public MobilePhoneReplenishment selectCardFromWallet(){
		driver.findElement(walletButton).click();
		return this;
	}

	/**
	 * Check the card number with which the payment and the recipient
	 * @param cardFrom the card number for payment
	 * @param recipient mobile operator
	 */
	public MobilePhoneReplenishment checkPaymentCardAndRecipient(String cardFrom, String recipient){
		Assertions.assertEquals(driver.findElement(cardNumberInTheCart).getText().split(" ")[3], cardFrom);
		Assertions.assertEquals(driver.findElement(recipientNameInTheCart).getText(), recipient);
		return this;
	}

	/**
	 * Check the amount and Commission amount
	 * @param amount the amount will be credited to the mobile account
	 * @param commission the commission in addition to mobile account
	 */
	public MobilePhoneReplenishment checkPaymentAmountAndCommission(String amount, String commission){
		Assertions.assertEquals(waitElementIsVisible(driver.findElement(amountInTheCart)).getText(), amount);
		Assertions.assertEquals(driver.findElement(commissionInTheCart).getText(), commission);
		return this;
	}

	/**
	 * Check the currency of the payment amount and currency of fee
	 * @param currencyAmount currency of the payment
	 * @param commissionAmount currency of fee
	 */
	public MobilePhoneReplenishment checkPaymentCurrency(String currencyAmount, String commissionAmount){
		Assertions.assertEquals(waitElementIsVisible(driver.findElement(amountCurrencyInTheCard)).getText().split(" ")[1], currencyAmount);
		Assertions.assertEquals(driver.findElement(commissionCurrencyInTheCard).getText().split(" ")[1], commissionAmount);
		return this;
	}
}