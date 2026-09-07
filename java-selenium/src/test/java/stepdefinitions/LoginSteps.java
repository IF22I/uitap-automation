package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.DriverManager;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the sample app page")
    public void openPage(){
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.open();
    }

    @When("I log in with username {string} and password {string}")
    public void login(String username, String password){
        loginPage.enterCredentials(username, password);
        loginPage.clickLogin();
    }

    @Then("I should see {string}")
    public void verifyMessage(String expectedMessage){
        String actual = loginPage.getStatus();
        assertTrue(actual.contains(expectedMessage));
    }

}
