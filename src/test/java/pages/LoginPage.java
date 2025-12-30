package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By errorMsg = By.xpath("//p[contains(@class,'alert-content-text')]");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Action
    public void login(String user, String pass) {

        WebElement userField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(username));
        userField.sendKeys(user);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public String getErrorMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMsg)
        ).getText();
    }

}
