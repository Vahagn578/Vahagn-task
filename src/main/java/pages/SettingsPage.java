package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends BasePage {
    @FindBy(id = "upload-avatar")
    private WebElement uploadAvatar;

    @FindBy(xpath = "//button[@data-test='save-changes-button']")
    private WebElement saveChanges;

    @FindBy(xpath = "//p[contains(@class,'user-avatar-description')]")
    private WebElement uploadText;

    @FindBy(css = ".account-saveChanges-0-2-76.account-disabledButton-0-2-77")
    private WebElement disabledSaveButton;

    @FindBy(xpath = "//img[contains(@src,'data:image')]")
    private WebElement uploadedImageElement;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void uploadPicture() {
        wait.until(ExpectedConditions.visibilityOf(uploadText));
        uploadAvatar.sendKeys("/home/vahagn/code/Vahagn-task/src/main/resources/test.png");
    }

    public boolean isSaveButtonDisabled() {
        return disabledSaveButton.isDisplayed();
    }

    public String getUploadImageText() {
        return getElementText(uploadText);
    }

    public String getSaveButtonText() {
        return getElementText(saveChanges);
    }

    public void save() {
        wait.until(ExpectedConditions.elementToBeClickable(saveChanges));
        click(saveChanges);
    }

    public WebElement imageUploaded() {
        wait.until(ExpectedConditions.visibilityOf(uploadedImageElement));
        return uploadedImageElement;
    }
}
