package qase.io.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.model.Project;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String URL_PROJECT_PAGE = "https://app.qase.io/projects";
    private static final String PROJECT_NAME_ON_PAGE_XPATH = "//a[text()='%s']";
    private static final String PROJECT_DROPDOWN_BUTTON_XPATH = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr//a[@class='btn btn-dropdown']";
    private static final String PROJECT_BUTTON_DELETE_XPATH = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr/td[@class='text-end']//button";
    private static final String PROJECT_BUTTON_SETTINGS_XPATH = "//a[@class='defect-title'][contains(text(),'%s')]/ancestor::tr/td[@class='text-end']//div/a[contains(text(),'Setting')]";
    private static final String MESSAGE_IS_SUCCESSFUL_UPDATE_PROJECT_XPATH = "//span[text()='Project settings were successfully updated!']";

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


    public ProjectsPage openProjectsPage() {
        driver.get(URL_PROJECT_PAGE);
        return this;
    }

    public void clickOnButtonSubmitUpdate(){
        log.info("INFO: click on button submit update");
        buttonSubmitUpdate.click();
    }

    public ProjectsPage clickOnButtonCreateNewProject() {
        log.info("INFO: click on button create new project");
        buttonCreateNewProject.click();
        return this;
    }

    public ProjectsPage fillProjectNameField(String projectName) {
        log.info("INFO: fill project name field");
        inputProjectName.clear();
        inputProjectName.sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillProjectCodeField(String projectCode) {
        log.info("INFO: fill project code field");
        inputProjectCode.clear();
        inputProjectCode.sendKeys(projectCode);
        return this;
    }

    public ProjectsPage fillProjectDescription(String textDescriptionProject) {
        log.info("INFO: fill project description");
        projectsDescriptionArea.clear();
        projectsDescriptionArea.sendKeys(textDescriptionProject);
        return this;
    }

    public void clickOnButtonCreate() {
        log.info("INFO: click on button create");
        buttonCreate.click();
    }

    public ProjectsPage clickOnProjectDropdown(Project project) {
        log.info("INFO: click on project dropdown");
        driver.findElement(By.xpath(String.format(PROJECT_DROPDOWN_BUTTON_XPATH, project.getProjectName()))).click();
        return this;
    }

    public ProjectsPage clickOnProjectSetting(Project project){
        log.info("INFO: click on project setting");
        driver.findElement(By.xpath(String.format(PROJECT_BUTTON_SETTINGS_XPATH,project.getProjectName()))).click();
        return this;

    }

    public ProjectsPage clickOnButtonDelete(Project project) {
        log.info("INFO: click on button delete");
        driver.findElement(By.xpath(String.format(PROJECT_BUTTON_DELETE_XPATH, project.getProjectName()))).click();
        return this;
    }

    public ProjectsPage clickOnButtonAcceptDeleteProject() {
        log.info("INFO: click on button accept deletion project");
        buttonAcceptDeleteProject.click();
        return this;
    }

    public boolean isSuccessfulCreateProject(Project project) {
        boolean isSuccessfulCreateProject = driver.findElement(By.xpath
                (String.format(PROJECT_NAME_ON_PAGE_XPATH, project.getProjectName()))).isDisplayed();
        return isSuccessfulCreateProject;
    }

    public boolean isSuccessfulDeleteProject(Project project) {
        boolean isSuccessfulDeleteProject;
        try {
            driver.findElement(By.xpath(String.format(PROJECT_NAME_ON_PAGE_XPATH, project.getProjectName())));
            isSuccessfulDeleteProject = false;
        } catch (NoSuchElementException e) {
            isSuccessfulDeleteProject = true;
        }
        return isSuccessfulDeleteProject;

    }
    public boolean isSuccessfulUpdateProject() {
        boolean messageIsSuccessfulUpdateProject = driver.findElement(By.xpath(MESSAGE_IS_SUCCESSFUL_UPDATE_PROJECT_XPATH)).isDisplayed();
        return messageIsSuccessfulUpdateProject;
    }
}
