package qase.io.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.UI.model.Project;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//button[@id='createButton']")
    private WebElement buttonCreateNewProject;

    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement inputProjectName;

    @FindBy(xpath = "//input[@id='project-code']")
    private WebElement inputProjectCode;

    @FindBy(xpath = "//span[text()='Create project']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//textarea[@id='description-area']")
    private WebElement projectsDescriptionArea;

    @FindBy(xpath = "//a[@class='defect-title']")
    private WebElement projectsList;

    @FindBy(xpath = "//span[text()='Delete project']")
    private WebElement buttonAcceptDeleteProject;



    public ProjectsPage openProjectsPage() {
        driver.get("https://app.qase.io/projects");
        return this;
    }

    public ProjectsPage clickOnButtonCreateNewProject() {
        buttonCreateNewProject.click();
        return this;
    }

    public ProjectsPage fillProjectNameField(String projectName) {
        inputProjectName.clear();
        inputProjectName.sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillProjectCodeField(String projectCode) {
        inputProjectName.clear();
        inputProjectCode.sendKeys(projectCode);
        return this;
    }

    public ProjectsPage fillProjectDescription(String textDescriptionProject) {
        projectsDescriptionArea.clear();
        projectsDescriptionArea.sendKeys(textDescriptionProject);
        return this;
    }

    public void clickOnButtonCreate() {
        buttonCreate.click();
    }

    public ProjectsPage clickOnProjectDropdown(Project project) {
        driver.findElement(By.xpath("//a[@class='defect-title'][contains(text(),'"
                + project.getProjectName() + "')]/ancestor::tr//a[@class='btn btn-dropdown']")).click();
        return this;
    }


    public ProjectsPage clickOnButtonDelete(Project project) {
        driver.findElement(By.xpath("//a[@class='defect-title'][contains(text(),'" + project.getProjectName()
                + "')]/ancestor::tr/td[@class='text-end']//button")).click();
        return this;
    }

    public ProjectsPage clickOnButtonAcceptDeleteProject() {
        buttonAcceptDeleteProject.click();
        return this;
    }

    public boolean isSuccessfulCreateProject(String projectName) {
        boolean isSuccessfulCreateProject = driver.findElement(By.xpath("//a[text()='" + projectName + "']")).isDisplayed();
        return true;
    }

    public boolean isSuccessfulDeleteProject(String projectName) {
        boolean isSuccessfulDeleteProject = driver.findElement(By.xpath("//a[text()='" + projectName + "']")).isDisplayed();
        return true;
    }


}
