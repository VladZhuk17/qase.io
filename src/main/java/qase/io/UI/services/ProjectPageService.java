package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.Project;
import qase.io.UI.pages.ProjectsPage;

public class ProjectPageService {
    @Step("Create new project")
    public ProjectsPage createNewProject (String projectsName, String projectsCode, String projectsDescription){
        Project project = Project.builder()
                .projectName(projectsName)
                .projectCode(projectsCode)
                .description(projectsDescription)
                .build();
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.clickOnButtonCreateNewProject()
                .fillProjectNameField(project.getProjectName())
                .fillProjectCodeField(project.getProjectCode())
                .fillProjectDescription(project.getDescription())
                .clickOnButtonCreate();
        return new ProjectsPage();
    }

    @Step("Delete project")
    public ProjectsPage deleteProject (String projectsName){
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openProjectsPage()
                .clickOnProjectDropdown(projectsName)
                .clickOnButtonDelete(projectsName);
        return new ProjectsPage();

    }
}
