package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterUtilities {
    WebDriver driver;

    public FooterUtilities(WebDriver driver) {
        this.driver = driver;
    }

    By termsAndConditionLocator = By.linkText("Terms & Conditions");
    By deliveryInfoLinkLocator = By.linkText("Delivery Information");
    By aboutUsPageLinkLocator = By.linkText("About Us");
    By privacyPolicyPageLinkLocator = By.linkText("Privacy Policy");
    By contactUsPageLinkLocator= By.linkText("Contact Us");

    public void clickOnTermsAndConditions(){
        driver.findElement(termsAndConditionLocator).click();
    }

    public void clickOnDelivery(){
        driver.findElement(deliveryInfoLinkLocator).click();
    }

    public void clickOnAboutUsPage(){
        driver.findElement(aboutUsPageLinkLocator).click();
    }

    public void clickOnPrivacyPage(){
        driver.findElement(privacyPolicyPageLinkLocator).click();
    }

    public void clickOnContactPage(){
        driver.findElement(contactUsPageLinkLocator).click();
    }






}
