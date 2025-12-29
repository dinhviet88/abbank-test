package keyworld;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;

    By adminMenu = By.xpath("//span[text()='Admin']");
    By addButton = By.xpath("//button[.=' Add ']");
    By searchUsername = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    By searchBtn = By.xpath("//button[.=' Search ']");
    By allUser = By.xpath("//h5[text()='System Users']");

    public AdminPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public void clickAdd(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void searchUser(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(allUser));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsername)).sendKeys(username);
        driver.findElement(searchBtn).click();
    }
}

