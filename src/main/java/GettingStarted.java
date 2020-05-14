import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted {


	@Test
	public void testGoogleSearch() throws InterruptedException {

		/**
		 * чек-лист: https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo
		 * */

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://github.com/");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();

		WebElement inputName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='login']")));
		inputName.sendKeys("dp120291ssv+1@gmail.com");

		WebElement inputPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
		inputPassword.sendKeys("dp120291ssv1");

		WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Sign in']")));
		loginButton.click();

		WebElement avatarIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[@data-ga-click='Header, show menu, icon:avatar']")));
		avatarIcon.click();

		WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[@class='css-truncate-target']")));

		Assert.assertEquals("udemyTest1", userName.getText());

		WebElement logOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@class='logout-form']/button")));
		logOutButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Sign up for GitHub')])[1]")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/login']"))).click();

		WebElement forgotPasswordButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Forgot password?')]")));
		forgotPasswordButton.click();
		
	}
}