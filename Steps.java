package test.java.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.PropertiesFile.PropertiesFile;
import test.java.PageObject.CalculatorPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Steps
{
    public WebDriver driver;
    public static String browserName;
    public static String URL;
    CalculatorPage cp;


    @Given("I Launched browser")
    public void i_launched_browser() throws IOException {
        PropertiesFile.getProperties();
        System.out.println("Browser Name: " +browserName);
        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/test/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            cp = new CalculatorPage(driver);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(URL);
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver_V86.exe");
            driver = new ChromeDriver();
            //cp = new CalculatorPage(driver);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(URL);
        } else {
            System.out.println("Browser does not support");
        }
    }

    @When("I Entered age as {string} select button {string} height as {string} weight as {string} there")
    public void i_entered_age_as_select_button_height_as_weight_as_there(String age, String gender, String height, String weight) {
        cp.setAge(age);
        cp.setGender(gender);
        cp.setHeight(height);
        cp.setWeight(weight);
    }

    @When("I click on Calculate")
    public void i_click_on_calculate() {
        cp.clickOnCalculate();
    }

    @Then("I got result {string}")
    public void i_got_result(String ExpResult) {
        cp.result(ExpResult);
    }

    @Then("Close Browser")
    public void close_browser() {
        driver.quit();
    }

}
