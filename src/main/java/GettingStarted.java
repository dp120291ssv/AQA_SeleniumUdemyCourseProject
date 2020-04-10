import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingStarted {


	@Test
	public void testGoogleSearch() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

//		driver.manage().window().setSize(new Dimension(1000, 1000));
//
//		driver.manage().window().maximize();
//
//		driver.manage().window().fullscreen();
//
//		System.out.println("getSize->" + driver.manage().window().getSize());
//
//		System.out.println("getPosition->" + driver.manage().window().getPosition());
//
//		driver.manage().window().setPosition(new Point(50, 50));

//		Set<String> logsType = driver.manage().logs().getAvailableLogTypes();
//		System.out.println("logsType->" + logsType);
//
//		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
//		for (LogEntry entry : logs) {
//			System.out.println("logs-> " + entry);
//		}

		driver.get("http://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ChromeDriver");
		searchBox.submit();
//		driver.quit();
	}
}