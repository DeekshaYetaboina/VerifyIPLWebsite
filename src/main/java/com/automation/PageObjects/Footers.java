package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class Footers extends AbstractComponents {
    WebDriver driver;
    Actions action;

    public Footers(WebDriver driver) {
        super(driver);
        this.driver=driver;
        this.action =new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div[class*='ap-footer']")
    WebElement footer;

    public void goToFooter(){
        action.scrollToElement(footer).perform();
    }

    public Map<String,Integer> checkLinks(String cssSelector) throws URISyntaxException, IOException {
         Map<String,Integer> linkinfo = new HashMap<>();
         List<WebElement> links = driver.findElements(By.cssSelector(cssSelector));

        for(WebElement link :links){
            String name = link.getText();
            String url =link.getAttribute("href");
            HttpURLConnection u = (HttpURLConnection) new URI(url).toURL().openConnection();
            u.setRequestMethod("HEAD");
            u.setRequestProperty("User-Agent", "Chrome/120.0.0.0 ");
            u.connect();
           int response = u.getResponseCode();
           linkinfo.put(name,response);
        }
        return linkinfo;
    }
    }





