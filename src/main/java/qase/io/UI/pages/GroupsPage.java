package qase.io.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.UI.model.Group;

public class GroupsPage extends BasePage {
    private static final String URL_GROUPS_PAGE = "https://app.qase.io/workspace/groups";

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
        driver.get(URL_GROUPS_PAGE);
        return this;
    }

    public GroupsPage clickOnCreateNewGroup() {
        buttonCreateNewGroup.click();
        return this;
    }

    public GroupsPage fillGroupTitle(String text) {
        inputGroupTitle.sendKeys(text);
        return this;
    }

    public GroupsPage fillTextareaGroupDescription(String text) {
        textareaGroupDescription.sendKeys(text);
        return this;
    }

    public GroupsPage clickOnButtonCreate() {
        buttonCreate.click();
        return this;
    }

    public boolean isSuccessfulCreateGroup(Group group) {
        boolean isSuccessfulCreateGroup = driver.findElement(By.xpath("//a[text()='"
                + group.getGroupTitle() + "']")).isDisplayed();
        return true;
    }

    public boolean isSuccessfulDeleteGroup(Group group) {
        boolean isSuccessfulDeleteProject = driver.findElement(By.xpath("//span[text()='User group \""
                +group.getGroupTitle()+"\" was deleted successfully!']")).isDisplayed();
        return true;
    }

    public GroupsPage clickOnGroupDropdown(Group group) {
        driver.findElement(By.xpath("//a[@class='btn btn-dropdown']//ancestor::tr[@data-qase-test='group-"
                + group.getGroupTitle().toLowerCase() + "']//a[@class='btn btn-dropdown']")).click();
        return this;
    }

    public GroupsPage clickOnButtonDelete(Group group) {
        driver.findElement(By.xpath("//a[text()='Delete']//ancestor::tr[@data-qase-test='group-"
                + group.getGroupTitle().toLowerCase() + "']//a[text()='Delete']")).click();
        return this;
    }

    public GroupsPage clickOnButtonDeleteGroup(){
        buttonDeleteGroup.click();
        return this;
    }
}
