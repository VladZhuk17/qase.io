package qase.io.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.model.Project;
import qase.io.model.Suite;

@Log4j2
public class RepositoryPage extends BasePage {

    private static final String BUTTON_SUITE_SETTING_XPATH ="//a[text()='%s']//ancestor::div[@class='UReP3r']//i[@class='fa fa-ellipsis-h']";

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
        log.info("INFO: click on button add new suite");
        buttonAddNewSuite.click();
        return this;
    }

    public RepositoryPage clickOnDeleteSuite(){
        log.info("INFO: click on button delete suite");
        buttonDeleteSuite.click();
        return this;
    }

    public RepositoryPage clickOnButtonSubmitDeleteSuite(){
        log.info("INFO: click on button accept deletion suite");
        buttonSubmitDeleteSuite.click();
        return this;
    }

    public RepositoryPage fillSuiteName(Suite suite) {
        log.info("INFO: fill suite name");
        inputSuiteName.sendKeys(suite.getSuiteName());
        return this;
    }

    public void clickOnButtonCreateSuite() {
        log.info("INFO: click on button create suite");
        buttonCreateSuite.click();
    }

    public RepositoryPage clickOnSettingSuite(Suite suite) {
        log.info("INFO: click on button suite setting");
        driver.findElement(By.xpath(String.format(BUTTON_SUITE_SETTING_XPATH,suite.getSuiteName()))).click();
        return this;
    }

    public boolean isSuccessfulCreateSuite() {
        boolean isSuccessfulCreateSuite = waitElement(textIsSuccessfullyCreateMessage).isDisplayed();
        return isSuccessfulCreateSuite;
    }

    public boolean isSuccessfulDeleteSuite() {
        boolean isSuccessfulDeleteSuite = waitElement(textIsSuccessfullyDeleteMessage).isDisplayed();
        return isSuccessfulDeleteSuite;
    }
}
