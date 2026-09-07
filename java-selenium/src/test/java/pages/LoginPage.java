package pages;

import config.Config;
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

        public void open (){
            goTo(Config.BASE_URL + "/sampleapp");
        }

        public void enterCredentials(String username, String password){
            driver.findElement(usernameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLogin(){
            driver.findElement(loginButton).click();
        }

        public  void  login(String username, String password){
            open();
            enterCredentials(username, password);
            clickLogin();
        }

        public String getStatus(){
            return driver.findElement(statusMessage).getText();
        }

}
