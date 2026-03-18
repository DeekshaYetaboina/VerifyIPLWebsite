package com.automation.AbstractComponents;

import org.openqa.selenium.WebDriver;

public class AbstractComponents {
    protected WebDriver driver;


    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }
}
