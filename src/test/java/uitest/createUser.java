package uitest;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import keyworld.*;

import java.time.Duration;
import java.util.UUID;

public class createUser {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    AdminPage adminPage;
    AddUserPage addUserPage;

    String newUsername = "Test" + UUID.randomUUID().toString().substring(0,5);

    @Given("open the OrangeHRM login page")
    public void openLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        addUserPage = new AddUserPage(driver);

        loginPage.open();
    }

    @And("login using default credentials")
    public void login() {
        loginPage.login("Admin","admin123");
    }

    @When("navigate to Admin User Management")
    public void goToAdmin() {
        adminPage.openAdmin();
    }

    @And("create a new user with valid information")
    public void createnewUser() {
        adminPage.clickAdd();
        addUserPage.createUser(newUsername,"Abc@123");
    }

    @Then("verify that the user has been created successfully")
    public void verifySuccess() {

        WebElement toast =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@class,'oxd-text--toast-message')]")
                ));

        Assert.assertTrue(toast.getText().contains("Success"));
    }

    @When("search for the newly created user using the username")
    public void searchUser() {
        adminPage.searchUser(newUsername);
    }

    @Then("should see the user listed in the search results")
    public void verifyUserInResults() throws InterruptedException {

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-table-card']//div[contains(text(), '" + newUsername + "')]")
        ));
        String resultUsername = result.getText();
        Assert.assertEquals(resultUsername, newUsername, "the result Username is differences with input UserName ");
        System.out.println("Search validation successful! Actual: " + resultUsername + ", Expected: " + newUsername);
        Assert.assertTrue(result.isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
}