package qase.io.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.Project;
import qase.io.UI.model.User;
import qase.io.UI.services.LoginPageService;
import qase.io.UI.services.ProjectPageService;

public class ProjectsPageTest extends BaseTest {

    private ProjectPageService projectPageService;

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder().email("vladzhuk091193@gmail.com").password("Pp28092019").build();
        loginPageService.login(user);
    }

    @Test(description = "Create new project")
    @Parameters({"projectName", "projectCode", "projectsDescription"})
    public void verifyCreateNewProjectTest(String projectName, String projectCode, String projectsDescription) {
        Project project = Project.builder().projectName(projectName).projectCode(projectCode).description(projectsDescription).build();
        projectPageService = new ProjectPageService();
        boolean actualProjectName = projectPageService.createNewProject(project)
                .openProjectsPage()
                .isSuccessfulCreateProject(project.getProjectName());
        Assert.assertTrue(actualProjectName);
    }

    @Test
    @Parameters({"projectForDelete"})
    public void verifyDeleteProjectTest(String projectForDelete) {
        Project project = Project.builder().projectName(projectForDelete).build();
        projectPageService = new ProjectPageService();
        boolean actualResult = projectPageService.deleteProject(project).isSuccessfulDeleteProject(projectForDelete);
        Assert.assertFalse(actualResult);
    }
}
