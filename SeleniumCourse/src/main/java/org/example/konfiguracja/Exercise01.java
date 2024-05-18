package org.example.konfiguracja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web-driver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://www.google.com");

            Thread.sleep(6000L);

            WebElement element = driver.findElement(By.name("q"));
            element.clear();
            element.sendKeys("https://utgardgliwice.eu/");
            element.submit();

            Thread.sleep(6000L);

        } finally {
            driver.quit();
        }
    }
}