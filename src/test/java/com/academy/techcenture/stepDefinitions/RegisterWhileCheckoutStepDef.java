package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class RegisterWhileCheckoutStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private Select select;
    private UserInfopage userInfopage;
    private AccountCreatedSuccessfullyPage accountCreatedSuccessfullyPage;
    private PaymentPage paymentPage;

    @Given("on a Home page and home page is visible")
    public void on_a_home_page_and_home_page_is_visible() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("Add products to cart")
    public void add_products_to_cart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        homePage.addToCart();
        homePage.clickContinueShoppingBtn();
    }
    @When("user Click Cart button")
    public void user_click_cart_button() throws InterruptedException {
        homePage.scrollUpToHeader();
        homePage.clickOnCartBtn();
       // homePage.closeAd();
    }
    @When("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        cartPage = new CartPage(driver);
        cartPage.verifyUserOnCartPage();
    }
    @Then("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        cartPage.clickOnCheckoutBtn();
    }
    @Then("user Click Register Login button")
    public void user_click_register_login_button() {
        cartPage.clickOnRegisterLoginBtn();
    }
    @Then("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account(List<Map<String,String>> data) throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.enterNameAndEmail();
        loginPage.clickSignInBtn();
        Map<String, String> userInfo =data.get(0);
        String password = userInfo.get("Password").trim();
        String title = userInfo.get("Title");
        String date = userInfo.get("Date").trim();
        String month = userInfo.get("Month").trim();
        String year = userInfo.get("Year");
        driver.findElement(By.xpath("//label[text()='Title']/following-sibling::div/label/div/span/input[@value='"+title+"']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement days = driver.findElement(By.id("days"));
        select = new Select(days);
        select.selectByVisibleText(date);
        WebElement months = driver.findElement(By.id("months"));
        select = new Select(months);
        select.selectByVisibleText(month);
        WebElement years = driver.findElement(By.id("years"));
        select = new Select(years);
        select.selectByValue(year);
        String first_name = userInfo.get("First name");
        String last_name = userInfo.get("Last name");
        String company = userInfo.get("Company");
        String address = userInfo.get("Address");
        String country = userInfo.get("Country");
        String state = userInfo.get("State");
        String city = userInfo.get("City");
        String zipcode = userInfo.get("Zipcode");
        String mobile = userInfo.get("Mobile");
        driver.findElement(By.id("first_name")).sendKeys(first_name);
        driver.findElement(By.id("last_name")).sendKeys(last_name);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address);
        WebElement country1 = driver.findElement(By.id("country"));
        select = new Select(country1);
        select.selectByValue(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
        Thread.sleep(3000);
        userInfopage = new UserInfopage(driver);
        userInfopage.clickOnCreateAccountBtn();

    }
    @Then("user Verify ACCOUNT CREATED! and click Continue button")
    public void user_verify_account_created_and_click_continue_button() throws InterruptedException {
        accountCreatedSuccessfullyPage = new AccountCreatedSuccessfullyPage(driver);
        accountCreatedSuccessfullyPage.verifyNavigatedToAccountCreatedSuccessfullyPage();
        accountCreatedSuccessfullyPage.clickOnContinueBtn();
        //homePage.closeAd();

    }
    @Then("Verify  Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        homePage.verifyLogInAsUser();
    }
    @Then("Click Proceed To Checkout button")
    public void click_proceed_to_checkout_button() {
        homePage.clickOnCartBtn();
        cartPage.clickOnCheckoutBtn();
    }
    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {

    }
    @Then("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
        cartPage.enterComment();
        cartPage.clickPlaceOrderBtn();
    }
    @Then("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentInfo();
    }
    @Then("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        paymentPage.clickPayAndConfirm();
    }
    @Then("Verify success message Your order has been placed successfully!")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        paymentPage.verifySuccessMsg();
    }


}
