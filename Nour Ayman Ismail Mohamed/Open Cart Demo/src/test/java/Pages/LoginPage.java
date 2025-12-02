package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By emailLocator = By.xpath("//input[@id='input-email']");
    By passwordLocator = By.xpath("//input[@id='input-password']");
    By titleLocator = By.xpath("//h2[contains(text(),'Returning Customer')]");
    String expectedTitle = "Returning Customer";
    By loginButtonLocator = By.xpath("//button[contains(text(),'Login')]");

    public String getActualTitle(){
        return driver.findElement(titleLocator).getText();
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
    public void setEmail(){
        driver.findElement(emailLocator).sendKeys("nourgabala28@gmail.com");
    }
    public void setPassword(){
        driver.findElement(passwordLocator).sendKeys("123456");
    }
    public MyAccountPage clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
        return new MyAccountPage(driver);
    }
}
