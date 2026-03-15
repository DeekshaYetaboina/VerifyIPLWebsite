package com.automation.tests;

import com.automation.PageObjects.Footers_UI;
import com.automation.tests.testComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckFooterLinks_UI extends BaseTest {
    Footers_UI footer;
    @BeforeMethod
    public void initialize(){
        footer = new Footers_UI(driver);
    }
    @Test
    public void checkFooterLinks() throws IOException {
        SoftAssert a = new SoftAssert();
        footer.goToFooter();
        List<String> actualValues=footer.getActualValues();
        List<String> expectedValues=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\data\\ExpectedFooterData.json","expectedFooterData");
        a.assertTrue(actualValues.equals(expectedValues),"Each section text is not matching expected values");
        Map<String, String> info = footer.getLinks();
        for (Map.Entry<String, String> entry : info.entrySet()) {
            a.assertTrue(entry.getValue().equals(entry.getKey()), "Links are not verified");
        }
        a.assertAll();
}
}
