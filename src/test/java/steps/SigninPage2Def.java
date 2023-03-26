package steps;

import config.UserConfig;
import io.cucumber.java.en.Then;
import pages.SigninPage2;

public class SigninPage2Def {

    SigninPage2 signinPage2 = new SigninPage2();

    @Then("Input login")
    public void inputLogin() {
        signinPage2.inputLogin(UserConfig.USER_LOGIN);
    }

    @Then("Input password")
    public void inputPassword() {
        signinPage2.inputPassword(UserConfig.USER_PASSWORD);
    }
}
