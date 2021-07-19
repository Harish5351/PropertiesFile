package test.java.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CalculatorPage
{
    public WebDriver driver;
    public CalculatorPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cage")
    WebElement Age;

    @FindBy(xpath = "//label[contains(text(),'Male')]")
    WebElement Male;

    @FindBy(xpath = "//label[contains(text(),'Female')]")
    WebElement Female;

    @FindBy(id = "cheightmeter")
    WebElement Height;

    @FindBy(id = "ckg")
    WebElement Weight;

    @FindBy(xpath = "//input[@type='image']")
    WebElement Calculator;

    @FindBy(xpath = "//div[@class='bigtext']")
    WebElement Result;

    public void setAge(String age) {
        Age.clear();
        Age.sendKeys(age);
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            Male.click();
        } else {
            Female.click();
        }
    }
//        for (int i = 0; i < Gender.size(); i++) {
//            WebElement Radio = Gender.get(i);
//            String value = Radio.getAttribute("id");
//            if(value.equals(gender)){
//                Radio.click();
//        }
 //   }



    public void setHeight(String height) {
        Height.clear();
        Height.sendKeys(height);
    }

    public void setWeight(String weight) {
        Weight.clear();
        Weight.sendKeys(weight);
    }

    public void clickOnCalculate() {
        Calculator.click();
    }

    public void result(String ExpResult) {
        String actual_Result = Result.getText();
        System.out.println("Result: " +actual_Result);
        Assert.assertEquals(actual_Result,ExpResult);
//        if (actual_Result.contains("18.5")) {
//            Assert.assertEquals(actual_Result, "BMI = 18.5 kg/m2   (2%, Underweight)");
//        }else if(actual_Result.contains("21.5")) {
//            Assert.assertEquals(actual_Result, "BMI = 21.5 kg/m2   (Normal)");
//        }else if(actual_Result.contains("21.2")){
//            Assert.assertEquals(actual_Result, "BMI = 21.2 kg/m2   (Normal)");
//        }else{
//            Assert.assertEquals(actual_Result, "BMI = 23.1 kg/m2   (Normal)");
//        }
    }
}
