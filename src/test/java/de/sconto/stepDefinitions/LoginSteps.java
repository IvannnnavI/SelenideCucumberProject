package de.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import de.sconto.pages.CustomerAccountPage;
import de.sconto.pages.HomePage;
import de.sconto.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    HomePage home;
    LoginPage login;
    CustomerAccountPage customer;

    @When("User clicks on Login icon")
    public void click_on_User_icon(){
        home = Selenide.page(HomePage.class);
        login = home.clickOnLoginIcon();
    }
    @Then("User verifies Login form")
    public void verifyLoginForm() {
        login.loginformTitle();
    }

    @When("User enters valid data")
    public void enter_valid_data(){
        login.validLoginInput();
    }
    @And("User clicks on Anmelden button")
    public void clickOnAnmeldenButton(){
        login.clickOnAnmelden();
    }
    @Then("User verifies user name status")
    public void verify_user_name_status(){
        home.userNameStatus();
    }

    @Then("User verifies user name")
    public void verify_User_Name(){
        customer = Selenide.page(CustomerAccountPage.class);
        customer.userName("James Bond");

    }
    @When("User enters valid email and invalid password")
    public void enters_valid_email_and_invalid_password(){
        login.loginWithInvalidPassword();
    }
    @Then("User verifyes Error Message is displayed")
    public void verify_Error_Message_is_Displayed(){
        login.isErrorMessagePresent();
    }


}
