package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div/following-sibling::div)[1]/div/div/following-sibling::div/ul/li/a/i")
    private WebElement firstProduct;
    @FindBy(id = "search_product")
    private WebElement searchProductInput;
    @FindBy(id = "submit_search")
    private WebElement submitSearchBtn;
    @FindBy(xpath = "//p[contains(text(),'Top')]")
    private List<WebElement> searchedProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div)[1]")
    private WebElement firstItem;
    @FindBy(xpath = "//a[@data-product-id='1' and text()='Add to cart']/i")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//a[@data-product-id='2' and text()='Add to cart']/i")
    private WebElement addToCarSecondItemBtn;
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//a/u[text()='View Cart']")
    private WebElement viewCartBtn;
    @FindBy(xpath = "//a[@data-product-id='1']/../h2")
    private WebElement firstItemPrice;
    @FindBy(xpath = "//a[@data-product-id='2']/../h2")
    private WebElement secondItemPrice;



    public void verifyUserOnAProductPage(){
        Assert.assertTrue("User is not on a product page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - All Products"));
    }
    public void verifyAllProductsIsVisible(){
        Assert.assertTrue("Products Are not visible",allProducts.isDisplayed());
    }
    public void clickOnFirstProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        firstProduct.click();
    }
    public void searchProduct(String str){
        searchProductInput.sendKeys(str);
        submitSearchBtn.click();
    }
    public void verifyVisibilitySearchedProducts(String str){
        List<WebElement> products = driver.findElements(By.xpath("//p[contains(text(),'"+str+"')]/../../../../.."));
        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue("Product"+products.get(i)+"is not visible",products.get(i).isDisplayed());

        }
    }
    public void hoverOverFistItem(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem);
    }
    public void addFirstItemToTeCart(){
        addToCartBtn.click();
    }
    public void addSecondItemToTeCart(){
        addToCarSecondItemBtn.click();
    }
    public void clickContinueShoppingBtn(){
        continueShoppingBtn.click();
    }
    public void clickViewCart(){
        viewCartBtn.click();
    }
    public void savePriceData(){
        String price1 = firstItemPrice.getText().trim();
        ConfigReader.setProperty("price1",price1);
        String price2 = secondItemPrice.getText().trim();
        ConfigReader.setProperty("price2", price2);

    }


}
