package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class LoginSteps extends Page {
    @Given("user is in login page")
    public void user_is_in_login_page(){
        getLoginPage().clickLoginBtn();
    }

    @When("user Enters {string} and {string}")
    public void user_Enters_And(String email, String password) {
        getLoginPage().setUserEmail(email);
        getLoginPage().setPassword(password);
    }

    @And("click Login Button")
    public void click_Login_Button(){
        getLoginPage().clickLogin();
    }

    @Then("Home Page is visible")
    public void Home_Page_is_visible(){
        Assert.assertTrue(getLoginPage().isLoggedIn());
    }

}
