package org.example.konfiguracja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://coderslab.pl/pl");
            Thread.sleep(3000L);

            driver.get("https://mystore-testlab.coderslab.pl/index.php");
            Thread.sleep(3000L);

            driver.get("https://hotel-testlab.coderslab.pl/en/");
            Thread.sleep(3000L);

        } finally {
            driver.quit();
        }
    }
}
