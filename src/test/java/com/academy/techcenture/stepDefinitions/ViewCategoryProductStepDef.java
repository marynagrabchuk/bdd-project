package com.academy.techcenture.stepDefinitions;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ViewCategoryProductStepDef {
    private WebDriver driver = Driver.getDriver();
    private HomePage homePage;
    @Given("user lands  on Home Page")
    public void user_lands_on_home_page() {
        homePage = new HomePage(driver);
        homePage.navigate_to_home_page();
        homePage.verifyUserIsOnAHomePage();
    }
    @Given("user Verify that categories are visible on left side bar")
    public void user_verify_that_categories_are_visible_on_left_side_bar() {
        homePage.scrollDown();
        homePage.verifyVisibilityOfCategoryMenu();
    }
    @When("user Click on Women category")
    public void user_click_on_women_category() {
        homePage.clickOnWomenCategory();
    }
    @When("Click on any category link under Women category, for example: Dress")
    public void click_on_any_category_link_under_women_category_for_example_dress() throws InterruptedException {
        homePage.clickOnDressUnderWomen();
        homePage.closeAd();
    }
    @Then("Verify that category page is displayed and confirm text \\(WOMEN - TOPS PRODUCTS)")
    public void verify_that_category_page_is_displayed_and_confirm_text_women_tops_products() {
        homePage.verifyWomenCategoryIsDisplay();
    }
    @When("On left side bar, click on any sub-category link of Men category")
    public void on_left_side_bar_click_on_any_sub_category_link_of_men_category() throws InterruptedException {
        homePage.clickOnMenCategory();
        homePage.clickOnJeanUnderMenCategory();

    }
    @When("Verify that user is navigated to that category page")
    public void verify_that_user_is_navigated_to_that_category_page() {
        homePage.verifyMenCategoryIsDisplay();
    }


}
