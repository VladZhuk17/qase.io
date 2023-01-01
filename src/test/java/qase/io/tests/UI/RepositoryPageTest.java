package qase.io.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.Project;
import qase.io.UI.model.Suite;
import qase.io.UI.model.User;
import qase.io.UI.services.LoginPageService;
import qase.io.UI.services.RepositoryPageService;

public class RepositoryPageTest extends BaseTest {

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test(description = "Create a new suite")
    @Parameters({"projectCode", "suiteName"})
    public void verifyCreateNewSuiteTest(String projectCode, String suiteName) {
        Project project = Project.builder()
                .projectCode(projectCode)
                .build();
        RepositoryPageService repositoryPageService = new RepositoryPageService();
        boolean isSuccessfulCreateSuite = repositoryPageService.createNewSuite(project, suiteName)
                .isSuccessfulCreateSuite();
        Assert.assertTrue(isSuccessfulCreateSuite);
    }

    @Test(description = "Delete the suite")
    @Parameters({"projectCode", "suiteNameForDelete"})
    public void verifyDeleteSuiteTest(String projectCode, String suiteNameForDelete) {
        Suite suite = Suite.builder()
                .suiteName(suiteNameForDelete)
                .build();
        Project project = Project.builder().projectCode(projectCode).build();
        RepositoryPageService repositoryPageService = new RepositoryPageService();
        boolean isSuccessfulDeleteSuite = repositoryPageService.deleteSuite(project, suite)
                .isSuccessfulDeleteSuite();
        Assert.assertTrue(isSuccessfulDeleteSuite);
    }
}
