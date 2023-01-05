package qase.io.tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import qase.io.adapters.DefectAdapter;
import qase.io.model.Defect;
import qase.io.utils.Retry;
import static java.net.HttpURLConnection.HTTP_OK;

public class DefectTest {

    private String projectCode = "TP";

    @Test(description = "get all defects", retryAnalyzer = Retry.class)
    public void getAllDefectsTest() {
        int statusCode = new DefectAdapter().getAllDefects(projectCode).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(description = "create new defects", retryAnalyzer = Retry.class)
    public void creteNewDefect() {
        Defect defect = Defect.builder().title("defectTitle").actualResult("blocker").severity(2).build();
        boolean status = new DefectAdapter().createDefect(projectCode, defect).body().path("status");
        Assert.assertTrue(status);
    }

    @Test(description = "delete defect by ID", retryAnalyzer = Retry.class)
    public void deleteDefect() {
        Defect defect = Defect.builder().id(6).build();
        boolean status = new DefectAdapter().deleteDefect(projectCode, defect).path("status");
        Assert.assertTrue(status);
    }

    @Test(description = "get the defect by ID", retryAnalyzer = Retry.class)
    public void getSpecificDefect() {
        Defect defect = Defect.builder().id(5).build();
        int statusCode = new DefectAdapter().getSpecificDefect(projectCode, defect).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(description = "update the defect", retryAnalyzer = Retry.class)
    public void updateDefectTest() {
        int defectIdForUpdate = 4;
        Defect defect = Defect.builder().title("upDateTitle").actualResult("asd").severity(5).build();
        boolean status = new DefectAdapter().updateDefect(projectCode, defectIdForUpdate, defect).body().path("status");
        Assert.assertTrue(status);
    }
}
