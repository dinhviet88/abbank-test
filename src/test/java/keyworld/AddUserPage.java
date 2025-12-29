package keyworld;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class AddUserPage {

    WebDriver driver;
    WebDriverWait wait;

    By userRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By status = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By username = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    By password = By.xpath("//label[text()='Password']/../following-sibling::div/input");
    By confirmPassword = By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input");
    By saveBtn = By.xpath("//button[@type='submit']");
    By RoleValue = By.xpath("//div[@role='listbox']//span[text()='Admin']");
    By StatusValue = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    By EmployeeValue = By.xpath("//div[@role='listbox']//span[contains(normalize-space(),'A')]");

    public AddUserPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void createUser(String uname, String pass){

        wait.until(ExpectedConditions.elementToBeClickable(userRole)).click();
        WebElement Adminselect = wait.until(ExpectedConditions.elementToBeClickable(RoleValue));
        Adminselect.click();

        driver.findElement(status).click();
        WebElement Statusselect = wait.until(ExpectedConditions.elementToBeClickable(StatusValue));
        Statusselect.click();

        driver.findElement(employeeName).sendKeys("A");
        WebElement EmployeeName = wait.until(ExpectedConditions.elementToBeClickable(EmployeeValue));
        EmployeeName.click();


        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);

        driver.findElement(saveBtn).click();
    }
}
