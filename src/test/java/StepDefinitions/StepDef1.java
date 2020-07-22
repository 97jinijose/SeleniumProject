package StepDefinitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import com.frameworkfromscratch.com.fullStack.FirstPage;
import com.frameworkfromscratch.com.fullStack.Login;
import com.frameworkfromscratch.com.fullStack.LoginPage;

@RunWith(Cucumber.class)
public class StepDef1 extends Login {
@Given("^Initialize the browser with chrome$")
public void initialize_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	driver = broswerDetails();
}

@Given("^Navigate to \"([^\"]*)\" Site$")
public void navigate_to_Site(String url) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	driver.get(url);
}

@Given("^Click on Login link in home page to land on Secure sign in Page$")
public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	
	FirstPage first = new FirstPage(driver);
	if(first.getPopUpSize().size()>0)
	{
		first.getPopUp().click();
	}
	first.getLink().click();
}

//@When("^User enters test(\\d+)@gmail\\.com and (\\d+) and logs in$")
@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_test_gmail_com_and_and_logs_in(String username, String password) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	LoginPage login = new LoginPage(driver);
	login.getEmail().sendKeys(username);
	login.getPassword().sendKeys(password);
	login.clickLogInButton().click();
	
}

@Then("^Verify that user is succesfully logged in$")
public void verify_that_user_is_succesfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@Then("^close browsers$")
public void close_browsers() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	driver.quit();
}


}
