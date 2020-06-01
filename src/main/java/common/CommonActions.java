package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static common.Config.BROWSER_NAME;
import static constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER_NAME) {
            case "chrome_mac":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
			case "chrome_windows":
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "mozzila_mac":
				System.setProperty("webdriver.chrome.driver", "src/main/resources/geckodriver");
				driver = new ChromeDriver();
				break;
            default :
                Assertions.fail("INCORRECT BROWSER NAME - " + BROWSER_NAME);
		}
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
