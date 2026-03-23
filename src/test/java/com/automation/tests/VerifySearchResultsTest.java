package com.automation.tests;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.PageObjects.SearchResultsPage;
import com.automation.TestUtils.TestDataUtils;
import com.automation.constants.IPLConstants;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class VerifySearchResultsTest extends BaseTest {

        SearchResultsPage searchResultsPage;
    TestDataUtils testDataUtils = new TestDataUtils();



    @BeforeMethod
    public void initialize(){
            searchResultsPage=new SearchResultsPage(driver);
        }

        @Test
        public void verifySearchResultsPage() throws IOException {
        String path = testDataUtils.getPath("ExpectedSearchResult");
        String header=testDataUtils.getJsonString(path,"header");
            String searchText =testDataUtils.getJsonString(path,"searchText");
            List<String> expectedText=getJsonData(path,"expectedKeywords");
            searchResultsPage.execute(header);
            searchResultsPage.navigateToNewsSection(searchText);
            boolean textFound =searchResultsPage.isArticleFound(expectedText);
            Assert.assertTrue(textFound, IPLConstants.message);

        }

}
