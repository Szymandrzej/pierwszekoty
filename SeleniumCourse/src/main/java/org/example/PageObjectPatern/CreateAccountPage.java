package org.example.PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private WebElement passwordInput;
    private WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        firstNameInput = driver.findElement(By.id("customer_firstname"));
        lastNameInput = driver.findElement(By.id("customer_lastname"));
        passwordInput = driver.findElement(By.id("passwd"));
        registerButton = driver.findElement(By.id("submitAccount"));
    }

    public void typeFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void typePassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void fillForm(String firstName, String lastName, String password) {
        typeFirstName(firstName);
        typeLastName(lastName);
        typePassword(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}