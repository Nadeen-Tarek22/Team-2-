package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;



    @Before
    public  void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.opencart.com/");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}