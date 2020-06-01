package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static common.Config.BROWSER_NAME;
import static constants.Constants.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public WebDriver driver;
    public static CommonActions instance = null;

    /**
     *Select and install the driver according to the selected version in the config
	 */
    public CommonActions() {
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
		}
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

	/**
	 * static method to create instance of Singleton class
	 */
    public static CommonActions getInstance() {
        if (instance == null)
            instance = new CommonActions();
        return instance;
    }
}
