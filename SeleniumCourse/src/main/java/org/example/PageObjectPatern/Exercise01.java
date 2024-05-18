package org.example.PageObjectPatern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();

            // 1. Wejdź na stronę główną
            driver.get("https://hotel-testlab.coderslab.pl/en/");

            // 2. Kliknij na link sign in
            HomePage homePage = new HomePage(driver);
            homePage.clickSignInLink();

            // 3. Wpisz losowy adres email
            AuthenticationPage authPage = new AuthenticationPage(driver);
            String randomEmail = FakeTestData.getRandomEmailAddress();
            authPage.typeEmailAddress(randomEmail);

            // 4. Kliknij utworz konto
            authPage.clickCreateAccountButton();

            // 5. Uzupelnij formularz z danymi uzytkownika
            CreateAccountPage createAccountPage = new CreateAccountPage(driver);
            createAccountPage.fillForm("John", "Doe", "password");

            // 6. Kliknij przycisk register
            createAccountPage.clickRegisterButton();

            Thread.sleep(2000);

        } finally {
            driver.close();
        }
    }
}