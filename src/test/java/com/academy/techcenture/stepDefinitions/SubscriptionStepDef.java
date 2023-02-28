package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SubscriptionStepDef {
    private static final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    @Given("user lands on a home Page")
    public void user_lands_on_a_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @When("user scroll down to footer")
    public void user_scroll_down_to_footer() {
        homePage.scrollDownToFooter();
    }
    @When("user verifies text Subscription")
    public void user_verifies_text_subscription() {
        homePage.verifySubscriptionTextVisible();
    }
    @When("user Enter email address in input and click arrow button")
    public void user_enter_email_address_in_input_and_click_arrow_button() throws InterruptedException {
        homePage.enterEmailToSubscribe("aug@gmail.com");
    }
    /**
     * Finish this method . Can Not catch success message.
     */
    @Then("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String string) {

    }

}
