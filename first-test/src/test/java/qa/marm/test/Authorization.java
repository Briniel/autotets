package qa.marm.test;

import TestClass.LoginScreen;
import TestClass.MainScreen;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Elements.CarryFile.Carry;
import static Elements.CheckingOS.GiveDriver;

@Feature("Authorization")
public class Authorization {
    public static WebDriver driver;
    private LoginScreen loginScreen;
    public MainScreen mainScreen;


    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", GiveDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://dev.client-3.1.0-blackhole-v1d3.marm.altarix.org/Login");
        loginScreen = new LoginScreen(driver);
        mainScreen = new MainScreen(driver);

    }

    @Test(groups = "authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Authorization in Blackhole")
    public void Login() throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, 60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginScreen.blackholeText));
        saveScreenshot();
        loginScreen.clickLoginButton();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginScreen.welcome));
    }

    @Test(dependsOnMethods = "Login", alwaysRun = true, groups = "authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check authorization")
    public void CheckMainScreen(){
        WebDriverWait wait = (new WebDriverWait(driver, 60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainScreen.welcome));
        saveScreenshot();
    }

//    @AfterSuite
//    public static void tearDown() throws IOException {
//        Carry();
//        driver.quit();
//    }
}
