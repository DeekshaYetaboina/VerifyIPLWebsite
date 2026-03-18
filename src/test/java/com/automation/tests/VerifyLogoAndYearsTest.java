package com.automation.tests;

import com.automation.PageObjects.LogoAndYearsPage;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class VerifyLogoAndYearsTest extends BaseTest {

    LogoAndYearsPage logoAndYearsPage;

    @BeforeMethod
    public void initialize() {
        logoAndYearsPage = new LogoAndYearsPage(driver);
    }

    @Test
    public void verifyLogos() throws IOException {
        logoAndYearsPage.execute("TEAMS");
        List<String> actualUrls = logoAndYearsPage.logos();
        List<String> expectedUrls = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\data\\ExpectedUrls.json","expectedUrls");
        Assert.assertTrue(actualUrls.equals(expectedUrls),"Expected Logos are Actual Logos differ");
    }

    @Test
    public void verifyYears() throws IOException {
        logoAndYearsPage.execute("TEAMS");
        List<String> actualYears = logoAndYearsPage.getYears();
        List<String> expectedYears = getJsonData("C:\\Projects\\selenium-project\\src\\test\\java\\com\\automation\\data\\ExpectedYears.json","expectedYears");

        Assert.assertEquals(actualYears,expectedYears,"Expected Actual Years differ");
    }
}





