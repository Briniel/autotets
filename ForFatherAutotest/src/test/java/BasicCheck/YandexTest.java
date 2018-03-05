package BasicCheck;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static BackgroundClasses.CheckingOS.CheckingMyOS;
import static BackgroundClasses.ElementsScreens.*;

public class YandexTest {

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", CheckingMyOS());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }


    @Test
    public void Login(){
        Search().sendKeys("Selenium");
        ButtonSearch().click();
        int resul = ResultSearch().getSize().height;
        if (resul == 0){
            System.out.print("По запросу ничего не найдено");
            Assert.assertFalse(true);
        } else {
            System.out.println("По запросу найдено "+ResultSearch().getSize().height);
        }
    }


}
