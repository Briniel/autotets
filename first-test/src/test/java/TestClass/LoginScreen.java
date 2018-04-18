package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginScreen {
    private WebDriver driver;

    public LoginScreen(WebDriver driver){
        this.driver = driver;
    }

    private By userField = By.xpath("//*[@id=\"username\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.xpath("//*[@id=\"login_button\"]");
    public By blackholeText = By.xpath("//*[@id=\"blackhole\"]");
    public By welcome = By.xpath("//span[text()='Добро пожаловать в']");

    public LoginScreen clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }


}
