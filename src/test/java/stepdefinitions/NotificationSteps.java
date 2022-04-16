package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Page;

public class NotificationSteps extends Page {
    @Given("user clicks notification icon")
    public void userClicksNotificationIcon(){
        getNotificationPage().clickNotificationIcon();
    }

    @And("selects a notification")
    public void selectsANotification() {
        getNotificationPage().selectNotification();
    }

    @Then("notification detail page loaded")
    public void notificationDetailPageLoaded() {
        String expectedUrl = "https://www.pinterest.com/news_hub/"+getNotificationPage().getNotificationId();
        Assert.assertEquals(currentUrl(), expectedUrl);
    }
}
