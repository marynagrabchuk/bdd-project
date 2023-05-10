package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoloBrandPage extends BasePage{
    public PoloBrandPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[text()='Brand - Polo Products']")
    private WebElement poloBrandText;
    public void verifyPoloPageIsVisible(){
        Assert.assertTrue("Polo brand page is not visible", poloBrandText.isDisplayed());
    }
}
