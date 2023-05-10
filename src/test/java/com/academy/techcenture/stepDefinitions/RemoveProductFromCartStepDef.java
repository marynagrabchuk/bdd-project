package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveProductFromCartStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private CartPage cartPage;
    private WebDriverWait wait;
    @Given("User Verify that home page is visible successfully")
    public void user_verify_that_home_page_is_visible_successfully() {
       homePage = new HomePage(driver);
       homePage.navigate_to_home_page();
       homePage.verifyUserIsOnAHomePage();
    }
    @When("User Add products to cart")
    public void user_add_products_to_cart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        homePage.addToCart();
        homePage.clickContinueShoppingBtn();
    }
    @Then("User Click Cart Button")
    public void user_click_cart_button() {
        homePage.scrollUpToHeader();
        homePage.clickOnCartBtn();
    }
    @Then("User  Verify that cart page is displayed")
    public void user_verify_that_cart_page_is_displayed() {
      cartPage = new CartPage(driver);
      cartPage.verifyUserOnCartPage();
    }
    @Then("User  Click X button corresponding to particular product")
    public void user_click_x_button_corresponding_to_particular_product() {
        cartPage.deleteItemFromTheCart();
    }
    @Then("User  Verify that product is removed from the cart")
    public void user_verify_that_product_is_removed_from_the_cart() throws InterruptedException {
        wait = new WebDriverWait(driver,15);
        cartPage.verifyCartIsEmpty();
    }

}
