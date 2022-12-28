package qase.io.UI.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import qase.io.UI.model.Tags;
import qase.io.UI.pages.TagsPage;

@Log4j2
public class TagsPageService {

    @Step
    public TagsPage createNewTag(Tags tags) {
        log.info("INFO: create a new tag");
        TagsPage tagsPage = new TagsPage();
        tagsPage.openTagsPage().clickOnCreateNewTag().fillTagName(tags).clickOnButtonSubmitCreateTag();
        return new TagsPage();
    }

    @Step
    public TagsPage deleteTag(Tags tags) {
        log.info("INFO: delete the tag");
        TagsPage tagsPage = new TagsPage();
        tagsPage.openTagsPage().clickOnTagsDropdown(tags).clickOnTagsButtonDelete(tags).clickOnTagsSubmitDelete();
        return new TagsPage();
    }
}
