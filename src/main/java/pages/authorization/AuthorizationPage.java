package pages.authorization;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.base.BasePage;

public class AuthorizationPage extends BasePage{

	public AuthorizationPage(WebDriver driver) {
		super(driver);
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
	private final By submitResetPassword = By.xpath("//input[@name='commit']");
	private final By textOfRecoveryPasswordSuccess = By.xpath("//p[contains(text(), 'Check your email for a link to reset your password. If it doesn’t appear within a few minutes, check your spam folder.')]");

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

	/**
	 * Enter the e-mail
	 * @param userEmail - user email
	 * */
	public AuthorizationPage typeEmail(String userEmail){
		driver.findElement(inputEmail).sendKeys(userEmail);
		return this;
	}

	/**
	 * Confirm authorization
	 * */
	public AuthorizationPage submitAuthorization(){
		driver.findElement(submitLogin).click();
		return this;
	}

	/**
	 * Confirm recovery password
	 * */
	public AuthorizationPage submitResetPasswordWithEmail(){
		driver.findElement(submitResetPassword).click();
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
		driver.findElement(logOutButton).click();
		return this;
	}

	/**
	 * Select button password recovery
	 * */
	public AuthorizationPage selectPasswordRecovery(){
		driver.findElement(forgotPassword).click();
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
	 * Check that the user is on the main page and not logged in
	 * */
	public AuthorizationPage checkIsUserNotAuthorized(){
		driver.findElement(mainLoginButton).isDisplayed();
		return this;
	}

	/**
	 * Check that the user is on the main page and not logged in
	 * */
	public AuthorizationPage checkIsResetPasswordSuccess(){
		driver.findElement(textOfRecoveryPasswordSuccess).isDisplayed();
		return this;
	}
}