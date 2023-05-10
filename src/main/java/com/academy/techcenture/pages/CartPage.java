package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr")
    private List<WebElement> productsInCart;
    @FindBy(xpath = "//tr[@id='product-1']/td[@class='cart_price']/p")
    private WebElement firstItemPrimeInCart;
    @FindBy(xpath = "//tr[@id='product-2']/td[@class='cart_price']/p")
    private WebElement secondItemPrimeInCart;
    @FindBy(xpath = "//tr[@id='product-1']/td[@class='cart_quantity']/button")
    private WebElement quantityFirstItem;
    @FindBy(xpath = "//tr[@id='product-2']/td[@class='cart_quantity']/button")
    private WebElement quantitySecondItem;
    @FindBy(xpath = "//tr[@id='product-1']/td[@class='cart_total']/p")
    private WebElement cartTotalFirstItem;
    @FindBy(xpath = "//tr[@id='product-2']/td[@class='cart_total']/p")
    private WebElement cartTotalSecondItem;
    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    private WebElement productQuantity;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement checkoutBtn;
    @FindBy(xpath = "//u[text()='Register / Login']")
    private WebElement registerLoginBtn;
    @FindBy(tagName = "textarea")
    private WebElement commentinput;
    @FindBy(xpath = "//a[text()='Place Order']")
    private WebElement placeOrderBtn;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private WebElement deleteItemFromCartBtn;
    @FindBy(xpath = "//b[text()='Cart is empty!']")
    private WebElement cartEmptyText;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> productInCart;

    public void verifyHowManyProductsInCart(int i){
        Assert.assertTrue("The quility of the items were added are not correct",productsInCart.size()==i);
    }
    public void verifyPricesAreCorrect(){
        Assert.assertTrue("Price didnt match for 1st item", firstItemPrimeInCart.getText().trim().equalsIgnoreCase(ConfigReader.getProperty("price1")));
        Assert.assertTrue("Price didnt match for 1st item", secondItemPrimeInCart.getText().trim().equalsIgnoreCase(ConfigReader.getProperty("price2")));
    }
    public void verifyItemQuantity(){
        Assert.assertTrue("Item quantity of items in the cart is not correct",quantityFirstItem.getText().trim().equalsIgnoreCase("1"));
        Assert.assertTrue("Item quantity of items in the cart is not correct",quantitySecondItem.getText().trim().equalsIgnoreCase("1"));
    }
    public void verifyTotalPrice(){
        String first = firstItemPrimeInCart.getText().trim();
        String second = secondItemPrimeInCart.getText().trim();
        int firstPrice = Integer.parseInt(first.substring(first.length() - 3));
        int secondPrice = Integer.parseInt(second.substring(second.length() - 3));
        int count1 = Integer.parseInt(quantityFirstItem.getText().trim());
        int count2 = Integer.parseInt(quantitySecondItem.getText().trim());
        String cart1 = cartTotalFirstItem.getText().trim();
        String cart2 = cartTotalSecondItem.getText().trim();
        int cartTotal1 = Integer.parseInt(cart1.substring(cart1.length()-3));
        int cartTotal2 = Integer.parseInt(cart2.substring(cart2.length()-3));
        Assert.assertEquals("Total is not correct", cartTotal1, count1 * firstPrice);
        Assert.assertEquals("Total is not correct", cartTotal2, count2 * secondPrice);

    }
    public void verifyProductQuantity(){
        Assert.assertTrue("Product quantity is not correct",productQuantity.getText().trim().equalsIgnoreCase(ConfigReader.getProperty("quantity")));
    }
    public void verifyUserOnCartPage(){
        Assert.assertTrue("user is not on a cart page",driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - Checkout"));
    }
    public void clickOnCheckoutBtn(){
        checkoutBtn.click();
    }
    public void clickOnRegisterLoginBtn(){
        registerLoginBtn.click();
    }
    public void enterComment(){
        commentinput.sendKeys("Please call on delivery ");
    }
    public void clickPlaceOrderBtn(){
        placeOrderBtn.click();
    }
    public void deleteItemFromTheCart(){
        deleteItemFromCartBtn.click();
    }
    public void verifyCartIsEmpty() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Cart is not empty",cartEmptyText.getText().trim().equalsIgnoreCase("Cart is empty!"));

    }
    public void verifyThoseProductsInCartAfterLogIn(){
       // Assert.assertTrue("Products are not in the cart",ConfigReader.getProperty("productSize").equalsIgnoreCase(String.valueOf(productInCart.size())));

        for (int i = 0; i < productInCart.size(); i++) {
            Assert.assertTrue("Products in the cart are not visible",productInCart.get(i).isDisplayed());

        }
    }

}
