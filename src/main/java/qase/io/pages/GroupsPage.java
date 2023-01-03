package qase.io.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.model.Group;

@Log4j2
public class GroupsPage extends BasePage {

    private static final String URL_GROUPS_PAGE = "https://app.qase.io/workspace/groups";
    private static final String BUTTON_DELETE_GROUP_XPATH = "//a[text()='Delete']//ancestor::tr[@data-qase-test='group-%s']//a[text()='Delete']";
    private static final String BUTTON_GROUP_DROPDOWN_XPATH = "//a[@class='btn btn-dropdown']//ancestor::tr[@data-qase-test='group-%s']//a[@class='btn btn-dropdown']";
    private static final String GROUP_NAME_ON_PAGE_XPATH = "//a[text()='%s']";
    private static final String MESSAGE_IS_SUCCESSFUL_DELETE_GROUP_XPATH = "//span[text()='User group \"%s\" was deleted successfully!']";

    @FindBy(xpath = "//a[text()='Create a new group']")
    private WebElement buttonCreateNewGroup;

    @FindBy(xpath = "//input[@id='inputTitle']")
    private WebElement inputGroupTitle;

    @FindBy(xpath = "//textarea[@id='inputDescription']")
    private WebElement textareaGroupDescription;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//button[@data-qase-test='group-delete-confirm-button']")
    private WebElement buttonDeleteGroup;

    public GroupsPage openGroupsPage() {
        log.info("INFO: open group page");
        driver.get(URL_GROUPS_PAGE);
        return this;
    }

    public GroupsPage clickOnCreateNewGroup() {
        log.info("INFO: click on button create a new group");
        buttonCreateNewGroup.click();
        return this;
    }

    public GroupsPage fillGroupTitle(String text) {
        log.info("INFO: fill group title");
        inputGroupTitle.sendKeys(text);
        return this;
    }

    public GroupsPage fillTextareaGroupDescription(String text) {
        log.info("INFO: fill text for group description");
        textareaGroupDescription.sendKeys(text);
        return this;
    }

    public GroupsPage clickOnButtonCreate() {
        log.info("INFO: click on button create group");
        buttonCreate.click();
        return this;
    }

    public boolean isSuccessfulCreateGroup(Group group) {
        boolean isSuccessfulCreateGroup = driver.findElement(By.xpath(String.format(GROUP_NAME_ON_PAGE_XPATH, group.getGroupTitle()))).isDisplayed();
        return isSuccessfulCreateGroup;
    }

    public boolean isSuccessfulDeleteGroup(Group group) {
        boolean isSuccessfulDeleteProjectGroup = driver.findElement(By.xpath(String.format(MESSAGE_IS_SUCCESSFUL_DELETE_GROUP_XPATH,group.getGroupTitle()))).isDisplayed();
        return isSuccessfulDeleteProjectGroup;
    }

    public GroupsPage clickOnGroupDropdown(Group group) {
        driver.findElement(By.xpath(String.format(BUTTON_GROUP_DROPDOWN_XPATH, group.getGroupTitle().toLowerCase()))).click();
        return this;
    }

    public GroupsPage clickOnButtonDelete(Group group) {
        driver.findElement(By.xpath(String.format(BUTTON_DELETE_GROUP_XPATH, group.getGroupTitle().toLowerCase()))).click();
        return this;
    }

    public GroupsPage clickOnButtonDeleteGroup() {
        buttonDeleteGroup.click();
        return this;
    }
}
