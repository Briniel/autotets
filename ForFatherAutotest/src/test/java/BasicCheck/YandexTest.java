package BasicCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static BackgroundClasses.CheckingOS.CheckingMyOS;
import static BackgroundClasses.ElementsScreens.*;

public class YandexTest {


    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", CheckingMyOS());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }


    @Test(priority=1)
    public void Login(){
        Search().sendKeys("Selenium");
        ButtonSearch().click();
        if (ResultSearch().getSize().height == 0){
            System.out.print("По запросу ничего не найдено");
        } else {
            System.out.print("По запросу ничего найдено "+ResultSearch().getSize().height);
        }
    }


}
