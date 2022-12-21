package qase.io.tests.UI;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.User;
import qase.io.UI.services.LoginPageService;
import qase.io.UI.services.ProjectPageService;

public class ProjectsPageTest extends BaseTest {
    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder().email("vladzhuk091193@gmail.com").password("Pp28092019").build();
        loginPageService.login(user);
    }

    @Test(description = "Create new project")
    @Parameters({"projectName", "projectCode", "projectsDescription"})
    public void createNewProjectTest(String projectName, String projectCode, String projectsDescription) {
        ProjectPageService projectPageService = new ProjectPageService();
        projectPageService.createNewProject(projectName, projectCode, projectsDescription).openProjectsPage();
        String actual = driver.findElement(By.xpath("//a[text()='" + projectName + "']")).getText();
        String expected = projectName;
        Assert.assertEquals(actual, expected);
    }

    @Test
    @Parameters({"projectName"})
    public void deleteProjectTest(String projectName) {
        ProjectPageService projectPageService = new ProjectPageService();
        projectPageService.deleteProject(projectName);

    }
}
