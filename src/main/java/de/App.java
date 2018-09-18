package de;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class App {
    public static void main(String[] args) {
        RemoteWebDriver driver = createDriver();
        driver.navigate().to("https://web.whatsapp.com");
        // select some contact
        driver.findElement(By.xpath("//div[contains(@class, 'selectable-text')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'selectable-text')]")).sendKeys("Test");
    }

    private static RemoteWebDriver createDriver() {
        RemoteWebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");

        setChromeDriver();
        driver = new ChromeDriver(options);

        return driver;
    }

    private static void setChromeDriver() {
        String chromeBinary = "./chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeBinary);
    }
}