package de.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static String baseURL = PropertiesLoader.loadProperty("url");

    @FindBy(css = "[data-accept-action='all']")
    WebElement acceptButton;

    public HomePage acceptCoockies() {
        if ($(acceptButton).exists()) {
            $(acceptButton).click();
        }
        return Selenide.page(this);
    }

    @FindBy(css = ".headerElement--login")
    WebElement loginIcon;

    public LoginPage clickOnLoginIcon() {
        $(loginIcon).click();

        return Selenide.page(LoginPage.class);
    }

    @FindBy(css = ".headerElement__status--login")
    WebElement nameStatus;

    public SelenideElement userNameStatus() {
        return $(nameStatus).should(exist);
    }
}
