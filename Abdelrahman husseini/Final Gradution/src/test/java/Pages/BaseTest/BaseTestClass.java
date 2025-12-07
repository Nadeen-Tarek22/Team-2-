package Pages.BaseTest;

import Pages.Account.LoginPage;
import Pages.Account.RegisterPage;
import Pages.HomePage;
import Pages.PhonesIPDAsPage;
import Pages.SoftwarePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected HomePage homePage;
    protected SoftwarePage softwarePage;
    protected PhonesIPDAsPage phonesIPDAsPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/");

        homePage = new HomePage(driver, wait);
    }

    @After
    public void teardown() {

            driver.quit();

    }
}
