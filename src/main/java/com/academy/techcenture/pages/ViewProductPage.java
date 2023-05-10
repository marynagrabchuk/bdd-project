package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProductPage extends BasePage{
    public ViewProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//a[text()='Write Your Review']")
    private WebElement writeReviewText;
    @FindBy(xpath = "//textarea[@name='review']")
    private WebElement reviewInput;
    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement submitReviewBtn;
    @FindBy(xpath = "//span[text()='Thank you for your review.']")
    private WebElement successMsg;
    public void enterNameAndEmailForReview(){
        nameInput.sendKeys("kevin");
        emailInput.sendKeys(ConfigReader.getProperty("email1"));
    }
    public void verifyWriteReviewTextIsVisible(){
        Assert.assertTrue("Write review text is not visible", writeReviewText.isDisplayed());
    }
    public void writeReview(){
        reviewInput.sendKeys("Size is running large");
    }
    public void clickSubmitBtnForReview(){
        submitReviewBtn.click();
    }
    public void verifySucessMsg(){
        Assert.assertTrue("Thank you for your review text is not displayed",successMsg.isDisplayed());
    }
}
