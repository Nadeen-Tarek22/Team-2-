package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By ensuringShoppingPage= By.linkText("Shopping Cart");
    By updateQuantityButton= By.cssSelector("button[aria-label='Update']");
    By removeElementButton= By.cssSelector("button[aria-label='Remove']");
    By enterQuantityFormLocator= By.cssSelector("input[name='quantity']");
    By updatingSuccessMessage= By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By emptyShoppingCartLocator= By.xpath("//p[contains(text(),'empty')]");
    By elementsInCartPage= By.xpath("//td[@class='text-start text-wrap']//a");


   public String getShoppingCartUrl(){
       return driver.findElement(ensuringShoppingPage).getText();
   }

   public String actualShoppingCartUrl(){
      return driver.getCurrentUrl();
   }


    public List<WebElement> checkElementInCart(){

        List<WebElement> cartElements = driver.findElements(elementsInCartPage);
        return cartElements;

    }


}
