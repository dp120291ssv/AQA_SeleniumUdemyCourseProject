import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted {




	@Test
	public void testGoogleSearch() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.navigate().to("https://next.privat24.ua/?lang=en");

		WebElement buttonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa-node='login']")));
		buttonLogin.click();

		WebElement frameLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://login-widget.privat24.ua/']")));

		driver.switchTo().frame(frameLogin);

		WebElement buttonContinue = wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//button[@type='submit']")));

		buttonContinue.click();

		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect value was entered')]")));


		driver.navigate().to("https://jsbin.com/kotirezuvo/edit?html,output");

		WebElement mainFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='stretch']")));
		driver.switchTo().frame(mainFrame);

		WebElement outputFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='JS Bin Output ']")));
		driver.switchTo().frame(outputFrame);

		WebElement inputNumberOfVtdeo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='seleniumCourse']")));
		inputNumberOfVtdeo.sendKeys("99");

		driver.switchTo().defaultContent();

		Assert.assertEquals(driver.getTitle(), "JS Bin - Collaborative JavaScript Debugging");






	}
}