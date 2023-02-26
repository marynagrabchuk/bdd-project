package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[contains(text(),'Touch')]")
    private WebElement getInTouchText;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(tagName = "textarea")
    private WebElement messageInput;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUploadBtn;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMsgText;
    @FindBy(xpath = "//span[text()=' Home']/i")
    private WebElement homeBtn;

    public void VerifyGetInTouchMSG(){
        Assert.assertTrue("Get in touch msg is not visible",getInTouchText.isDisplayed());
    }
    public void enterName(String str){
        nameInput.sendKeys(str);
    }
    public void enterEmail(String str){
        emailInput.sendKeys(str);
    }
    public void enterMsg(String str){
        messageInput.sendKeys(str);
    }
    public void uploadFile(String str){

        fileUploadBtn.sendKeys(str);
    }
    public void clickOnSubmitBtn(){
        submitBtn.click();
    }
    public void verifySuccessMsgIsDisplayed(){
        Assert.assertTrue("Success msg is not displayed",successMsgText.isDisplayed());
    }
    public void clickOnHomeBtn(){
        homeBtn.click();
    }
}
