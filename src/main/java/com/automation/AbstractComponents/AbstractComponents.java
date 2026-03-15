package com.automation.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
   protected WebDriver driver;


    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElementToAppear(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         wait.until(ExpectedConditions.visibilityOf(element));
    }



    public void scrollToElement(WebElement element) {

        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();

    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void waitForUrlToLoad(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }



}
