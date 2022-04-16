package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class FbLoginSteps extends Page {
    @Given("user is in Login page")
    public void user_is_in_Login_page(){
        getFbLoginPage().clickLoginBtn();
    }

    @When("user clicks continue with facebook button")
    public void user_clicks_continue_with_facebook_button() {
        getFbLoginPage().clickFbLoginBtn();
    }

    @Then("Facebook login window appears")
    public void facebook_login_window_appears() {
        Assert.assertEquals(getFbLoginPage().isWindowOpened(), "Facebook");
    }
}
