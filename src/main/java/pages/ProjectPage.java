package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class ProjectPage extends BasePage{
    @FindBy(id = "layout-category")
    private WebElement layoutCategory;

    @FindBy(xpath = "//button[@data-testid='hints-close']")
    private WebElement closeHints;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void closeHints() {
        wait.until(ExpectedConditions.elementToBeClickable(closeHints));
        click(closeHints);
    }

    public void handleTabs() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public boolean isLayoutCategorySelectedByDefault() {
        return layoutCategory.getAttribute("className").contains("active");
    }
}
