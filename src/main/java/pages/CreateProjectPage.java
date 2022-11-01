package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProjectPage extends BasePage{
    @FindBy(xpath = "//button[@data-testid='create-search-button']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//button[@data-test='modal-close']")
    private WebElement closeTrialModal;

    @FindBy(xpath = "//img[@title='User avatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//p[text()='Settings']")
    private WebElement settings;

    @FindBy(xpath = "//p[@data-test='create-search-text']")
    private WebElement createSearchElement;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public void closeTrialModal() {
        wait.until(ExpectedConditions.elementToBeClickable(closeTrialModal));
        click(closeTrialModal);
    }

    public void clickNewProjectButton() {
        click(createNewProjectButton);
    }

    public boolean isUserAvatarDisplayed() {
        return userAvatar.isDisplayed();
    }

    public String getBannerText() {
        return getElementText(createSearchElement);
    }

    public String getNewProjectButtonText() {
        return getElementText(createNewProjectButton);
    }
    public void navigateToSettingsPage(Actions actions) {
        wait.until(ExpectedConditions.visibilityOf(userAvatar));
        actions.moveToElement(userAvatar).perform();
        actions.moveToElement(settings).click().perform();
    }
}
