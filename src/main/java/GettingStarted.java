import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Set;

public class GettingStarted {

	public void getConsoleLog(WebDriver driver){
		LogEntries logs = driver.manage().logs().get("browser");

		for (LogEntry entry : logs) {
			System.out.println("logs-> " + entry.getMessage());
		}
	}

	@Test
	public void testGoogleSearch() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//		driver.get("http://www.google.com/");
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();

		Set<String> logsType = driver.manage().logs().getAvailableLogTypes();
		System.out.println("logsType->" + logsType);

		driver.get("http://www.google.com/");

		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

		for (LogEntry entry : logs) {
			System.out.println("logs-> " + entry);
		}

//		driver.quit();
	}
}