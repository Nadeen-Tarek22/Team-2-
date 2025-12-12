package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    By tabletsLink = By.linkText("Tablets");
    By showAllTabletsLocator = By.linkText("Show All Tablets");


    By componentsLink = By.linkText("Components");
    By showAllComponentsLocator = By.linkText("Show All Components");


    By myAccountLocator = By.xpath("//span[contains(text(),'My Account')]");
    By registerLocator = By.linkText("Register");

    By actualTitleLocator = By.xpath("//h3[contains(text(),'Featured')]");
    String expectedTitle = "Featured";

    public void clickOnTablets() {
        driver.findElement(tabletsLink).click();
    }

    public TabletsPage clickOnShowAllTablets() {
        driver.findElement(showAllTabletsLocator).click();
        return new TabletsPage(driver);
    }


    public void clickOnComponents() {
        driver.findElement(componentsLink).click();
    }

    public ComponentsPage clickOnShowAllComponents() {
        driver.findElement(showAllComponentsLocator).click();
        return new ComponentsPage(driver);
    }

    public void clickOnMyAccount() {
        driver.findElement(myAccountLocator).click();
    }

    public RegisterPage clickOnRegister() {
        driver.findElement(registerLocator).click();
        return new RegisterPage(driver);
    }


    public String getExpectedTitle() {
        return expectedTitle;
    }

    public String getActualTitle() {
        return driver.findElement(actualTitleLocator).getText();
    }
}
