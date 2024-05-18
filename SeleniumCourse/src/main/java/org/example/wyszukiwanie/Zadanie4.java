package org.example.wyszukiwanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://hotel-testlab.coderslab.pl/en/");
            WebElement singInLink = driver.findElement(By.xpath("")
            );

        }
        finally {
            driver.close();
        }
    }
}
