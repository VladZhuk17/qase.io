package qase.io.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public ProjectsPage openProjectsPage(){
        driver.get("https://app.qase.io/projects");
        return this;
    }

    public ProjectsPage clickOnButtonCreateNewProject() {
        buttonCreateNewProject.click();
        return this;
    }

    public ProjectsPage fillProjectNameField(String projectName) {
        inputProjectName.sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillProjectCodeField(String projectCode) {
        inputProjectName.clear();
        inputProjectCode.sendKeys(projectCode);
        return this;
    }

    public ProjectsPage fillProjectDescription(String textDescriptionProject) {
        projectsDescriptionArea.sendKeys(textDescriptionProject);
        return this;
    }

    public void clickOnButtonCreate() {
        buttonCreate.click();
    }

    public ProjectsPage clickOnProjectDropdown(String projectsName){
        driver.findElement(By.xpath("//a[@class='defect-title'][contains(text(),'"
                +projectsName+"')]/ancestor::tr//a[@class='btn btn-dropdown']")).click();
        return this;
    }

    public ProjectsPage clickOnButtonDelete(String projectName){
        driver.findElement(By.xpath("//a[@class='defect-title'][contains(text(),'"+projectName+"')]" +
                "/ancestor::tr//div[@class='dropdown-menu dropdown-menu-end show']//button[text()='Delete']")).click();
        return this;
    }
}
