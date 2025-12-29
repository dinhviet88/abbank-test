package keyworld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    By username = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[text()=' Login ']");
    By banner = By.xpath("//div[@class='orangehrm-login-branding']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(banner));
    }

    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
