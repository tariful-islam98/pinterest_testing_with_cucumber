package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class BackgroundSteps extends Page {
    @Given("User is in Login page")
    public void userIsInLoginPage(){
        getLoginPage().clickLoginBtn();
    }

    @When("User Enters Email and Password")
    public void userEntersEmailAndPassword() {
        getLoginPage().setUserEmail("vespimerka6@vusra.com");
        getLoginPage().setPassword("121212A");
    }

    @And("clicks Login Button")
    public void clicksLoginButton() {
        getLoginPage().clickLogin();
    }

    @Then("Home Page is Visible")
    public void homePageIsVisible() {
        Assert.assertTrue(getLoginPage().isLoggedIn());
    }
}
