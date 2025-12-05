package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By desktopsLink = By.linkText("Desktops");
    By showAllDesktopsLocator = By.linkText("Show All Desktops");

    By LaptopsLink = By.linkText("Laptops & Notebooks");
    By showAllLaptopsLocator =By.linkText("Show All Laptops & Notebooks");

    By actualTitleLocator = By.xpath("//h3[contains(text(),'Featured')]");
    String expectedTitle = "Featured";

    By myAccountLocator = By.xpath("//span[contains(text(),'My Account')]");
    By loginLocator =By.linkText("Login");

    public void clickOnDesktops(){
        driver.findElement(desktopsLink).click();
    }
    public DesktopsPage clickOnShowAllDesktops(){
        driver.findElement(showAllDesktopsLocator).click();
        return new DesktopsPage(driver);
    }

    public void clickOnLaptops(){
        driver.findElement(LaptopsLink).click();
    }
    public LaptopsPage clickOnShowAllLaptops(){
        driver.findElement(showAllLaptopsLocator).click();
        return new LaptopsPage(driver);
    }

    public String getExpectedTitle(){
        return expectedTitle;
    }
    public String getActualTitle(){
        return driver.findElement(actualTitleLocator).getText();
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLocator).click();
    }
    public LoginPage clickOnLogin(){
        driver.findElement(loginLocator).click();
        return new LoginPage(driver);
    }
}
