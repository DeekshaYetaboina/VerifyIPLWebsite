package com.automation.tests;

import com.automation.PageObjects.SearchResultsPage;
import com.automation.tests.testComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySearchResultsTest extends BaseTest {

        SearchResultsPage searchResultsPage;

        @BeforeMethod
    public void initialize(){
            searchResultsPage=new SearchResultsPage(driver);
        }

        @Test
        public void verifySearchResultsPage() {
            searchResultsPage.execute("NEWS");
            searchResultsPage.navigateToNewsSection("auction 2026");
            searchResultsPage.verifySearchResultsPage();
        }

}
