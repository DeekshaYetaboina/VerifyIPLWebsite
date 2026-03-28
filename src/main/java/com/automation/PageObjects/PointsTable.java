package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PointsTable extends AbstractComponents {
   SeleniumUtils seleniumUtils;
    public PointsTable(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }
    By pointsTable=By.cssSelector(IPLPageSelectors.pointsTable);
    By teams = By.cssSelector(IPLPageSelectors.teams);
    By matchesPlayed = By.cssSelector(IPLPageSelectors.matches);
    By points =   By.cssSelector(IPLPageSelectors.points);

    public String getTopTeam() {
        return driver.findElements(teams).getFirst().getText();
    }

    public String getActualMatchesPlayed() {
        return driver.findElements(matchesPlayed).getFirst().getText();

    }

    public String getActualPoints() {

       return driver.findElements(points).getFirst().getText();
    }

    @Override
    public void execute(String header) {
        super.execute(header);
        seleniumUtils.waitForElementToAppear(pointsTable);
            }
}
