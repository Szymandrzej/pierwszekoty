package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class AddressSteps {

    WebDriver driver;

    @Given("I am logged into the application")
    public void i_am_logged_into_the_application() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement emailInput = driver.findElement(By.id("field-email"));
        emailInput.sendKeys("uqohfzlxridiekjavq@cazlv.com");

        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys("MyStore");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @When("I navigate to the new address form")
    public void i_navigate_to_the_new_address_form() throws InterruptedException {
        WebElement addressButton = driver.findElement(By.className("link-item"));
        addressButton.click();
        Thread.sleep(3000L);

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        Thread.sleep(3000L);

        WebElement createNewAddressButton = driver.findElement(By.xpath("//div[@class='addresses-footer']/a[@data-link-action='add-address']"));
        createNewAddressButton.click();
        Thread.sleep(3000L);
    }

    @When("I fill the form with the following data")
    public void i_fill_the_form_with_the_following_data(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            driver.findElement(By.id("field-alias")).sendKeys(row.get("alias"));
            driver.findElement(By.id("field-address1")).sendKeys(row.get("address"));
            driver.findElement(By.id("field-city")).sendKeys(row.get("city"));
            driver.findElement(By.id("field-postcode")).sendKeys(row.get("postalCode"));
            driver.findElement(By.id("field-id_country")).sendKeys(row.get("country"));
            driver.findElement(By.id("field-phone")).sendKeys(row.get("phone"));

            WebElement saveButton = driver.findElement(By.className("form-control-submit"));
            saveButton.click();
        }
    }
}
