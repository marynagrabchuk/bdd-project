package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddProductToTheCart {
    private static final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    @Given("user on a Home Page and home page is visible")
    public void user_on_a_home_page_and_home_page_is_visible() {
       homePage = new HomePage(driver);
       homePage.navigate_to_home_page();
       homePage.verifyUserIsOnAHomePage();
    }
    @When("Click Products button")
    public void click_products_button() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }
    @When("user Hover over first product and click \\(Add to cart)")
    public void user_hover_over_first_product_and_click_add_to_cart() {
        productPage = new ProductPage(driver);
        productPage.savePriceData();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        productPage.hoverOverFistItem();
        productPage.addFirstItemToTeCart();
    }
    @Then("Click \\(Continue Shopping) button")
    public void click_continue_shopping_button() {
        productPage.clickContinueShoppingBtn();
    }
    @Then("user Hover over second product and click \\(Add to cart)")
    public void user_hover_over_second_product_and_click_add_to_cart() {
        productPage.addSecondItemToTeCart();
    }
    @Then("user Click \\(View Cart) button")
    public void user_click_view_cart_button() {
        productPage.clickViewCart();
    }
    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        cartPage = new CartPage(driver);
        cartPage.verifyHowManyProductsInCart(2);
    }
    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        cartPage.verifyTotalPrice();
    }

}
