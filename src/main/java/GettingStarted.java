import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted {


	@Test
	public void testGoogleSearch() {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		driver.get("http://www.google.com/");
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();
//		driver.quit();

		driver.navigate().to("https://next.privat24.ua/?lang=en");

		WebElement linkExchangeRates = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rates_2g6teezjyl']")));
		linkExchangeRates.click();

		WebElement buttonExchange = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa-node='exchange']")));
		buttonExchange.click();

		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-qa-node='exchange']"))));
	}
}