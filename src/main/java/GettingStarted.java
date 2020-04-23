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
		driver.navigate().to("https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/hidden");

		driver.switchTo().frame("frame_Example");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='okButton']")));
		WebElement buttonOk = driver.findElement(By.xpath("//div[@id='welcome']/button[@id='okButton']"));

		buttonOk.click();

		WebElement textWelcom = driver.findElement(By.xpath("//div[@id='awesome']/h1"));
		Assert.assertEquals("Thanks!", textWelcom.getText());



	}
}