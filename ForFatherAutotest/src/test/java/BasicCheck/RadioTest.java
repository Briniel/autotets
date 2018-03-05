package BasicCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static BackgroundClasses.CheckingOS.CheckingMyOS;
import static BackgroundClasses.ElementsScreens.*;

public class RadioTest {

    @BeforeClass
    public static void tolls(){
        System.setProperty("webdriver.chrome.driver", CheckingMyOS());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://player.rockfm.ru/");
    }


    @Test
    public void Tell(){
        CharchButton().click();
        System.out.println(Stick().findElements(By.tagName("li")));
    }
}
