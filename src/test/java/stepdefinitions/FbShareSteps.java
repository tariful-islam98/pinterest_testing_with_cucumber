package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class FbShareSteps extends Page {
    @Given("user clicks Fb button")
    public void userClicksFbButton(){
        getWithFbPage().shareByFb();
    }

    @Then("Fb window is opened")
    public void fbWindowIsOpened() {
        Assert.assertTrue(getWithFbPage().isTabOpened());
    }
}
