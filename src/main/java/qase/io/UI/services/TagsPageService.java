package qase.io.UI.services;

import io.qameta.allure.Step;
import qase.io.UI.model.Tags;
import qase.io.UI.pages.TagsPage;

public class TagsPageService {

    @Step
    public TagsPage createNewTag(Tags tags) {
        TagsPage tagsPage = new TagsPage();
        tagsPage.openTagsPage().clickOnCreateNewTag().fillTagName(tags).clickOnButtonSubmitCreateTag();
        return new TagsPage();
    }

    @Step
    public TagsPage deleteTag(Tags tags) {
        TagsPage tagsPage = new TagsPage();
        tagsPage.openTagsPage().clickOnTagsDropdown(tags).clickOnTagsButtonDelete(tags).clickOnTagsSubmitDelete();
        return new TagsPage();
    }
}
