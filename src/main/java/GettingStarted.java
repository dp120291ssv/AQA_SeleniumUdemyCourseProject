import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class GettingStarted {


	@Test
	public void testGoogleSearch() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver.get("http://www.google.com/");

//		driver.navigate().to("http://www.google.com/");
//		Set<String> oldWindow = driver.getWindowHandles();
//		System.out.println("oldWindow->" + oldWindow);
//
//		((JavascriptExecutor)driver).executeScript("window.open()");
//		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//
//		driver.switchTo().window(tabs.get(1));
//		driver.get("https://selenium.dev");
//
//		Set<String> newWindow = driver.getWindowHandles();
//		System.out.println("newWindow->" + newWindow);

//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();

//		String currentURL = driver.getCurrentUrl();
//		System.out.println("currentURL->" + currentURL);
//		Assert.assertEquals(currentURL, "http://www.google.com/");

//		String currentTitle = driver.getTitle();
//		System.out.println("currentTitle->" + currentTitle);
//		Assert.assertEquals(currentTitle, "ChromeDriver - Поиск в Google");

//		String pageSource = driver.getPageSource();
//		System.out.println("pageSource->" + pageSource);

		driver.quit();























	}
}