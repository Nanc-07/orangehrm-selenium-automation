package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployee = By.linkText("Add Employee");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addEmployee(String fName, String lName) {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
    }
}
