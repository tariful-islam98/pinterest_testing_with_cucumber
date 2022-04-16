package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Page;

public class MessagesSteps extends Page {
    @Given("User clicks message icon")
    public void userClicksMessageIcon(){
        getInboxPage().clickMsgIcon();
    }

    @And("user clicks new message button")
    public void userClicksNewMessageButton() {
        getInboxPage().clickNewMsgBtn();
    }

    @When("user enters {string}")
    public void userEnters(String email) {
        getInboxPage().inputEmail(email);
    }

    @And("selects an email")
    public void selectsAnEmail() {
        getInboxPage().selectContact();
    }

    @And("types {string}")
    public void types(String msg) {
        getInboxPage().typeMessage(msg);
    }

    @And("clicks send")
    public void clicksSend() {
        getInboxPage().clickSendButton();
    }

    @Then("message is sent")
    public void messageIsSent() {
        Assert.assertTrue(getInboxPage().isSent());
    }
}
