package org.example.wyszukiwanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("web-driver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://hotel-testlab.coderslab.pl/en/");
            Thread.sleep(2000L);

            WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
            hotelLocationInput.sendKeys("Warsaw");
            Thread.sleep(2000L);

            WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
            searchNowButton.submit();
            Thread.sleep(2000L);

            WebElement enterYourEmailInput = driver.findElement(By.name("email"));
            enterYourEmailInput.sendKeys("email@email.com");
            Thread.sleep(2000L);

            WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
            subscribeButton.submit();

            Thread.sleep(2000L);
        } finally {
            driver.close();
        }
    }
}
