package com.automation.tests.testComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else{
            throw new RuntimeException("Browser not supported"+browser);
        }

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





}
