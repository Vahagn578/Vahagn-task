package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CreateProjectPage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.SettingsPage;

public class BaseTest {
    public static final String BASE_URL = "https://picsart.com";
    protected static WebDriver driver;
    protected static final Logger log = LogManager.getLogger();
    protected LoginPage loginPage;
    protected CreateProjectPage createProjectPage;
    protected ProjectPage projectPage;
    protected SettingsPage settingsPage;
    protected Actions actions;
    protected SoftAssert softAssert;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/base/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true, description = "before method")
    public void setup() {
        log.info("Setup environment");
        driver = getDriver();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        createProjectPage = new CreateProjectPage(driver);
        projectPage = new ProjectPage(driver);
        settingsPage = new SettingsPage(driver);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        loginPage.loginViaUI();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Close browser and finish the test");
        driver.quit();
        driver = null;
    }
}
