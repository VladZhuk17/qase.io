package qase.io.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.model.Project;
import qase.io.model.User;
import qase.io.services.LoginPageService;
import qase.io.services.ProjectPageService;

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

    @Test(priority = 1, description = "Create a new project")
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

    @Test (priority = 2, description = "Update the project")
    @Parameters({"projectNameForUpdate", "projectCodeForUpdate","newProjectName","newProjectCode","newDescription"})
    public void verifyUpdateProjectTest(String projectNameForUpdate, String projectCodeForUpdate, String newProjectName, String newProjectCode, String newDescription){
        Project project = Project.builder()
                .projectName(projectNameForUpdate)
                .projectCode(projectCodeForUpdate)
                .build();
        boolean isSuccessfulUpdateProject = projectPageService.updateProject(project, newProjectName, newProjectCode, newDescription).isSuccessfulUpdateProject();
        Assert.assertTrue(isSuccessfulUpdateProject);
    }

    @Test (priority = 3, description = "Delete the project")
    @Parameters({"projectNameForDelete", "projectCodeForDelete"})
    public void verifyDeleteProjectTest(String projectNameForDelete, String projectCodeForDelete) {
        Project project = Project.builder()
                .projectName(projectNameForDelete)
                .projectCode(projectCodeForDelete)
                .build();
        projectPageService = new ProjectPageService();
        boolean isSuccessfulDeleteProject = projectPageService.deleteProject(project)
                .isSuccessfulDeleteProject(project);
        Assert.assertTrue(isSuccessfulDeleteProject);
    }
}
