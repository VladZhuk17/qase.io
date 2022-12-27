package qase.io.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.UI.model.Tags;

public class TagsPage extends BasePage {

    private static final String URL_TAGS_PAGE = "https://app.qase.io/workspace/tags";

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonCreateNewTag;

    @FindBy(xpath = "//input[@id='confirm']")
    private WebElement inputTagName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitCreateTag;

    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement buttonDeleteTag;

    public TagsPage openTagsPage() {
        driver.get(URL_TAGS_PAGE);
        return this;
    }

    public TagsPage clickOnCreateNewTag() {
        buttonCreateNewTag.click();
        return this;
    }

    public TagsPage fillTagName(Tags tags) {
        inputTagName.sendKeys(tags.getTagName());
        return this;
    }

    public TagsPage clickOnButtonSubmitCreateTag() {
        buttonSubmitCreateTag.click();
        return this;
    }

    public TagsPage clickOnTagsDropdown(Tags tags){
        driver.findElement(By.xpath("//td[text()='"+tags.getTagName()+"']/ancestor::tr//a[@class='btn btn-dropdown']")).click();
        return this;
    }

    public TagsPage clickOnTagsButtonDelete(Tags tags){
        driver.findElement(By.xpath("//td[text()='"+tags.getTagName()+"']/ancestor::tr//a[text()='Delete']")).click();
        return this;
    }

    public TagsPage clickOnTagsSubmitDelete(){
        buttonDeleteTag.click();
        return this;
    }

    public boolean isSuccessfulCreateTag(Tags tags) {
        boolean isSuccessfulCreateTag = driver.findElement(By.xpath("//td[text()='"
                + tags.getTagName() + "']/ancestor::tr//a[@class='btn btn-dropdown']")).isDisplayed();
        return true;
    }

    public boolean isSuccessfulDeleteTag(Tags tags) {
        boolean isSuccessfulDeleteTag = driver.findElement(By.xpath("//td[text()='"
                +tags.getTagName()+"']/ancestor::tr//a[@class='btn btn-dropdown']")).isDisplayed();
        return true;
    }
}