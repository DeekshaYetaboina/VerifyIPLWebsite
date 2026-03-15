package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LogoAndYears extends AbstractComponents {

    public LogoAndYears(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void execute(String header) {

        driver.findElement(By.cssSelector((".site-menu li a[data-element_text='%s']").replace("%s", header))).click();
    }

     @FindBy(css=".vn-teamsInnerWrp .vn-team-logo img")
    List<WebElement> logos;

    @FindBy(css=".vn-teamsInnerWrp li")
    List<WebElement> cards;

    public List<String> logos() {
        List<String> logoUrls = new ArrayList<>();
        for(WebElement logo : logos) {
            logoUrls.add(logo.getAttribute("src"));
        }
        return logoUrls;
    }



    public List<String> getYears() {
        List<String> years = new ArrayList<>();

        for (WebElement card:cards) {
            moveToElement(card);
            WebElement hover = card.findElement(By.cssSelector(".team-on-hover"));
            String year = hover.getText();
            years.add(year);
        }
        return years;
    }


    }
