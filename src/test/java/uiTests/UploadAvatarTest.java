package uiTests;

import base.BaseTest;
import helper.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAvatarTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class, description = "User should be able to change profile avatar")
    public void verifyNewProfilePictureUpload() {
        log.info("Close trial modal and check user avatar");
        createProjectPage.closeTrialModal();
        softAssert.assertTrue(createProjectPage.isUserAvatarDisplayed(),
                "User avatar is not displayed");

        log.info("Navigate to the settings page and verify page content");
        createProjectPage.navigateToSettingsPage(actions);
        settingsPage.wait.until(ExpectedConditions.titleContains("Settings"));
        softAssert.assertEquals(settingsPage.getURL(), "https://picsart.com/settings",
                "Settings page URL is incorrect");
        softAssert.assertEquals(settingsPage.getUploadImageText(), "You can upload jpg. or png image files. Max size 2mb.",
                "Upload image text is incorrect");
        softAssert.assertTrue(settingsPage.isSaveButtonDisabled(), "Save button is active");

        log.info("upload new profile image and save changes");
        settingsPage.uploadPicture();
        softAssert.assertEquals(settingsPage.getSaveButtonText(), "Save Changes",
                "Save button text is incorrect");
        settingsPage.save();
        softAssert.assertAll();
    }
}
