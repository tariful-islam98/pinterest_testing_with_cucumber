package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class ProfileEditSteps extends Page {
    @Given("User clicks profile icon")
    public void userClicksProfileIcon(){
        getEditPage().clickProfileIcon();
    }

    @And("clicks edit profile button")
    public void clicksEditProfileButton() {
        getEditPage().clickEditProfile();
    }

    @When("user clicks last name field")
    public void userClicksLastNameField() {
        getEditPage().clickLastNameField();
    }


    @And("user sets {string}")
    public void userSets(String lastname) {
        getEditPage().enterLastName(lastname);
    }

    @And("clicks profile save button")
    public void clicksProfileSaveButton() {
        getEditPage().clickSaveButton();
    }

    @Then("user profile gets updated")
    public void userProfileGetsUpdated() {
        Assert.assertTrue(getEditPage().isEdited());
    }
}
