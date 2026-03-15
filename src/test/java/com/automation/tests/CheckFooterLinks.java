package com.automation.tests;

import com.automation.PageObjects.Footers;
import com.automation.tests.testComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class CheckFooterLinks extends BaseTest {
    Footers footers;
   @BeforeMethod
   public void initialize(){
        footers = new Footers(driver);
   }
    @Test
    public void checkFooterLinks() throws URISyntaxException, IOException {
        SoftAssert a = new SoftAssert();
        footers.goToFooter();
        Map<String,Integer>  teams = footers.checkLinks("div[class=ap-foot-menu]:first-child a ");
        Map<String,Integer>  about = footers.checkLinks("div[class=ap-foot-menu]:nth-child(2) a");
        Map<String,Integer>  guidelines =footers.checkLinks("div[class=ap-foot-menu]:nth-child(3) a");
        Map<String,Integer> contact =footers.checkLinks("div[class=ap-foot-menu]:nth-child(4) a");

       for(Map.Entry<String,Integer> entry : teams.entrySet()) {
            Assert.assertEquals(entry.getValue(),200);
        }
        for(Map.Entry<String,Integer> entry : about.entrySet()) {
            Assert.assertEquals(entry.getValue(),200);
        }
        for(Map.Entry<String,Integer> entry : guidelines.entrySet()) {
            Assert.assertEquals(entry.getValue(),200);
        }
        for(Map.Entry<String,Integer> entry : contact.entrySet()) {
            Assert.assertEquals(entry.getValue(),200);
        }
    }
}

