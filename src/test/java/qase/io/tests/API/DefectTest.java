package qase.io.tests.API;

import org.testng.Assert;
import org.testng.annotations.Test;
import qase.io.API.adapters.DefectAdapter;
import qase.io.API.models.Defect;
import static java.net.HttpURLConnection.HTTP_OK;

public class DefectTest {

    private String projectCode = "NP";

    @Test
    public void getAllDefectsTest() {
        int statusCode = new DefectAdapter().getAllDefects(projectCode).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void creteNewDefect() {
        Defect defect = Defect.builder().title("dtttttte").actual_result("asdwse").severity(2).build();
        boolean status = new DefectAdapter().createDefect(projectCode, defect).body().path("status");
        Assert.assertTrue(status);
    }

    @Test
    public void deleteDefect() {
        Defect defect = Defect.builder().id(9).build();
        boolean status = new DefectAdapter().deleteDefect(projectCode, defect).path("status");
        Assert.assertTrue(status);
    }

    @Test
    public void getSpecificDefect() {
        Defect defect = Defect.builder().id(4).build();
        int statusCode = new DefectAdapter().getSpecificDefect(projectCode, defect).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void updateDefect() {
        Defect defect = Defect.builder().id(11).title("upDateTitle").actual_result("asd").severity(2).build();
        boolean status = new DefectAdapter().createDefect(projectCode, defect).body().path("status");
        Assert.assertTrue(status);
    }
}
