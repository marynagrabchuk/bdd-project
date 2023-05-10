package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductQuintityInCartStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    @Given("user on a Home page and home page is visible")
    public void user_on_a_home_page_and_home_page_is_visible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("user Clicks View Product for any product on home page")
    public void user_clicks_view_product_for_any_product_on_home_page() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        homePage.clickOnViewProduct();
        homePage.closeAd();
    }
    @Given("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.verifyUserIsOnProductDetailsPage();
    }
    @Then("Increase quantity to 4")
    public void increase_quantity_to() {
        productDetailPage.enterQuantity("4");
    }
    @Then("Click Add to cart button")
    public void click_button() {
        productDetailPage.clickAddToCart();
    }
    @Then("user Click View Cart button")
    public void user_click_button() {
        productDetailPage.clickOnViewCart();
    }
    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        cartPage = new CartPage(driver);
        cartPage.verifyProductQuantity();
    }
}
