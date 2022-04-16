package stepdefinitions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import io.cucumber.java.en.*;

public class FbSignupSteps extends Page {
    @Given("user is in Signup page")
    public void user_is_in_Signup_page(){
        getFbSignupPage().clickSignup();
    }

    @When("User clicks continue with facebook button")
    public void User_clicks_continue_with_facebook_button(){
        getFbSignupPage().clickFbBtn2();
    }

    @Then("Facebook Login window appears")
    public void Facebook_Login_window_appears(){
        Assert.assertEquals(getFbSignupPage().isFbSignupWindowOpened(), "Facebook");
    }
}
