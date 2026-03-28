package com.automation.tests;

import com.automation.PageObjects.PointsTable;
import com.automation.TestUtils.TestDataUtils;
import com.automation.tests.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyPointsTable extends BaseTest {
    TestDataUtils  testDataUtils = new TestDataUtils();
    PointsTable pointsTable;

    @BeforeMethod
    public void initialze(){
        pointsTable = new PointsTable(driver);
    }

    @Test
    public void verifyPointsTable() throws IOException {

        String path = testDataUtils.getPath("ExpectedPointsTable");
        String header = testDataUtils.getJsonString(path,"header");
        pointsTable.execute(header);
        String topTeam = pointsTable.getTopTeam();
        String expectedPoints= testDataUtils.getJsonString(path,"points");
        String expectedMatchesPlayed= testDataUtils.getJsonString(path,"matchesPlayed");
        String actualPoints = pointsTable.getActualPoints();
        String actualMatchesPlayed = pointsTable.getActualMatchesPlayed();

        System.out.println("Top Team: " + topTeam);
        Assert.assertEquals(actualPoints, expectedPoints,"The actual and expected points don't match");
        Assert.assertEquals(actualMatchesPlayed, expectedMatchesPlayed,"the actual matches played and expected don't match");


    }
}
