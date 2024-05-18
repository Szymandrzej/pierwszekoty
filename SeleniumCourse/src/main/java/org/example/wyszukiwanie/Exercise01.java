package org.example.wyszukiwanie;

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

            driver.get("https://hotel-testlab.coderslab.pl/en/ ");

            WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
            hotelLocationInput.sendKeys("Warsaw");
            Thread.sleep(2000L);

            WebElement searchButton = driver.findElement(By.id("search_room_submit"));
            searchButton.click();
            Thread.sleep(2000L);

            WebElement enterYourEmail = driver.findElement(By.id("newsletter-input"));
            enterYourEmail.sendKeys("test@test.com");

            Thread.sleep(3000L);

        } finally {
            driver.quit();
        }
    }
}
