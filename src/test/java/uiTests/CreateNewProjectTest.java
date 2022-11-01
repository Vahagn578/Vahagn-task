package uiTests;

import base.BaseTest;
import helper.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewProjectTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyNewProjectButton() {
        log.info("Close trial modal and check create project page content");
        createProjectPage.closeTrialModal();
        softAssert.assertTrue(createProjectPage.getBannerText().contains("Turn inspiration into action"), "Banner text is different");
        softAssert.assertTrue(createProjectPage.getNewProjectButtonText().contains("+ New project"), "New Project button text is incorrect");

        log.info("Click +New Project button and check if it opens editor page");
        createProjectPage.clickNewProjectButton();
        projectPage.handleTabs();
        softAssert.assertTrue(projectPage.getPageTitle().contains("Picsart Editor"),
                "Editor page title is incorrect");
        Assert.assertEquals(projectPage.getURL(), "https://picsart.com/create/editor?category=layout&customSize=1080x1080&unit=px",
                "URL is incorrect for the editor page");

        log.info("Close hints and check if layout is selected by default");
        projectPage.closeHints();
        Assert.assertTrue(projectPage.isLayoutCategorySelectedByDefault(),"The default category is not the Layout");
        softAssert.assertAll();
    }

}
