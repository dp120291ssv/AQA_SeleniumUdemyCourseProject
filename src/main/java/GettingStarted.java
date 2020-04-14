import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GettingStarted {

	@Test
	public void testGoogleSearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		driver.get("http://next.privat24.ua");


		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa-node='login11111']")));
		loginButton.click();
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();
//		driver.quit();
	}
}