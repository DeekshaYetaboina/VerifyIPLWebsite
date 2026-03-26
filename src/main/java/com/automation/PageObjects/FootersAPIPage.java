package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class FootersAPIPage extends AbstractComponents {
    SeleniumUtils seleniumUtils;
    public FootersAPIPage(WebDriver driver) {
        super(driver);

         seleniumUtils = new SeleniumUtils(driver);
    }
    By footer= By.cssSelector(IPLPageSelectors.footerSection);


    public void goToFooter(){
        seleniumUtils.scrollToElement(footer);
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





