package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver  = driver;
        PageFactory.initElements(driver,this);
    }

    public  void navigate_to_home_page(){
        driver.get(ConfigReader.getProperty("url"));
    }


}
