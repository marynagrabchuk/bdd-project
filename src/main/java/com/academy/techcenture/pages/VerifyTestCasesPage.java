package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyTestCasesPage extends BasePage{
    public VerifyTestCasesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    private WebElement testCasesText;

    public void verifyUserIsOnTestCasesPage(){
        Assert.assertTrue("user is not in test cases page",testCasesText.isDisplayed());
    }
}
