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
        String path = testDataUtils.getPath("ExpectedUrls");
        List<String> expectedUrls = getJsonData(path, "expectedUrls");
        String header = testDataUtils.getJsonString(path,"header");
        logoAndYearsPage.execute(header);
        List<String> actualUrls = logoAndYearsPage.logos();
        Assert.assertTrue(actualUrls.equals(expectedUrls),"Expected Logos are Actual Logos differ");
    }

    @Test
    public void verifyYears() throws IOException {
        String path=testDataUtils.getPath("ExpectedYears");
        String header = testDataUtils.getJsonString(path,"header");
        logoAndYearsPage.execute(header);
        List<String> actualYears = logoAndYearsPage.getYears();
        List<String> expectedYears = getJsonData(path, "expectedYears");
        Assert.assertEquals(actualYears,expectedYears,"Expected Actual Years differ");
    }
}





