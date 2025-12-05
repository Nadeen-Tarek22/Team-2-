package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By myAccountDropdown = By.cssSelector("a[title='My Account']");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void logout() {
        driver.findElement(myAccountDropdown).click();
        driver.findElement(logoutLink).click();
    }

    public boolean isLoggedOut() { return driver.getCurrentUrl().contains("route=account/login"); }
}