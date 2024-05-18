package org.example.zaliczenie;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber
public class exercise03 {

    public static void main(String[] args) throws InterruptedException {

// konfiguracja sterownika przeglądarki
        System.setProperty("web-driver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

// uruchom nowe okno przeglądarki
        WebDriver driver = new ChromeDriver();

        try {

// maksymalizuj okno przeglądarki
            driver.manage().window().maximize();
            driver.get("https://mystore-testlab.coderslab.pl./index.php?controller=authentication&back=my-account");

// logowanie na stworzonego użytkownika
            WebElement emailInput = driver.findElement(By.id("field-email"));
            emailInput.sendKeys("uqohfzlxridiekjavq@cazlv.com");

            WebElement passwordInput = driver.findElement(By.id("field-password"));
            passwordInput.sendKeys("MyStore");

// zatwierdza dane - email i password
            WebElement signInButton = driver.findElement(By.id("submit-login"));
            signInButton.click();

// wejdzie klikając w kafelek Addresses po zalogowaniu
            WebElement addressButton = driver.findElement(By.className("link-item"));
            addressButton.click();
            Thread.sleep(3000L);

            driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");

// wczytywanie tabeli Example, address, city, zip/postal code, country, phone
            String alias = "Kusi";
            String address = "Zwyciestwa";
            String city = "Gliwice";
            String postalCode = "44-100";
            String country = "Poland";
            String phone = "604604604";

// wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie

            WebElement aliasInput = driver.findElement(By.id("field-alias"));
            aliasInput.sendKeys(alias);

            WebElement addressInput = driver.findElement(By.id("field-address1"));
            addressInput.sendKeys(address);

            WebElement cityInput = driver.findElement(By.id("field-city"));
            cityInput.sendKeys(city);

            WebElement postalCodeInput = driver.findElement(By.id("field-postcode"));
            postalCodeInput.sendKeys(postalCode);

            WebElement countryInput = driver.findElement(By.id("field-id_country"));
            countryInput.sendKeys(country);

            WebElement phoneInput = driver.findElement(By.id("field-phone"));
            phoneInput.sendKeys(phone);

            WebElement saveButton = driver.findElement(By.className("form-control-submit"));
            saveButton.click();

            Thread.sleep(3000L);
        } finally {
            driver.quit();
        }
    }
}


/*
Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl.

Możesz wykorzystać tymczasowego maila do utworzenia użytkownika: https://10minutemail.com/.

Napisz skrypt, który:

będzie logować się na tego stworzonego użytkownika,
wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
kliknie w + Create new address,
wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone),
sprawdzi czy dane w dodanym adresie są poprawne.

 */