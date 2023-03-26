package steps;

import io.cucumber.java.en.Then;
import pages.BasePage2;

public class BasePage2Def {
    BasePage2 basePage2 = new BasePage2();

    @Then("Click {string} button")
    public void clickButton(String arg0) {
        basePage2.clickButton(arg0);
    }

    @Then("Click second {string} button")
    public void clickSecondButton(String arg0) {
        basePage2.clickSecondButton(arg0);
    }
}
