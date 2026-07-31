package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SampleAppTest extends BaseTest {

    @Test (groups = {"smoke", "regression"})
    public void testSampleApp(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test_user", "pwd");
        Assert.assertEquals(loginPage.getStatus(), "Welcome, test_user!");

    }

}
