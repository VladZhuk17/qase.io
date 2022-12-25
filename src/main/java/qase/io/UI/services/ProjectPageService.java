package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.Project;
import qase.io.UI.pages.ProjectsPage;

public class ProjectPageService {

    private ProjectsPage projectsPage;

    @Step("Create new project")
    public ProjectsPage createNewProject (Project project){
        projectsPage = new ProjectsPage();
        projectsPage.clickOnButtonCreateNewProject()
                .fillProjectNameField(project.getProjectName())
                .fillProjectCodeField(project.getProjectCode())
                .fillProjectDescription(project.getDescription())
                .clickOnButtonCreate();
        return new ProjectsPage();
    }

    @Step("Delete project")
    public ProjectsPage deleteProject (Project project){
        projectsPage = new ProjectsPage();
        projectsPage.openProjectsPage()
                .clickOnProjectDropdown(project)
                .clickOnButtonDelete(project).clickOnButtonAcceptDeleteProject();
        return new ProjectsPage();
    }


}
