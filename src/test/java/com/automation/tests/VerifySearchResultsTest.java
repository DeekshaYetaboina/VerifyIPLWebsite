package com.automation.tests;

import com.automation.PageObjects.SearchResultsPage;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class VerifySearchResultsTest extends BaseTest {

        SearchResultsPage searchResultsPage;



    @BeforeMethod
    public void initialize(){
            searchResultsPage=new SearchResultsPage(driver);
        }

        @Test
        public void verifySearchResultsPage() throws IOException {
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\data\\ExpectedSearchResult.json";
        String header=getJsonString(path,"header");
            String searchText =getJsonString(path,"searchText");
            List<String> expectedText=getJsonData(path,"expectedKeywords");
            searchResultsPage.execute(header);
            searchResultsPage.navigateToNewsSection(searchText);
            searchResultsPage.verifySearchResultsPage();
            boolean textFound =searchResultsPage.isArticleFound(expectedText);
            Assert.assertTrue(textFound,"No article found on auction 2026");

        }

}
