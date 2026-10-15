package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(){
        boolean isCi = "true".equalsIgnoreCase(System.getenv("CI"));
        String browser = System.getProperty("browser", "chrome");
        DriverManager.getDriver("chrome", isCi);
    }

    @After
    public void tearDown(){
        DriverManager.quitDriver();
    }

}
