package com.automation.AbstractComponents;

import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AbstractComponents {
    protected WebDriver driver;



    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }

    public void execute(String header) {
        driver.findElement(By.cssSelector((IPLPageSelectors.headers).replace("%s", header))).click();

    }

}
