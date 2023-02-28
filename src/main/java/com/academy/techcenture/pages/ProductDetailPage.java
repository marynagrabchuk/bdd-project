package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/h2/following-sibling::p")
    private WebElement productCategory;
    @FindBy(xpath = "//div[@class='product-information']/span")
    private WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']/p")
    private List<WebElement> productDetails;
    public void verifyUserIsOnProductDetailsPage(){
        Assert.assertTrue("User is not on a product details page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - Product Details"));
    }
    public void verifyProductsDetailsIsVisible(){
        verifyProductDetailsIsVisible();
        verifyProductCategoryIsVisible();
        verifyProductPriceIsVisible();
        verifyProductIsVisible();
    }
    private void verifyProductIsVisible(){
        Assert.assertTrue("Product name is not visible",productName.isDisplayed());
    }
    private void verifyProductCategoryIsVisible(){
        Assert.assertTrue("Product category is not visible",productCategory.isDisplayed());
    }
    private void verifyProductPriceIsVisible(){
        Assert.assertTrue("Product price is not visible",productPrice.isDisplayed());
    }
    private void verifyProductDetailsIsVisible(){
        for (int i = 0; i < productDetails.size(); i++) {
            Assert.assertTrue("Product , condition, brand availability, is not visible",productDetails.get(i).isDisplayed());
        }

    }
}
