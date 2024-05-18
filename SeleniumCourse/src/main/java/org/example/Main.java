package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("http://www.google.com");
            driver.get("https://coderslab.pl/pl");
            driver.get("https://mystore-testlab.coderslab.pl/index.php");
            driver.get("https://hotel-testlab.coderslab.pl/en/");
            Thread.sleep(6000L);


            WebElement element = driver.findElement(By.name("q"));
            element.clear();
            element.sendKeys("Utgard");
            element.submit();

            Thread.sleep(6000L);
        } finally {
            driver.quit();
        }
    }
}