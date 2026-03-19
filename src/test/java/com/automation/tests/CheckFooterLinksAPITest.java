package com.automation.tests;

import com.automation.PageObjects.FootersAPIPage;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class CheckFooterLinksAPITest extends BaseTest {
    FootersAPIPage footersAPIPage;
   @BeforeMethod
   public void initialize(){
        footersAPIPage = new FootersAPIPage(driver);
   }
    @Test
    public void checkFooterLinks() throws URISyntaxException, IOException {
        SoftAssert a = new SoftAssert();
        footersAPIPage.goToFooter();
        Map<String,Integer>  teams = footersAPIPage.checkLinks("div[class=ap-foot-menu]:first-child a ");
        Map<String,Integer>  about = footersAPIPage.checkLinks("div[class=ap-foot-menu]:nth-child(2) a");
        Map<String,Integer>  guidelines = footersAPIPage.checkLinks("div[class=ap-foot-menu]:nth-child(3) a");
        Map<String,Integer> contact = footersAPIPage.checkLinks("div[class=ap-foot-menu]:nth-child(4) a");

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

