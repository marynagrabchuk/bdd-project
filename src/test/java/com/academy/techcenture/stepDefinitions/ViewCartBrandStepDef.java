package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.BibaBrandPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.PoloBrandPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ViewCartBrandStepDef {
    private final WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    private PoloBrandPage poloBrandPage;
    private BibaBrandPage bibaBrandPage;
    @Given("user lands on Home Page")
    public void user_lands_on_home_page() {
       homePage = new HomePage(driver);
       homePage.navigate_to_home_page();
       homePage.verifyUserIsOnAHomePage();
    }
    @When("user Click on the Products button")
    public void user_click_on_button() throws InterruptedException {
       homePage.clickOnProductBtn();
       homePage.closeAd();
    }
    @When("user Verify that Brands are visible on left side bar")
    public void user_verify_that_brands_are_visible_on_left_side_bar() {
        homePage.scrollDown();
        homePage.scrollDown();
        homePage.verifyBrandsAreVisible();
    }
    @When("user Click on any brand name")
    public void user_click_on_any_brand_name() {
        homePage.clickOnPoloBrand();
    }
    @When("Verify that user is navigated to brand page and brand products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
        poloBrandPage = new PoloBrandPage(driver);
        poloBrandPage.verifyPoloPageIsVisible();
    }
    @Then("On left side bar, click on any other brand link")
    public void on_left_side_bar_click_on_any_other_brand_link() {
        homePage.scrollDown();
        homePage.clickOnBibaBrand();
    }
    @Then("Verify that user is navigated to that brand page and can see products")
    public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
        bibaBrandPage = new BibaBrandPage(driver);
        bibaBrandPage.verifyBibaPageIsVisible();
    }
}
