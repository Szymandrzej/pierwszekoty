package org.example.PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        signInLink = driver.findElement(By.cssSelector(".hide_xs"));
    }

    public void clickSignInLink() {
        signInLink.click();
    }
}