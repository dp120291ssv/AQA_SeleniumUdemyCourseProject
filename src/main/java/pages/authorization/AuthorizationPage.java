package pages.authorization;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class AuthorizationPage extends BasePage{
	/**
	 * чек-лист: https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo
	 * */

	WebDriver driver;

	public AuthorizationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginButton;

	@FindBy(xpath = "//input[@name='login']")
	WebElement inputFieldName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement inputFieldPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement submitLogin;

	@FindBy(xpath = "//summary[@data-ga-click='Header, show menu, icon:avatar']")
	WebElement userAvatar;

	public AuthorizationPage login(String userLogin, String userPassword){
		explicitWait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		explicitWait.until(ExpectedConditions.visibilityOf(inputFieldName)).sendKeys(userLogin);
		explicitWait.until(ExpectedConditions.visibilityOf(inputFieldPassword)).sendKeys(userPassword);
		explicitWait.until(ExpectedConditions.elementToBeClickable(submitLogin)).click();
		return this;
	}

	public AuthorizationPage checkIsUserAuthorized(){
		explicitWait.until(ExpectedConditions.visibilityOf(userAvatar));
		return this;
	}

//	public void test(){
//		driver.get("https://github.com/");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")))
//			.sendKeys("dp120291ssv+1@gmail.com");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")))
//			.sendKeys("dp120291ssv1");


//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Sign in']")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[@data-ga-click='Header, show menu, icon:avatar']")))
//			.click();



//
//		Assert.assertEquals("udemyTest1", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class='css-truncate-target']")))
//			.getText());
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@class='logout-form']/button")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Sign up for GitHub')])[1]")));
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Forgot password?')]")))
//			.click();
//
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