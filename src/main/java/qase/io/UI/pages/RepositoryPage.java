package qase.io.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.UI.model.Project;
import qase.io.UI.model.Suite;

public class RepositoryPage extends BasePage {

    @FindBy(xpath = "//span[text()='Suite was successfully created.']")
    private WebElement textIsSuccessfullyCreateMessage;

    @FindBy(xpath = "//span[text()='Suite was successfully deleted.']")
    private WebElement textIsSuccessfullyDeleteMessage;

    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement buttonAddNewSuite;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputSuiteName;

    @FindBy(xpath = "//div[@id='descriptionGroup']/div[@class='ProseMirror-container markdown-area wysiwyg']/div")
    private WebElement inputSuiteDescription;

    @FindBy(xpath = "//div[@id='preconditionsGroup']/div[@class='ProseMirror-container markdown-area wysiwyg']/div")
    private WebElement inputSuitePreconditions;

    @FindBy(xpath = "//span[text()='Create']")
    private WebElement buttonCreateSuite;

    @FindBy(xpath = "//input[@placeholder='+ Create quick test']")
    private WebElement inputCreateTest;

    @FindBy(xpath = "//div[@class='D6EIXH rzizJk']")
    private WebElement buttonDeleteSuite;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitDeleteSuite;

    public RepositoryPage openRepositoryPage(Project project) {
        driver.get("https://app.qase.io/project/" + project.getProjectCode() + "?view=1");
        return this;
    }

    public RepositoryPage clickOnButtonAddNewSuite() {
        buttonAddNewSuite.click();
        return this;
    }

    public RepositoryPage clickOnDeleteSuite(){
        buttonDeleteSuite.click();
        return this;
    }

    public RepositoryPage clickOnButtonSubmitDeleteSuite(){
        buttonSubmitDeleteSuite.click();
        return this;
    }

    public RepositoryPage fillSuiteName(Suite suite) {
        inputSuiteName.sendKeys(suite.getSuiteName());
        return this;
    }

    public RepositoryPage fillSuiteDescription(Suite suite) {
        inputSuiteDescription.sendKeys(suite.getSuiteDescription());
        return this;
    }

    public RepositoryPage fillSuitePreconditions(Suite suite) {
        inputSuitePreconditions.sendKeys(suite.getSuitePreconditions());
        return this;
    }

    public void clickOnButtonCreateSuite() {
        buttonCreateSuite.click();
    }

    public RepositoryPage clickOnSettingSuite(Suite suite) {
        driver.findElement(By.xpath("//a[text()='"
                + suite.getSuiteName() + "']//ancestor::div[@class='UReP3r']//i[@class='fa fa-ellipsis-h']")).click();
        return this;
    }

    public void createTest(String testName) {
        inputCreateTest.sendKeys(testName + "\n");
    }

    public boolean isSuccessfulCreateSuite() {
        boolean isSuccessfulCreateSuite = waitElement(textIsSuccessfullyCreateMessage).isDisplayed();
        return true;
    }

    public boolean isSuccessfulDeleteSuite() {
        boolean isSuccessfulDeleteSuite = waitElement(textIsSuccessfullyDeleteMessage).isDisplayed();
        return true;
    }
}
