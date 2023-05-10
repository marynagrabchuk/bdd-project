package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginBeforeCheckoutStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private UserInfopage userInfopage;
    private Select select;
    private AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;
    private PaymentPage paymentPage;
    @Given("nav to home page")
    public void nav_to_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicks sign in sihnup button")
    public void user_clicks_sign_in_sihnup_button() {
       homePage.clickOnSingInSignUpBtn();
    }
    @Then("user Fill email, password and click Login button")
    public void user_fill_email_password_and_click_login_button() {
        loginPage = new LoginPage(driver);
       loginPage.enterEmailAndPasswordOnLogInLine();
       loginPage.clickLogInBtn();
    }
    @Then("Verify Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        homePage.verifyLogInAsUser();
    }
    @When("user Adds product to cart")
    public void user_adds_product_to_cart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        homePage.addToCart();


    }
    @When("uer Click Cart button")
    public void uer_click_cart_button() {
        homePage.scrollUpToHeader();
        homePage.clickOnCartBtn();

    }
    @Then("user Verify that cart page is displayed")
    public void user_verify_that_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserOnCartPage();

    }
    @When("user Clicks Proceed To Checkout")
    public void user_clicks_proceed_to_checkout() {
        cartPage.clickOnCheckoutBtn();
    }
    @When("user Verify Address Details and Review Your Order")
    public void user_verify_address_details_and_review_your_order() {

    }
    @Then("Enter description in comment text area and click place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        cartPage.enterComment();
        cartPage.clickPlaceOrderBtn();
    }
    @Then("Enter payment details : Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentInfo();
    }
    @Then("Click Pay and Confirm Order")
    public void click_pay_and_confirm_order() {
        paymentPage.clickPayAndConfirm();
    }
    @Then("user Verify success message {string}")
    public void user_verify_success_message(String string) {
        paymentPage.verifySuccessMsg();
    }


}
