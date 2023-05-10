package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import com.academy.techcenture.pages.ViewProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddReviewForProductStepDef {
    private static WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private ProductPage productPage;
    private ViewProductPage viewProductPage;
    @Given("user on the home page")
    public void user_on_the_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicking on product button")
    public void user_clicking_on_product_button() throws InterruptedException {
       homePage.clickOnProductBtn();
       homePage.closeAd();
    }
    @When("user Verifies  user is navigated to ALL PRODUCTS page successfully")
    public void user_verifies_user_is_navigated_to_all_products_page_successfully() {
        productPage = new ProductPage(driver);
        productPage.verifyUserOnAProductPage();
    }
    @Then("Click on View Product button")
    public void click_on_view_product_button() {
        homePage.scrollDown();
        homePage.clickOnViewProduct();
    }
    @Then("user Verify Write Your Review is visible")
    public void user_verify_write_your_review_is_visible() {
        viewProductPage = new ViewProductPage(driver);
        viewProductPage.verifyWriteReviewTextIsVisible();
    }
    @Then("user Enter name, email and review")
    public void user_enter_name_email_and_review() {

        viewProductPage.enterNameAndEmailForReview();
        viewProductPage.writeReview();
    }
    @Then("user Click Submit button")
    public void user_click_submit_button() {
        viewProductPage.clickSubmitBtnForReview();

    }
    @Then("Verify success message Thank you for your review.")
    public void verify_success_message_thank_you_for_your_review() {
        viewProductPage.verifySucessMsg();
    }

}
