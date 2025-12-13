package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By privacyPolicyCheckbox = By.name("agree");
    By continueButton = By.xpath("//input[@value='Continue']");
    By errorAlert = By.cssSelector(".alert-danger");
    By successMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");



    public void enterFirstName(String fname) {
        driver.findElement(firstNameField).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastNameField).sendKeys(lname);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }


    public void acceptPrivacyPolicy() {
        driver.findElement(privacyPolicyCheckbox).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorAlert).size() > 0;
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordField).getAttribute("type");
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }
}
