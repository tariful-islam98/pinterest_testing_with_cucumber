package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static core.WebConnector.driver;

public class SignupPage {
    private By signupBtnPath = By.xpath("//div[@data-test-id=\"simple-signup-button\"]/button");//get signup button
    private By userEmailField = By.id("email");
    private By userPasswordField = By.id("password");
    private By useAgeField = By.id("age");
    private By signupBtn = By.xpath("//div[@data-test-id=\"registerFormSubmitButton\"]/button");
    private By profileId = By.xpath("//div[@data-test-id=\"header-profile\"]");

    private By successfulMsg = By.xpath("//*[contains(text(),\"Welcome to Pinterest\")]");//path for getting welcome message
    private By nextBtnLnk = By.xpath("//div[@data-test-id=\"nux_name_done_btn\"]/button");//path for getting the button to go next step
    private By genderMsg = By.xpath("//*[contains(text(),\"How do you identify?\")]");
    private By genderSelectBtn = By.xpath("//input[@id=\"male\"]");//path to select a gender option
    private By countryChoiceNxtBtn = By.xpath("//div[@data-test-id=\"nux-locale-country-next-btn\"]/button");//path for getting the button to go next step after choosing country

    private By topicDoneBtn = By.xpath("//div[@data-test-id=\"nux-picker-done-btn\"]/button");//path for getting 'Done' button after selecting topics

    private By qrDoneBtn = By.xpath("//div[@data-test-id=\"nux-qr-code-done-btn\"]/button");
    private By saveBtn = By.xpath("//button[@aria-label=\"Save button\"]");
    public SignupPage(Page page) {
    }

    public void clickSignup(){
        driver.findElement(signupBtnPath).click();
//        return new SignupPage(driver);
    }

    public void setUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setPassword(String userPassword){
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }

    public void setAge(String age){
        driver.findElement(useAgeField).sendKeys(age);
    }

    /**
     * TC_3.1
     * login with email and password
     * @return to Signup completion process
     */
    public void clickContinueBtn() {
        driver.findElement(signupBtn).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
//        return new SignedUpPage(driver);
    }

    public void clickNextBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtnLnk));
        driver.findElement(nextBtnLnk).click();
    }

    public void selectGenderBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderMsg));
        driver.findElement(genderSelectBtn).click();
    }

    public void clickCountryPageNxtBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryChoiceNxtBtn));
        driver.findElement(countryChoiceNxtBtn).click();
    }

    /**
     * select 5 topics to go to the next step
     */
    public void selectTopic() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id=\"nux-picker-topic\"]")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-test-id=\"nux-picker-topic\"]"));

        for (int i=0; i<5; i++){
            elements.get(i).click();
        }
    }

    /**
     * after selecting topics click 'Done'
     */
    public void clickTopicDoneBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(topicDoneBtn));
        driver.findElement(topicDoneBtn).click();
    }

    public void clickQrDoneBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(qrDoneBtn));
        driver.findElement(qrDoneBtn).click();
    }

    public void clickSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
//        return new LoggedInHomePage(driver);
    }

    public boolean isSignedup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileId));
        return driver.findElement(profileId).isDisplayed();

    }
}
