package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BibaBrandPage extends BasePage{
    public BibaBrandPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2[text()='Brand - Biba Products']")
    private WebElement bibaBrandText;
    public void verifyBibaPageIsVisible(){
        Assert.assertTrue("Polo brand page is not visible", bibaBrandText.isDisplayed());
    }
}
