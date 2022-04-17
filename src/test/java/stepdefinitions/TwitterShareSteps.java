package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class TwitterShareSteps extends Page{
    @Given("user clicks Twitter button")
    public void userClicksTwitterButton() {
        getTwitterPage().sharByTwitter();
    }

    @Then("Twitter window is opened")
    public void twitterWindowIsOpened() {
        Assert.assertTrue(getTwitterPage().isTabOpened());
    }
}
