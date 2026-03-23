package com.automation.tests.testComponents;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://www.iplt20.com/");
    driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
    driver.quit();
    }
    public String takeScreenShot(String testcaseName) throws IOException {
    TakesScreenshot t = (TakesScreenshot) driver;
    File source = t.getScreenshotAs(OutputType.FILE);
    File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
    FileUtils.copyFile(source,file);
    return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
    }

  public List<String> getJsonData(String filename,String key) throws IOException {
      ObjectMapper mapper = new ObjectMapper();
      Map<String,List<String>> data = mapper.readValue(new File(filename),Map.class);
      return data.get(key);
  }



}
