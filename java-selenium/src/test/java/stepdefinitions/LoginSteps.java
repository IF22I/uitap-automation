package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {

    @Given("I am on the sample app page")
    public void openPage(){
        Hooks.driver.get("http://uitestingplayground.com/sampleapp");
    }

    @When("I log in with username {string} and password {string}")
    public void login(String username, String password){
        Hooks.driver.findElement(By.name("UserName")).sendKeys(username);
        Hooks.driver.findElement(By.name("Password")).sendKeys(password);
        Hooks.driver.findElement(By.id("login")).click();
    }

    @Then("I should see {string}")
    public void verifyMessage(String expectedMessage){
        String actual = Hooks.driver.findElement(By.id("loginstatus")).getText();
        assertTrue(actual.contains(expectedMessage));
    }

}
