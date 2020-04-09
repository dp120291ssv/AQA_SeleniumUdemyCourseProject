import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GettingStarted {

	@Test
	public void testGoogleSearch() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();

 		driver.get("https://github.com/dp120291ssv");

		Cookie someNameForCookie = new Cookie("user_session", "m0IXeaEwYZCmde2eWbGiDaGv8G2HZtx5sV-lwS-GDczCWQHI");
		driver.manage().addCookie(someNameForCookie);
		driver.navigate().refresh();

		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("allCookies->" + allCookies);

		Cookie userLogin = driver.manage().getCookieNamed("dotcom_user");
		System.out.println("userLogin->" + userLogin);

		driver.manage().deleteCookie(userLogin);
		System.out.println("deleteCookie userLogin ->" + driver.manage().getCookies());

		driver.manage().deleteAllCookies();
		System.out.println("deleteAllCookies->" + driver.manage().getCookies());

//		driver.quit();
	}
}