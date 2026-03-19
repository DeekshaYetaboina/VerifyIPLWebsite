package com.automation.PageObjects;

import com.automation.AbstractComponents.AbstractComponents;
import com.automation.IPLPageSelectors;
import com.automation.SeleniumUtils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends AbstractComponents {
  SeleniumUtils  seleniumUtils=new SeleniumUtils(driver);
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void execute(String header){
        driver.findElement(By.cssSelector((IPLPageSelectors.headers).replace("%s",header))).click();
    }

    By allTeams = By.cssSelector("ul.dropdown.arrow-top li.news.sub_menu a[data-element_text=\'ALL NEWS\']");
    By searchButton = By.cssSelector("button.search-icon-header-menu");
    By searchTab=By.cssSelector("input#searchInputForHeader");
   By newsSection=By.cssSelector("div.vn-latest-news");
   By allArticles = By.cssSelector("li.textTwoLine");


   public void navigateToNewsSection(String searchText) {
       driver.findElement(allTeams).click();
       seleniumUtils.waitForUrlToLoad("https://www.iplt20.com/news");
       driver.findElement(searchButton).click();
       seleniumUtils.waitForElementToAppear(searchTab);
       WebElement search =  driver.findElement(searchTab);
       search.sendKeys(searchText,Keys.ENTER);

   }

   public void verifySearchResultsPage() {
       seleniumUtils.waitForElementToAppear(newsSection);
       List<WebElement> articles =driver.findElements(allArticles);

       for(WebElement article:articles)
       {
           System.out.println(article.getText());
       }
   }




}
