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

    @FindBy(xpath = "//span[text()='Delete project']")
    private WebElement buttonAcceptDeleteProject;

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement projectSetting;

    @FindBy(xpath = "//button[@type='submit']/span[@class='UdZcu9']")
    private WebElement buttonSubmitUpdate;

    private String projectNameOnPageXpath = "//a[text()='%s']";
    private String projectDropdownButtonXpath = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr//a[@class='btn btn-dropdown']";
    private String projectButtonDeleteXpath = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr/td[@class='text-end']//button";
    private String projectButtonSettingsXpath = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr/td[@class='text-end']//div/a[contains(text(),'Setting')]";
    private String messageIsSuccessfulUpdateProjectXpath = "//span[text()='Project settings were successfully updated!']";

    public ProjectsPage openProjectsPage() {
        driver.get("https://app.qase.io/projects");
        return this;
    }

    public void clickOnButtonSubmitUpdate(){
        buttonSubmitUpdate.click();
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
        inputProjectCode.clear();
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
        driver.findElement(By.xpath(String.format(projectDropdownButtonXpath, project.getProjectName()))).click();
        return this;
    }

    public ProjectsPage clickOnProjectSetting(Project project){
        driver.findElement(By.xpath(String.format(projectButtonSettingsXpath,project.getProjectName()))).click();
        return this;

    }

    public ProjectsPage clickOnButtonDelete(Project project) {
        driver.findElement(By.xpath(String.format(projectButtonDeleteXpath, project.getProjectName()))).click();
        return this;
    }

    public ProjectsPage clickOnButtonAcceptDeleteProject() {
        buttonAcceptDeleteProject.click();
        return this;
    }

    public boolean isSuccessfulCreateProject(Project project) {
        boolean isSuccessfulCreateProject = driver.findElement(By.xpath
                (String.format(projectNameOnPageXpath, project.getProjectName()))).isDisplayed();
        return true;
    }

    public boolean isSuccessfulDeleteProject(Project project) {
        boolean isSuccessfulDeleteProject = driver.findElement(By.xpath
                (String.format(projectNameOnPageXpath, project.getProjectName()))).isEnabled();
        return true;
    }
    public boolean isSuccessfulUpdateProject() {
        boolean isSuccessfulDeleteProject = driver.findElement(By.xpath(messageIsSuccessfulUpdateProjectXpath)).isDisplayed();
        return true;
    }
}
