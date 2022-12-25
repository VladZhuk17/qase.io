package qase.io.UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qase.io.UI.model.Tags;

public class TagsPage extends BasePage {

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonCreateNewTag;

    @FindBy(xpath = "//input[@id='confirm']")
    private WebElement inputTagName;

    public TagsPage clickOnCreateNewTag() {
        buttonCreateNewTag.click();
        return this;
    }

    public TagsPage fillTagName(Tags tags) {
        inputTagName.sendKeys(tags.getTagName());
        return this;
    }

}
