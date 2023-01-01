package qase.io.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qase.io.UI.model.Tags;
import qase.io.UI.model.User;
import qase.io.UI.services.LoginPageService;
import qase.io.UI.services.TagsPageService;

public class TagsPageTest {

    @BeforeClass
    public void login() {
        LoginPageService loginPageService = new LoginPageService();
        User user = User.builder()
                .email("wfortestw@gmail.com")
                .password("T72YPufVFi#S$3r")
                .build();
        loginPageService.login(user);
    }

    @Test
    @Parameters({"tagName"})
    public void verifyCreateNewTag(String tagName) {
        Tags tags = Tags.builder().tagName(tagName).build();
        TagsPageService tagsPageService = new TagsPageService();
        boolean isSuccessfulCreateTag = tagsPageService.createNewTag(tags)
                .isSuccessfulCreateTag(tags);
        Assert.assertTrue(isSuccessfulCreateTag);
    }

    @Test
    @Parameters({"tagName"})
    public void verifyDeleteTag(String tagName){
        Tags tags = Tags.builder().tagName(tagName).build();
        TagsPageService tagsPageService = new TagsPageService();
       boolean isSuccessfulDeleteTag = tagsPageService.deleteTag(tags)
               .isSuccessfulDeleteTag(tags);
       Assert.assertTrue(isSuccessfulDeleteTag);
    }
}
