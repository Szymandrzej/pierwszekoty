package org.example.konfiguracja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise03 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://www.google.com");
            Thread.sleep(2000l);

            driver.get("https://coderslab.pl/pl");
            Thread.sleep(2000l);

            driver.navigate().back();
            Thread.sleep(2000l);

            driver.get("https://mystore-testlab.coderslab.pl/index.php");
            Thread.sleep(2000l);

            driver.get("https://www.google.com");
            Thread.sleep(2000l);

            driver.navigate().back();
            Thread.sleep(2000l);

            driver.navigate().refresh();

            Thread.sleep(3000l);
        } finally {
            driver.quit();
        }
    }
}
