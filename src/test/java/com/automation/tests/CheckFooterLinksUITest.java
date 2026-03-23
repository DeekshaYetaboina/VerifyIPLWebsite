package com.automation.tests;


import com.automation.PageObjects.FootersUIPage;
import com.automation.TestUtils.TestDataUtils;
import com.automation.tests.testComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CheckFooterLinksUITest extends BaseTest {
    TestDataUtils testDataUtils = new TestDataUtils();
    FootersUIPage footer;
    @BeforeMethod
    public void initialize(){
        footer = new FootersUIPage(driver);
    }
    @Test
    public void checkFooterLinks() throws IOException {
        SoftAssert a = new SoftAssert();
        footer.goToFooter();
        List<String> actualValues=footer.getActualValues();
        List<String> expectedValues=getJsonData(testDataUtils.getPath("ExpectedFooterData"), "expectedFooterData");
        a.assertTrue(actualValues.equals(expectedValues),"Each section text is not matching expected values");
        Map<String, String> info = footer.getLinks();
        for (Map.Entry<String, String> entry : info.entrySet()) {
            a.assertTrue(entry.getValue().equals(entry.getKey()), "Links are not verified");
        }
        a.assertAll();
}
}
