package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@data-testid='header-authActions-sign-btn']")
    private WebElement loginOrSignUpButton;

    @FindBy(xpath = "//button[@aria-label='Sign in with Email']")
    private WebElement loginWithEmailButton;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    private final String userEmail = "vahagngharibyan62@gmail.com";
    private final String userPassword = "Qw123456";
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginViaUI() {
        click(loginOrSignUpButton);
        click(loginWithEmailButton);
        sendKeys(email, userEmail);
        click(continueButton);
        sendKeys(password, userPassword);
        click(loginButton);
        click(acceptCookies);
    }
}
