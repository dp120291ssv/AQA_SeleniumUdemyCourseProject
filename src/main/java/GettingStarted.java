import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted {


	@Test
	public void testGithub() throws InterruptedException {

		/**
		 * чек-лист: https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo
		 * */

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://github.com/");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")))
			.sendKeys("dp120291ssv+1@gmail.com");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")))
			.sendKeys("dp120291ssv1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Sign in']")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[@data-ga-click='Header, show menu, icon:avatar']")))
			.click();

		Assert.assertEquals("udemyTest1", wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class='css-truncate-target']")))
			.getText());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@class='logout-form']/button")))
			.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Sign up for GitHub')])[1]")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Forgot password?')]")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")))
			.sendKeys("dp120291ssv+1@gmail.com");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Send password reset email']")))
			.click();

		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Check your email for a link to reset your password. If it doesn’t appear within a few minutes, check your spam folder.')]")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")))
			.sendKeys("dp120291ssv+1@gmail.com");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")))
			.sendKeys("dp120291ssv1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Sign in']")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='/new'])[2]")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_name']")))
			.sendKeys("new1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_visibility_private']")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='repository_auto_init']")))
			.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create repository')]")))
			.click();

		Assert.assertEquals("udemyTest1", wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-hovercard-type='user'])[1]")))
			.getText());

		Assert.assertEquals("new1", wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-pjax='#js-repo-pjax-container']")))
			.getText());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Private')]")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='js-selected-navigation-item reponav-item'])[7]")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[contains(text(), 'Delete this repository')]")))
			.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='verify'])[3]")))
			.sendKeys("udemyTest1/new1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'I understand the consequences, delete this repository')]")))
			.click();

		Assert.assertEquals("Your repository \"udemyTest1/new1\" was successfully deleted.", wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='js-flash-container']/div/div")))
			.getAttribute("outerText"));

		driver.quit();
	}
}