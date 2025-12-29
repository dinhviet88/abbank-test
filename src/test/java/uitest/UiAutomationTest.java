package uitest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.UUID;



public class UiAutomationTest  {
    public static void main(String[] args)  throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        String newUsername = "Test" + UUID.randomUUID().toString().substring(0,5);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']")));
        chromeDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        chromeDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        chromeDriver.findElement(By.xpath("//button[text()=' Login ']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
        System.out.println("well come a Dashboard");
        chromeDriver.findElement(By.xpath("//span[text()='Admin']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']")));
        chromeDriver.findElement(By.xpath("//button[text()=' Add ']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-select-text-input'])[1]"))).click();
        WebElement Adminselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Admin']")));
        Adminselect.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-select-text-input'])[2]"))).click();
        WebElement Statusselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Enabled']")));
        Statusselect.click();
        chromeDriver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
        WebElement EmployeeName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//span[text()='Arisha   Haque']")));
        EmployeeName.click();
        chromeDriver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys(newUsername);
        chromeDriver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input")).sendKeys("Abc@123");
        chromeDriver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input")).sendKeys("Abc@123");

        chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='System Users']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Search ']")));
        chromeDriver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys(newUsername);
        chromeDriver.findElement(By.xpath("//button[text()=' Search ']")).click();
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-table-card']//div[contains(text(), '" + newUsername + "')]")
        ));
        String resultUsername = result.getText();
        Assert.assertEquals(resultUsername, newUsername, "the result Username is diffirences with input UserName ");
        System.out.println("Search validation successful! Actual: " + resultUsername + ", Expected: " + newUsername);


      //  chromeDriver.quit();

    }
}
