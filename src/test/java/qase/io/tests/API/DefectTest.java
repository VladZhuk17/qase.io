package qase.io.tests.API;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qase.io.API.adapters.DefectAdapter;
import qase.io.API.models.Defect;
import qase.io.UI.utils.Retry;
import qase.io.UI.utils.TestListener;

import static java.net.HttpURLConnection.HTTP_OK;

@Listeners(TestListener.class)
public class DefectTest {

    private String projectCode = "NP";

    @Test (description = "get all defects", retryAnalyzer = Retry.class)
    public void getAllDefectsTest() {
        int statusCode = new DefectAdapter().getAllDefects(projectCode).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test(description = "create new defects", retryAnalyzer = Retry.class)
    public void creteNewDefect() {
        Defect defect = Defect.builder().title("dtttttte").actual_result("asdwse").severity(2).build();
        boolean status = new DefectAdapter().createDefect(projectCode, defect).body().path("status");
        Assert.assertTrue(status);
    }

    @Test(description = "delete defect by ID", retryAnalyzer = Retry.class)
    public void deleteDefect() {
        Defect defect = Defect.builder().id(5).build();
        boolean status = new DefectAdapter().deleteDefect(projectCode, defect).path("status");
        Assert.assertTrue(status);
    }

    @Test (description = "get the defect by ID", retryAnalyzer = Retry.class)
    public void getSpecificDefect() {
        Defect defect = Defect.builder().id(5).build();
        int statusCode = new DefectAdapter().getSpecificDefect(projectCode, defect).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test (description = "update the defect", retryAnalyzer = Retry.class)
    public void updateDefect() {
        Defect defect = Defect.builder().id(11).title("upDateTitle").actual_result("asd").severity(2).build();
        boolean status = new DefectAdapter().createDefect(projectCode, defect).body().path("status");
        Assert.assertTrue(status);
    }
}
