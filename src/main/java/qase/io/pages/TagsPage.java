package qase.io.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.model.Tags;

@Log4j2
public class TagsPage extends BasePage {

    private static final String URL_TAGS_PAGE = "https://app.qase.io/workspace/tags";
    private static final String TAG_NAME_ON_PAGE_XPATH = "//td[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    private static final String BUTTON_TAG_DROPDOWN_XPATH = "//td[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    private static final String BUTTON_DELETE_TEG_XPATH = "//td[text()='%s']/ancestor::tr//a[text()='Delete']";

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonCreateNewTag;

    @FindBy(xpath = "//input[@id='confirm']")
    private WebElement inputTagName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitCreateTag;

    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement buttonDeleteTag;

    public TagsPage openTagsPage() {
        log.info("INFO: open Tags Page");
        driver.get(URL_TAGS_PAGE);
        return this;
    }

    public TagsPage clickOnCreateNewTag() {
        log.info("INFO: click on button create new tag");
        buttonCreateNewTag.click();
        return this;
    }

    public TagsPage fillTagName(Tags tags) {
        log.info("INFO: fill tag name");
        inputTagName.sendKeys(tags.getTagName());
        return this;
    }

    public TagsPage clickOnButtonSubmitCreateTag() {
        log.info("INFO: click on button accept create tag");
        buttonSubmitCreateTag.click();
        return this;
    }

    public TagsPage clickOnTagsDropdown(Tags tags){
        log.info("INFO: click on tags dropdown");
        driver.findElement(By.xpath(String.format(BUTTON_TAG_DROPDOWN_XPATH,tags.getTagName()))).click();
        return this;
    }

    public TagsPage clickOnTagsButtonDelete(Tags tags){
        log.info("INFO: click on button delete tag");
        driver.findElement(By.xpath(String.format(BUTTON_DELETE_TEG_XPATH,tags.getTagName()))).click();
        return this;
    }

    public TagsPage clickOnTagsSubmitDelete(){
        log.info("INFO: click on button accept delete tag");
        buttonDeleteTag.click();
        return this;
    }

    public boolean isSuccessfulCreateTag(Tags tags) {
        boolean isSuccessfulCreateTag = driver.findElement(By.xpath(String.format(TAG_NAME_ON_PAGE_XPATH,tags.getTagName()))).isDisplayed();
        return isSuccessfulCreateTag;
    }

    public boolean isSuccessfulDeleteTag(Tags tags) {
        boolean isSuccessfulDeleteTag = driver.findElement(By.xpath(String.format(TAG_NAME_ON_PAGE_XPATH, tags.getTagName()))).isEnabled();
        return isSuccessfulDeleteTag;
    }
}
