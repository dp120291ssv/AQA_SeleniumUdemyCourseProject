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

		driver.navigate().to("https://www.facebook.com/login.php");
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
		loginButton.click();

//		WebElement createAccButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
//		createAccButton.click();

	}
}