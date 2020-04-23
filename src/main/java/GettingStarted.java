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

		driver.navigate().to("https://next.privat24.ua/money-transfer/card?lang=en");

		WebElement addCommentLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-qa-node='toggle-comment']")));
		addCommentLink.click();

		WebElement commentField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@data-qa-node='comment']")));

		WebElement closeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Close']")));
		closeElement.click();

		Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(commentField)));
	}
}