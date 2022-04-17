package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class ProfileShareSteps extends Page {
    @Given("user clicks email input field")
    public void userClicksEmailInputField() {
        getSharePage().clickInputField();
    }

    @And("types the {string} address")
    public void typesTheAddress(String email) {
        getSharePage().typeEmail(email);
    }

    @And("selects contact to share")
    public void selectsContactToShare() {
        getSharePage().selectContact();
    }

    @And("writes {string} to share")
    public void writesToShare(String msg) {
        getSharePage().writeMessage(msg);
    }

    @And("clicks send button")
    public void clicksSendButton() {
        getSharePage().clickSendBtn();
    }

    @Then("user is returned to share modal")
    public void userIsReturnedToShareModal() {
        Assert.assertTrue(getSharePage().isPopupDisplayed());
    }
}
