package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CartPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchProductVerifyCartAfterLogInStepDef {
    private static final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private LoginPage loginPage;
    private CartPage cartPage;


    @Given("user on a Home page")
    public void user_on_a_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicks  on product button")
    public void user_clicks_on_product_button() throws InterruptedException {
        homePage.clickOnProductBtn();
        homePage.closeAd();
    }
    @When("user Verifies user is navigated to ALL PRODUCTS page successfully")
    public void user_verifies_user_is_navigated_to_all_products_page_successfully() {
        productPage = new ProductPage(driver);
        productPage.verifyUserOnAProductPage();
    }
    @When("user Enters product name in search input and click search button")
    public void user_enters_product_name_in_search_input_and_click_search_button() {
        productPage.searchProduct("dress");

    }
    @When("user Verify SEARCHED PRODUCTS  is visible")
    public void user_verify_searched_products_is_visible() {
        productPage.verifySearchProductsTextIsVisible();
    }
    @Then("user Verifies all the products related to search are visible")
    public void user_verifies_all_the_products_related_to_search_are_visible() throws InterruptedException {
        productPage.verifySearchProductsIsVisibleAndRelatedToSearch("Dress");
    }
    @When("user Add those products to cart")
    public void user_add_those_products_to_cart() throws InterruptedException {
        productPage.addSearchedProductsToCart();
    }
    @Then("Click Cart button and verify that products are visible in cart")
    public void click_cart_button_and_verify_that_products_are_visible_in_cart() {
        homePage.scrollUpToHeader();
        homePage.clickOnCartBtn();
    }
    @Then("Click Signup  Login button and submit login details")
    public void click_signup_login_button_and_submit_login_details() {
        loginPage = new LoginPage(driver);
        homePage.clickOnSingInSignUpBtn();
        loginPage.enterEmailAndPasswordOnLogInLine();
        loginPage.clickLogInBtn();
    }
    @Then("user Again, go to Cart page")
    public void user_again_go_to_cart_page() {
        homePage.clickOnCartBtn();
    }
    @Then("Verify that those products are visible in cart after login as well")
    public void verify_that_those_products_are_visible_in_cart_after_login_as_well() {
        cartPage = new CartPage(driver);
        cartPage.verifyThoseProductsInCartAfterLogIn();
    }


}
