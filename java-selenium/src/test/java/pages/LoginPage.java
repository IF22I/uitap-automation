package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


        private By usernameField = By.cssSelector("[name='UserName']");
        private By passwordField = By.cssSelector("[name='Password']");
        private By loginButton = By.id("login");
        private By statusMessage = By.id("loginstatus");

        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public  void  login(String username, String password){
            goTo("http://uitestingplayground.com/sampleapp");
            driver.findElement(usernameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }

        public String getStatus(){
            return driver.findElement(statusMessage).getText();
        }

}
