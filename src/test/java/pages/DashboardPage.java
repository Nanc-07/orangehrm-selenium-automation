package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    By profileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By logoutBtn = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
        Thread.sleep(3000); // 3 seconds

    }
}
