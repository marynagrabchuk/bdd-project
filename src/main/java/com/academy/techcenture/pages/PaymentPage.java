package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='name_on_card']")
    private WebElement nameOnCartInput;
    @FindBy(xpath =  "//input[@name='card_number']")
    private WebElement cardNumberInput;
    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement cvcInput;
    @FindBy(xpath = "//input[@name='expiry_month']")
    private WebElement expireMonth;
    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement expireYear;
    @FindBy(id = "submit")
    private WebElement payAndConfirm;
    @FindBy(xpath = "//div[contains(text(),'Your order has been placed successfully!')]")
    private WebElement orderPlacedSuccessMsg;
    @FindBy(xpath = "//b[text()='Order Placed!']")
    private WebElement orderPlaced;


    private void enterCardName(){
        nameOnCartInput.sendKeys(ConfigReader.getProperty("name"));

    }
    private void enterCartNumber(){
        cardNumberInput.sendKeys(ConfigReader.getProperty("card"));
    }
    private void enterCvcCode(){
        cvcInput.sendKeys(ConfigReader.getProperty("cvc"));
    }
    private void enterExpDate(){
        expireMonth.sendKeys(ConfigReader.getProperty("expmonth"));
        expireYear.sendKeys(ConfigReader.getProperty("expyear"));
    }
    public void clickPayAndConfirm(){
        payAndConfirm.click();
    }
    public void fillPaymentInfo(){
        enterCardName();
        enterCartNumber();
        enterCvcCode();
        enterExpDate();
    }

    public void verifySuccessMsg(){
        Assert.assertTrue("Success msg is not visible",orderPlaced.isDisplayed());
    }

}
