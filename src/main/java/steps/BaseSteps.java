package steps;

import needfortest.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 03.11.2018.
 */
public class BaseSteps {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void startUp(){
        ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get((String) TestProperties.getInstance().getProperties().get("app.url"));

    }

    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
