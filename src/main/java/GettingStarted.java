import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GettingStarted {


	@Test
	public void testGoogleSearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//		driver.get("http://www.google.com/");
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();

		driver.navigate().to("https://next.privat24.ua/?lang=en");

		WebElement buttonSignIn = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//button[@data-qa-node='login']")));
		buttonSignIn.click();

		WebElement buttonContinue = wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Continue')]")));
//		buttonContinue.submit();

//		driver.quit();
	}
}