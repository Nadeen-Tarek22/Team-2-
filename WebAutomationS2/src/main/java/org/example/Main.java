package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)
    public void loginValidUser() {
        System.out.println("==== LOGIN TEST ====");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("input-email")).sendKeys("demo@example.com");
        driver.findElement(By.id("input-password")).sendKeys("demo123");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        String heading = driver.findElement(By.tagName("h2")).getText();
        if (heading.equals("My Account")) {
            System.out.println("Login Successful ✅");
        } else {
            System.out.println("Login Failed ❌: " + heading);
        }
    }

    @Test(priority = 1)
    public void logoutUser() {
        System.out.println("==== LOGOUT TEST ====");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

        String heading = driver.findElement(By.tagName("h2")).getText();
        if (heading.equals("Account Logout")) {
            System.out.println("Logout Successful ✅");
        } else {
            System.out.println("Logout Failed ❌: " + heading);
        }
    }

    @Test(priority = 2)
    public void addProductToWishlist() {
        System.out.println("==== WISHLIST TEST ====");
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac")).click();
        driver.findElement(By.xpath("//a[text()='iMac']/../..//button[@data-original-title='Add to Wish List']")).click();

        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
        if (successMsg.getText().contains("Success: You have added")) {
            System.out.println("Product added to wishlist ✅");
        } else {
            System.out.println("Wishlist addition failed ❌: " + successMsg.getText());
        }
    }

    @Test(priority = 3)
    public void checkoutProduct() {
        System.out.println("==== CHECKOUT TEST ====");
        // Add product to cart first
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac")).click();
        driver.findElement(By.xpath("//a[text()='iMac']/../..//button[@data-original-title='Add to Cart']")).click();

        driver.findElement(By.id("cart")).click();
        driver.findElement(By.linkText("Checkout")).click();

        String checkoutHeading = driver.findElement(By.tagName("h1")).getText();
        if (checkoutHeading.contains("Checkout")) {
            System.out.println("Reached Checkout Page ✅");
        } else {
            System.out.println("Checkout Failed ❌: " + checkoutHeading);
        }
    }

}
