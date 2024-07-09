package de.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static final String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static final String validPassword = PropertiesLoader.loadProperty("valid.password");
    public static final String invalidPassword = PropertiesLoader.loadProperty("invalid.password");

    @FindBy(css = ".existingAccount__headline")
    WebElement loginFormTitle;

    public SelenideElement loginformTitle() {
        return $(loginFormTitle).should(exist);
    }

    @FindBy(id = "loginEmail")
    WebElement emailInput;
    @FindBy(id = "loginPassword")
    WebElement passwordInput;

    public LoginPage validLoginInput() {

        $(emailInput).val(validEmail);
        $(passwordInput).val(validPassword);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "login-submit")
    WebElement anmeledenButton;

    public LoginPage clickOnAnmelden() {
        $(anmeledenButton).click();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage loginWithInvalidPassword() {
        $(emailInput).shouldBe(visible).val(validEmail);
        $(passwordInput).clear();
        $(passwordInput).val(invalidPassword);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id="loginEmail-error")
    WebElement errorMessage;

    public SelenideElement isErrorMessagePresent() {
        return $(errorMessage).should(exist);
    }
}
