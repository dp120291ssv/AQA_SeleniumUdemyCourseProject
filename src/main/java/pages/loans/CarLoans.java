package pages.loans;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.base.BasePage;

public class CarLoans extends BasePage{

	public CarLoans(WebDriver driver) {
		super(driver);
	}

	private final By agreementsTab = By.xpath("//div[contains(text(), 'Договори') and .//parent::a[@href='/auto-credit/my']]");
	private final By authWidgetP24New = By.xpath("//iframe[starts-with(@src,'https://login-widget')]");
	private final By amountFieldCarCost = By.xpath("//input[@data-qa-node='amount']");
	private final By amountFieldPrepaidExpense = By.xpath("//input[@data-qa-node='prepaid']");
	private final By phoneCodeButton = By.xpath("//button[@data-qa-node='phone-code']");
	private final By searchPhoneCodeField = By.xpath("//input[@placeholder = 'Search' and .//ancestor::div[@data-qa-node]]");
	private final By phoneNumberField = By.xpath("//input[@data-qa-node = 'phone-number' and @placeholder = '000000000']");
	private final By applyOrderButton = By.xpath("//button[@type = 'button' and contains(text(), 'Submit an application')]");
	private final By applyOrderButtonInAgreements = By.xpath("//button[contains(text(), 'Оформити') and .//ancestor::a[@href='/auto-credit/order']]");
	private final By getALoanSection = By.xpath("//div[contains(text(), 'Оформити') and .//parent::a[@href='/auto-credit/order']]");
	private final By selectedUsedAutoTab = By.xpath("//div[@data-qa-node='type' and contains(text(), 'With mileage')]");
	private final By newAutoTypeTab = By.xpath("//label[@data-id='new' and contains(text(), 'Нове')]");
	private final By sliderButtonSum = By.xpath("(//input[@value]//following-sibling::div//button)[2]");
	private final By confirmForm = By.xpath("//div[contains(text(), 'One-time password has been forwarded to your phone')]");
	private final By buttonCountryRussia = By.xpath("//div[@name='Russia']");

//	/**
//	 * Выбор вкладки Договоры ======
//	 */
//	public CarLoans selectAgreementsTab(){
//		agreementsTab.should(visible).click();
//		return this;
//	}

//	/**
//	 * Выбор вкладки "Новое" авто =========
//	 */
//	public CarLoans selectTabANewAuto(){
//		newAutoTypeTab.should(visible).click();
//		return this;
//	}

//	/**
//	 * Проверка отображения виджета для авторизации ======
//	 */
//	public CarLoans checkIsDisplayedAuthWidget(){
//		authWidgetP24New.should(exist);
//		return this;
//	}

	/**
	 * Test display of the form confirmation of transaction
	 */
	public CarLoans checkIsDisplayedConfirm(){
		waitElementIsVisible(driver.findElement(confirmForm));
		return this;
	}

	/**
	 * Enter the amount of the car value
	 * @param amount the full cost of a car
	 */
	public CarLoans enterAmountFieldCarCost(String amount) {
		WebElement amountField = driver.findElement(amountFieldCarCost);
		clearAndType(amountField, amount);
		return this;
	}

//	/**
//	 * Проверка суммы аванса после перетаскивания с предыдущим значением аванса ==========
//	 */
//	public CarLoans checkPrepaidExpenseSumAfterDragAndDrop(String oldSum) {
//		Assert.assertNotSame($x("//input[@data-qa-node='prepaid']").getAttribute("value"), oldSum);
//		return this;
//	}

	/**
	 * Enter the advance amount for the loan
	 * @param amount the amount of the advance payment
	 */
	public CarLoans enterAmountFieldPrepaidExpense(String amount) {
		WebElement amountField = driver.findElement(amountFieldPrepaidExpense);
		clearAndType(amountField, amount);
		return this;
	}

	/**
	 * Filling in the mobile number to apply
	 * @param phoneNumber mobile number to apply
	 */
	public CarLoans enterPhoneNumber(String phoneNumber) {
		driver.findElement(phoneNumberField).clear();
		driver.findElement(phoneNumberField).sendKeys(phoneNumber);
		return this;
	}

	/**
	 * Search country code for mobile communications
	 * @param phoneNumber mobile number to apply
	 */
	public CarLoans searchPhoneCountryCodeField(String phoneNumber) {
		driver.findElement(searchPhoneCodeField).clear();
		driver.findElement(searchPhoneCodeField).sendKeys(phoneNumber);
		return this;
	}

	/**
	 * Selection of drop down list of codes of countries, mobile communications
	 */
	public CarLoans selectPhoneCodeButton() {
		driver.findElement(phoneCodeButton).click();
		return this;
	}

//	/**
//	 * Выбор вопроса из списка вопросов
//	 */
//	public CarLoans selectSomeQuestion(String text) {
//		$x("//div[contains(text(), '" + text + "')]").should(visible).click();
//		return this;
//	}

	/**
	 * Confirmation of application for credit
	 */
	public CarLoans submitOrderButton() {
		driver.findElement(applyOrderButton).click();
		return this;
	}

	/**
	 * Check that the selected tab is "With mileage"
	 */
	public CarLoans checkSelectedTabWithMileageAuto() {
		waitElementIsVisible(driver.findElement(selectedUsedAutoTab));
		return this;
	}

//	/**
//	 * Проверка, что выбран таб "Авто с пробегом"
//	 */
//	public CarLoans checkSelectedGetALoanSection() {
//		getALoanSection.should(visible);
//		return this;
//	}

	/**
	 * Select the country code from the drop down list
	 */
	public CarLoans selectCountryCountryRussiaFromList() {
		driver.findElement(buttonCountryRussia).click();
		return this;
	}

//	/**
//	 * Перетаскивание суммы кредита на слайдере =======
//	 */
//	public CarLoans dragAndDropSum() {
//		Actions actions = new Actions(WebDriverRunner.getWebDriver());
//		actions.dragAndDropBy(sliderButtonSum, 600, 0).perform();
//		return this;
//	}

}