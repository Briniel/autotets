package qa.marm.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Elements.elementsScreens.*;


public class FirstTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/user/po/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://dev.client-3.1.0-blackhole-v1d3.marm.altarix.org/Login");

    }

    @Test
    public void Login(){
        LoginButton().click();
        elementWelcome().isDisplayed();
    }

    @Test
    public void MenuLeft(){
        leftMenuButton().click();
        leftMenu().isDisplayed();
        VisualButton().click();
        MenuButton().click();
        infoAccord().isDisplayed();
        mainButton().isDisplayed();
        Title1().isDisplayed();
        Title2().isDisplayed();
        VisibilityTrue().isDisplayed();
        VisibilityFalse().isDisplayed();
        AlignLeft().isDisplayed();
        AlignCenter().isDisplayed();
        AlignRight().isDisplayed();
        Styles().click();
        themeStyle().isDisplayed();
        nameStyle().isDisplayed();
        inlineStyle().isDisplayed();

    }


    /*@AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }*/
}
