package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.SeleniumUtils.SeleniumUtils;
import com.automation.IPLPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class LogoAndYearsPage extends AbstractComponents {
     SeleniumUtils seleniumUtils;

    public LogoAndYearsPage(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);

    }

    @Override
    public void execute(String header) {
        super.execute(header);
    }

    By teamLogo = By.cssSelector(IPLPageSelectors.teamLogo);
    By teamCards = By.cssSelector(IPLPageSelectors.teamCards);



    public List<String> logos() {
        List<String> logoUrls = new ArrayList<>();
        List<WebElement> logos = driver.findElements(teamLogo);
        for(WebElement logo : logos) {
            logoUrls.add(logo.getAttribute("src"));
        }
        return logoUrls;
    }

    public List<String> getYears() {
        List<String> years = new ArrayList<>();
        List<WebElement> cards = driver.findElements(teamCards);

        for (WebElement card:cards) {
            seleniumUtils.moveToElement(card);
            WebElement hover = card.findElement(By.cssSelector(IPLPageSelectors.teamWinningYears));
            String year = hover.getText();
            years.add(year);
        }
        return years;
    }


    }