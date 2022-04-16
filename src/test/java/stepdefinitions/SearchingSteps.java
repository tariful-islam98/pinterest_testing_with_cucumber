package stepdefinitions;

import org.testng.Assert;
import pages.Page;
import io.cucumber.java.en.*;

public class SearchingSteps extends Page {

    @Given("User is logged in with {string} and {string}")
    public void userIsLoggedInWithAnd(String email, String password) {
        getSearchPage().clickLoginBtn();
        getSearchPage().setUserEmail(email);
        getSearchPage().setPassword(password);
        getSearchPage().clickLogin();
    }

    @And("User is in Home Page")
    public void userIsInHomePage() {
        getSearchPage().loadHomePage();
    }

    @When("User clicks search box")
    public void userClicksSearchBox() {
        getSearchPage().clickSearchBox();
    }
    
    @And("types a {string}")
    public void typesA(String topic) {
        getSearchPage().enterText(topic);
    }

    @And("clicks Enter")
    public void clicksEnter() {
        getSearchPage().clickEnter();
    }

    @Then("System shows the result page")
    public void systemShowsTheResultPage() {
        Assert.assertEquals(getSearchPage().getCurrentUrl(), "https://www.pinterest.com/search/pins/?q=cricket&rs=typed&term_meta[]=cricket%7Ctyped");
    }

}
