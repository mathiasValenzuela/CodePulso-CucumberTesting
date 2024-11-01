package DefinicionPasos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final String PATH_DRIVER = "./src/test/resources/chrome/chromedriver.exe";
    private static final String TIPO_DRIVER = "webdriver.chrome.driver";

    public static void initializeDriver() {
        if (driver == null) {
            System.setProperty(TIPO_DRIVER, PATH_DRIVER);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
