package org.example.PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class AuthenticationPage {

    private WebDriverWait wait;
    private WebElement emailInput;
    private WebElement createAccountButton;

    public AuthenticationPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        emailInput = driver.findElement(By.id("email_create"));
        createAccountButton = driver.findElement(By.id("SubmitCreate"));
    }

    public void typeEmailAddress(String email) {
        emailInput.sendKeys(email);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
        wait.until(urlContains("#account-creation"));
    }
}