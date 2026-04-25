/*
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SearchPage;

public class DriverFactory {

    private static WebDriver driver;
    SearchPage page;

    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                // driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Browser not supported: " + browser);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver not initialized. Call initDriver() first.");
        }
        return driver;
    }

        public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}*/
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver() {

        if (driver == null) {

            System.out.println("Creating ChromeDriver...");

            driver = new ChromeDriver();

            System.out.println("Driver created: " + driver);

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            System.out.println("Quitting driver...");
            driver.quit();
            driver = null;
        }
    }
}