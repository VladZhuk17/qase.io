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
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test(priority = 1, description = "Create new project")
    @Parameters({"projectName", "projectCode", "projectsDescription"})
    public void verifyCreateNewProjectTest(String projectName, String projectCode, String projectsDescription) {
        Project project = Project.builder()
                .projectName(projectName)
                .projectCode(projectCode)
                .description(projectsDescription)
                .build();
        projectPageService = new ProjectPageService();
        boolean isSuccessfulCreateProject = projectPageService.createNewProject(project)
                .openProjectsPage()
                .isSuccessfulCreateProject(project);
        Assert.assertTrue(isSuccessfulCreateProject);
    }

    @Test (priority = 2)
    @Parameters({"projectName", "projectCode","newProjectName","newProjectCode","newDescription"})
    public void verifyUpdateProjectTest(String projectName, String projectCode, String newProjectName, String newProjectCode, String newDescription){
        Project project = Project.builder()
                .projectName(projectName)
                .projectCode(projectCode)
                .build();
        boolean isSuccessfulUpdateProject = projectPageService.updateProject(project, newProjectName, newProjectCode, newDescription).isSuccessfulUpdateProject();
        Assert.assertTrue(isSuccessfulUpdateProject);
    }

    @Test (priority = 3)
    @Parameters({"projectForDelete"})
    public void verifyDeleteProjectTest(String projectForDelete) {
        Project project = Project.builder()
                .projectName(projectForDelete)
                .build();
        projectPageService = new ProjectPageService();
        boolean isSuccessfulDeleteProject = projectPageService.deleteProject(project)
                .isSuccessfulDeleteProject(project);
        Assert.assertTrue(isSuccessfulDeleteProject);
    }
}
