package com.automation.tests;

import com.automation.PageObjects.LogoAndYears;
import com.automation.tests.testComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyLogoAndYears extends BaseTest {

    LogoAndYears logoAndYears;

    @BeforeMethod
    public void initialize() {
        logoAndYears = new LogoAndYears(driver);
    }

    @Test
    public void verifyLogos() throws IOException {
        logoAndYears.execute("TEAMS");
        List<String> actualUrls = logoAndYears.logos();
        List<String> expectedUrls = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\data\\ExpectedUrls.json","expectedUrls");
        Assert.assertTrue(actualUrls.equals(expectedUrls),"Expected Logos are Actual Logos differ");
    }

    @Test
    public void verifyYears() throws IOException {
        logoAndYears.execute("TEAMS");
        List<String> actualYears = logoAndYears.getYears();
        List<String> expectedYears = getJsonData("C:\\Projects\\selenium-project\\src\\test\\java\\com\\automation\\data\\ExpectedYears.json","expectedYears");

        Assert.assertEquals(actualYears,expectedYears,"Expected Actual Years differ");
    }
}





