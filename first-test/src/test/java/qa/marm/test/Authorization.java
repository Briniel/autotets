package qa.marm.test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Elements.CarryFile.Carry;
import static Elements.CheckingOS.GiveDriver;
import static Elements.elementsScreens.LoginButton;
import static Elements.elementsScreens.elementWelcome;

public class Authorization {
    public static WebDriver driver;

    @BeforeSuite
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", GiveDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://dev.client-3.1.0-blackhole-v1d3.marm.altarix.org/Login");


        System.out.println(driver.findElements(By.xpath("//h1[text()='502 Bad Gateway']")).size());
    }

    //Авторизация
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void Login() throws Exception {
        LoginButton().click();
        elementWelcome().isDisplayed();
    }

    @AfterSuite
    public static void tearDown() throws IOException {
        Carry();
        driver.quit();
    }
}
