package org.example.wyszukiwanie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise03 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://hotel-testlab.coderslab.pl//en");

        }
        finally {
            driver.close();

        }
    }
}
