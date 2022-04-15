package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class SignupSteps extends Page {
    @Given("user is in signup page")
    public void user_is_in_signup_page(){
        getSignupPage().clickSignup();
    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_And(String email, String password, String age) {
        getSignupPage().setUserEmail(email);
        getSignupPage().setPassword(password);
        getSignupPage().setAge(age);
    }

    @And("clicks continue button")
    public void clicks_continue_button() {
        getSignupPage().clickContinueBtn();
    }

    @And("clicks next button")
    public void clicks_next_button() {
        getSignupPage().clickNextBtn();
    }

    @And("selects a gender")
    public void selects_a_gender() {
        getSignupPage().selectGenderBtn();
    }

    @And("clicks next again")
    public void clicks_next_again() {
        getSignupPage().clickCountryPageNxtBtn();
    }

    @And("selects topics")
    public void selects_topics() {
        getSignupPage().selectTopic();
    }

    @And("clicks done button")
    public void clicks_done_button() {
        getSignupPage().clickTopicDoneBtn();
    }

    @And("clicks done button again")
    public void clicks_done_button_again() {
        getSignupPage().clickQrDoneBtn();
    }

    @And("clicks save button")
    public void clicks_save_button() {
        getSignupPage().clickSaveBtn();
    }

    @Then("home is visible")
    public void home_is_visible() {
        Assert.assertTrue(getSignupPage().isSignedup());
    }
}
