package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphonePage {
    WebDriver driver;


    By iphoneQuantityLocator= By.id("input-quantity");
    By iphoneAddToCartButtonLocator= By.xpath("//button[@class='btn btn-primary btn-lg btn-block']");
    By generalAddToCartButton= By.xpath("//button[@class='btn btn-lg btn-inverse btn-block dropdown-toggle']");
    // after clicking add to cart and expire in about 7 seconds
    By alertLocator= By.xpath("//div[@class='alert alert-success alert-dismissible']");
    String alertMessage= "Success: You have added iPhone to your shopping cart!";
    By goToCartButton= By.linkText("View Cart");

    public IphonePage(WebDriver driver) {
        this.driver = driver;
    }



    public String getActualTextOfAlert(){
        return driver.findElement(alertLocator).getText();
    }

    public String getExpectedTextOfAlert(){
        return alertMessage;
    }


    public void addToCart(){
        driver.findElement(iphoneAddToCartButtonLocator).click();
    }

    public void enterQuantity(){
        driver.findElement(iphoneQuantityLocator).sendKeys("2");
    }

    public ShoppingCartPage clickOnGeneralButtonOfCart(){
        driver.findElement(generalAddToCartButton).click();
        driver.findElement(goToCartButton).click();
        return new ShoppingCartPage(driver);
    }


}
