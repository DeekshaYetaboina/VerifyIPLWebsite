package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.IPLPageSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PointsTable extends AbstractComponents {

    public PointsTable(WebDriver driver) {
        super(driver);
    }

    By teams = By.cssSelector(IPLPageSelectors.teams);
    By scores = By.cssSelector(IPLPageSelectors.scores);
    public String getTopTeam() {
        return driver.findElements(teams).get(0).getText();
    }

    public String getActualMatchesPlayed() {
        return driver.findElements(scores).get(0).getText();
    }

    public String getActualPoints() {

       return driver.findElements(scores).get(8).getText();
    }

    @Override
    public void execute(String header) {
        super.execute(header);
            }
}
