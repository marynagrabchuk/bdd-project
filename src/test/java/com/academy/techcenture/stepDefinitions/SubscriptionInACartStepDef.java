package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SubscriptionInACartStepDef {
    private static final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    @Given("user landing on a home Page")
    public void user_landing_on_a_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user clicks on a cart button")
    public void user_clicks_on_a_cart_button() {

    }
    @When("user Scroll down to footer")
    public void user_scroll_down_to_footer() {

    }
    @When("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {

    }
    @Then("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {

    }
    @Then("Verify success message \\(You have been successfully subscribed!) is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {

    }

}
