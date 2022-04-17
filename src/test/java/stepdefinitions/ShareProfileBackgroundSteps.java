package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.Page;

public class ShareProfileBackgroundSteps extends Page {
    @Given("user clicks profile icon")
    public void userClicksProfileIcon(){
        getSharePage().clickProfileIcon();
    }

    @And("clicks share button")
    public void clicksShareButton() {
        getSharePage().clickShareBtn();
    }

    @Then("Share modal is displayed")
    public void shareModalIsDisplayed() {
        Assert.assertTrue(getSharePage().isPopupDisplayed());
    }
}
