package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.DriverManager;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    @Given("I am on the sample app page")
    public void openPage(){
        DriverManager.getDriver().get("http://uitestingplayground.com/sampleapp");
    }

    @When("I log in with username {string} and password {string}")
    public void login(String username, String password){
        DriverManager.getDriver().findElement(By.name("UserName")).sendKeys(username);
        DriverManager.getDriver().findElement(By.name("Password")).sendKeys(password);
        DriverManager.getDriver().findElement(By.id("login")).click();
    }

    @Then("I should see {string}")
    public void verifyMessage(String expectedMessage){
        String actual = DriverManager.getDriver().findElement(By.id("loginstatus")).getText();
        assertTrue(actual.contains(expectedMessage));
    }

}
