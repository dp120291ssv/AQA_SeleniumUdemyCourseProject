package pages.repository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RepositoryPage extends BasePage {

	public RepositoryPage(WebDriver driver) {
		super(driver);
	}

	private final By loginButton = By.xpath("//a[@href='/login']");


///
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

}
