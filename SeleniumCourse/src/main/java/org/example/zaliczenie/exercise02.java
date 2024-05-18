package org.example.zaliczenie;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

// Zadanie 2 - dowolny sposób
public class exercise02 {
    public static void main(String[] args) throws InterruptedException {

// konfiguracja sterownika przeglądarki
        System.setProperty("web-driver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

// uruchom nowe okno przeglądarki
        WebDriver driver = new ChromeDriver();

        try {

// maksymalizuj okno przeglądarki
            driver.manage().window().maximize();

// wejście na stronę logowania
            driver.get("https://mystore-testlab.coderslab.pl./index.php?controller=authentication&back=my-account");

/// logowanie, wpisywanie danych, potwierdzenie przyciskiem
            WebElement emailInput = driver.findElement(By.id("field-email"));
            emailInput.sendKeys("uqohfzlxridiekjavq@cazlv.com");

            WebElement passwordInput = driver.findElement(By.id("field-password"));
            passwordInput.sendKeys("MyStore");

            WebElement signInButton = driver.findElement(By.id("submit-login"));
            signInButton.click();

// wyszukuje produkt, rozwija listę - poczekaj aż załaduje listę (Thread.sleep()
            WebElement searchInCatalog = driver.findElement(By.className("ui-autocomplete-input"));
            searchInCatalog.sendKeys("Hummingbird Printed Sweater");
            Thread.sleep(2000L);

// klika w pierwszy z listy (???)
            WebElement listDropdown = driver.findElement(By.className("product"));
            listDropdown.click();

            /* for (WebElement option : options)
            if (option.getText().contains("Hummingbird printed sweater")) {
            option.click();
            break;
            }}
            */

// wybiera rozmiar M
            WebElement listSize = driver.findElement(By.id("group_1"));
            Select sizeSelect = new Select(listSize);
            sizeSelect.selectByVisibleText("M");
            Thread.sleep(2000L);

// wybiera 5 szt.
            WebElement quantityField = driver.findElement(By.id("quantity_wanted"));
            quantityField.click();
            quantityField.sendKeys(Keys.BACK_SPACE);

            quantityField.sendKeys("5");
            Thread.sleep(2000L);

// dodaje do koszyka
            WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
            addToCartButton.click();
            Thread.sleep(2000L);

// przechodzi do opcji - checkout
            WebElement checkoutListButton1 = driver.findElement(By.className("cart-content-btn"));
            checkoutListButton1.click();

            WebElement checkoutListButton2 = driver.findElement(By.className("btn-primary"));
            checkoutListButton2.click();

// potwierdzi adress
            WebElement addressCheck = driver.findElement(By.name("confirm-addresses"));
            addressCheck.click();

// wybiera metodę odbioru (pick up in store) i zatwierdza wybór
            WebElement shippingMethod = driver.findElement(By.id("delivery_option_6"));
            shippingMethod.click();

            WebElement confirmShipping = driver.findElement(By.name("confirmDeliveryOption"));
            confirmShipping.click();

// wybiera opcję płatności (pay by check), zatwierdza zgody, potwierdza wybór
            WebElement paymentMethod = driver.findElement(By.id("payment-option-1"));
            paymentMethod.click();

            WebElement agreeTermsCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
            agreeTermsCheckbox.click();

            WebElement paymentConfirmation = driver.findElement(By.id("payment-confirmation"));
            WebElement placeOrderButton = paymentConfirmation.findElement(By.className("btn-primary"));
            placeOrderButton.click();

// ??? kliknie na "order with an obligation to pay"

// zrobi screenshot z potwierdzeniem zamówienia i kwotą
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("potwierdzenie_zamówienia.png"));
            System.out.println("SUKCES");

        } catch (Exception e) {
            // Obsłuż wyjątek, jeśli wystąpił
            e.printStackTrace();

        Thread.sleep(3000L);
    } finally {
        driver.quit();
        }
    }
}
// Napisz skrypt, który:
//
//zaloguje się na tego samego użytkownika z zadania 1,
//wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
//wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
//wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
//dodaj produkt do koszyka,
//przejdzie do opcji - checkout,
//potwierdzi address (możesz go dodać wcześniej ręcznie),
//wybierze metodę odbioru - PrestaShop "pick up in store",
//wybierze opcję płatności - Pay by Check,

//kliknie na "order with an obligation to pay",

//zrobi screenshot z potwierdzeniem zamówienia i kwotą.