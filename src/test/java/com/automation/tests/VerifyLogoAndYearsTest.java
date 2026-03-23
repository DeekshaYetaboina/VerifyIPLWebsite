package com.automation.tests;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.PageObjects.LogoAndYearsPage;
import com.automation.TestUtils.TestDataUtils;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class VerifyLogoAndYearsTest extends BaseTest {

    TestDataUtils testDataUtils = new TestDataUtils();
    LogoAndYearsPage logoAndYearsPage;

    @BeforeMethod
    public void initialize() {
        logoAndYearsPage = new LogoAndYearsPage(driver);
    }

    @Test
    public void verifyLogos() throws IOException {
        logoAndYearsPage.execute("TEAMS");
        List<String> actualUrls = logoAndYearsPage.logos();
        List<String> expectedUrls = getJsonData(testDataUtils.getPath("ExpectedUrls"), "expectedUrls");
        Assert.assertTrue(actualUrls.equals(expectedUrls),"Expected Logos are Actual Logos differ");
    }

    @Test
    public void verifyYears() throws IOException {
        logoAndYearsPage.execute("TEAMS");
        List<String> actualYears = logoAndYearsPage.getYears();
        List<String> expectedYears = getJsonData(testDataUtils.getPath("ExpectedYears"), "expectedYears");

        Assert.assertEquals(actualYears,expectedYears,"Expected Actual Years differ");
    }
}





