package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
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
}
