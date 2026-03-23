package com.automation.AbstractComponents;

import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponents {
    protected WebDriver driver;
    SeleniumUtils seleniumUtils= new SeleniumUtils(driver);


    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }


}
