package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Footers_UI extends AbstractComponents {

    public Footers_UI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*='ap-footer']")
    WebElement footer;

    public void goToFooter() {
        waitForElementToAppear(footer);
        scrollToElement(footer);
    }

    @FindBy(css = ".ap-foot-menu")
    List<WebElement> sections;

    @FindBy(css = "div[class=ap-foot-menu] a ")
    List<WebElement> links;

    public List<String> getActualValues() {
        List<String> text = new ArrayList<>();
        waitForElementToAppear(sections.get(0));
        for (WebElement section : sections) {
            String value = section.getText().replaceAll("\n", " ").trim();
            text.add(value);
        }
        return text;
    }
    public Map<String, String> getLinks() {
        String footerPageUrl = driver.getCurrentUrl();
        Map<String, String> info = new HashMap<>();

        List<String> urls = new ArrayList<>();
        waitForElementToAppear(links.get(0));
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                urls.add(href);
            }
        }
        for (String url : urls)
        {
            driver.get(url);
            waitForUrlToLoad(url);
            info.put(url, driver.getCurrentUrl());
            driver.get(footerPageUrl);
            goToFooter();
        }
        return info;
    }
}




