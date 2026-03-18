package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Footers_UI_Page extends AbstractComponents {

    SeleniumUtils seleniumUtils =  new SeleniumUtils(driver);

    public Footers_UI_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By footer = By.cssSelector(IPLPageSelectors.footerSection);
    By menuSections =By.cssSelector(IPLPageSelectors.footerMenuSections);
    By footerLinks =By.cssSelector(IPLPageSelectors.footerLinks);

    public void goToFooter() {
        seleniumUtils.waitForElementToAppear(footer);
        seleniumUtils.scrollToElement(footer);
    }
    public List<String> getActualValues() {
        List<String> text = new ArrayList<>();
        List<WebElement> sections =driver.findElements(menuSections);
        seleniumUtils.waitForElementToAppear(sections.get(0));
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
        List<WebElement> links = driver.findElements(footerLinks);
        seleniumUtils.waitForElementToAppear(links.get(0));
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                urls.add(href);
            }
        }
        for (String url : urls)
        {
            driver.get(url);
            seleniumUtils.waitForUrlToLoad(url);
            info.put(url, driver.getCurrentUrl());
            driver.get(footerPageUrl);
            goToFooter();
        }
        return info;
    }
}




