package qase.io.UI.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import qase.io.UI.model.Project;
import qase.io.UI.pages.ProjectsPage;

@Log4j2
public class ProjectPageService {

    private ProjectsPage projectsPage;

    @Step("Create new project")
    public ProjectsPage createNewProject (Project project){
        log.info("INFO: create a new project");
        projectsPage = new ProjectsPage();
        projectsPage.clickOnButtonCreateNewProject()
                .fillProjectNameField(project.getProjectName())
                .fillProjectCodeField(project.getProjectCode())
                .fillProjectDescription(project.getDescription())
                .clickOnButtonCreate();
        return new ProjectsPage();
    }

    @Step("Update project")
    public ProjectsPage updateProject(Project project, String newProjectName, String newProjectCode, String newDescription){
        log.info("INFO: update the project");
        projectsPage.clickOnProjectDropdown(project)
                .clickOnProjectSetting(project)
                .fillProjectNameField(newProjectName)
                .fillProjectCodeField(newProjectCode)
                .fillProjectDescription(newDescription)
                .clickOnButtonSubmitUpdate();
        return new ProjectsPage();
    }

    @Step("Delete project")
    public ProjectsPage deleteProject (Project project){
        log.info("INFO: delete the project");
        projectsPage = new ProjectsPage();
        projectsPage.openProjectsPage()
                .clickOnProjectDropdown(project)
                .clickOnButtonDelete(project).clickOnButtonAcceptDeleteProject();
        return new ProjectsPage();
    }


}
