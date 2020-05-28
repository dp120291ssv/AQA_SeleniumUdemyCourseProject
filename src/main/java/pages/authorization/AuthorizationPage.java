package pages.authorization;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class AuthorizationPage extends BasePage{

	/**
	 * чек-лист: https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo
	 * */

	public AuthorizationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private final By loginButton = By.xpath("//a[@href='/login']");
	private final By inputFieldName = By.xpath("//input[@name='login']");
	private final By inputFieldPassword = By.xpath("//input[@name='password']");
	private final By submitLogin = By.xpath("//input[@value='Sign in']");
	private final By userAvatar = By.xpath("//details[@class='details-overlay details-reset js-feature-preview-indicator-container']");
	private final By userName = By.xpath("//a[contains(text(), 'Signed in as ')]/strong"); // сказать про новый селектор
	private final By logOutButton = By.xpath("//form[@class='logout-form']");
	private final By mainLoginButton = By.xpath("(//button[contains(text(), 'Sign up for GitHub')])[1]");
	private final By forgotPassword = By.xpath("//a[contains(text(), 'Forgot password?')]");
	private final By inputEmail = By.xpath("//input[@name='email']");

	/**
	 * Select button LogIn
	 * */
	public AuthorizationPage selectLoginForm(){
		driver.findElement(loginButton).click();
		return this;
	}

	/**
	 * Select button LogIn and then enter the login name
	 * @param userLogin - user login
	 * */
	public AuthorizationPage typeLogin(String userLogin){
		driver.findElement(inputFieldName).sendKeys(userLogin);
		return this;
	}

	/**
	 * Select button LogIn and then enter the password login
	 * @param userPassword - password login
	 * */
	public AuthorizationPage typePassword(String userPassword){
		driver.findElement(inputFieldPassword).sendKeys(userPassword);
		return this;
	}

	public AuthorizationPage submitAuthorization(){
		driver.findElement(submitLogin).click();
		return this;
	}

	/**
	 * Select user picture in user profile
	 * */
	public AuthorizationPage selectUserProfilePicture(){
		driver.findElement(userAvatar).click();
		return this;
	}

	/**
	 * Select button LogOut
	 * */
	public AuthorizationPage selectLogOut(){
		driver.findElement(logOutButton).submit();
		return this;
	}

	/**
	 * Select button password recovery
	 * */
	public AuthorizationPage passwordRecovery(){
		driver.findElement(forgotPassword).submit();
		return this;
	}

	/**
	 * Check authorized if the website required the user
	 * @param userProfileName user name
	 * */
	public AuthorizationPage checkIsCorrectUserAuthorized(String userProfileName){
		Assertions.assertEquals(userProfileName, waitElementIsVisible(driver.findElement(userName)).getText());
		return this;
	}

	/**
	 * Проверка того, что пользователь находится на главной странице и не авторизован
	 * */
	public AuthorizationPage checkIsUserNotAuthorized(){
		driver.findElement(mainLoginButton).isDisplayed();
		return this;
	}



//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")))
//			.sendKeys("dp120291ssv+1@gmail.com");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Send password reset email']")))
//			.click();
//
//		explicitWait.until(ExpectedConditions
//			.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Check your email for a link to reset your password. If it doesn’t appear within a few minutes, check your spam folder.')]")));
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")))
//			.sendKeys("dp120291ssv+1@gmail.com");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")))
//			.sendKeys("dp120291ssv1");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Sign in']")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='/new'])[2]")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_name']")))
//			.sendKeys("new1");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_visibility_private']")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_auto_init']")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create repository')]")))
//			.click();
//
//		Assert.assertEquals("udemyTest1", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-hovercard-type='user'])[1]")))
//			.getText());
//
//		Assert.assertEquals("new1", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-pjax='#js-repo-pjax-container']")))
//			.getText());
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Private')]")));
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='js-selected-navigation-item reponav-item'])[7]")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[contains(text(), 'Delete this repository')]")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='verify'])[3]")))
//			.sendKeys("udemyTest1/new1");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'I understand the consequences, delete this repository')]")))
//			.click();
//
//		Assert.assertEquals("Your repository \"udemyTest1/new1\" was successfully deleted.", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='js-flash-container']/div/div")))
//			.getAttribute("outerText"));
//
//		driver.quit();
//	}
}