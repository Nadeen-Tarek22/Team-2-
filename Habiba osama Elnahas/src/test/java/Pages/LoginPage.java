package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // WebElement usernameTextbox = driver.findElement(By.id("username"));
    By usernameTextBoxLocator = By.id("username");

    // WebElement passwordTextbox = driver.findElement(By.id("password"));
    By PasswordTextBoxLocator = By.id("password");

    // WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    By loginButtonLocator = By.xpath(("//i[contains(text(),'Login')]"));

    public void setUsername(String username) {
        driver.findElement(usernameTextBoxLocator).sendKeys("tomsmith");
    }

    public void setPassword(String password) {
        driver.findElement(PasswordTextBoxLocator).sendKeys("SuperSecretPassword!");
    }




    public void open() {
    }

    public void login(String mail, String demo) {
    }

    public boolean isLoggedIn() {
        return false;
    }
}