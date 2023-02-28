package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div/following-sibling::div)[1]/div/div/following-sibling::div/ul/li/a")
    private WebElement firstProduct;

    public void verifyUserOnAProductPage(){
        Assert.assertTrue("User is not on a product page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - All Products"));
    }
    public void verifyAllProductsIsVisible(){
        Assert.assertTrue("Products Are not visible",allProducts.isDisplayed());
    }
    public void clickOnFirstProduct(){
        firstProduct.click();
    }
}
