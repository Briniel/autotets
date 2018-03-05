package qa.marm.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static Elements.CheckingOS.CheckingMyOS;
import static Elements.elementsScreens.*;


public class FirstTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", CheckingMyOS());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://dev.client-3.1.0-blackhole-v1d3.marm.altarix.org/Login");
    }

    /*Авторизация*/
    @Test(priority=1)
    public void Login(){
        LoginButton().click();
        elementWelcome().isDisplayed();
    }

    /*Открытие бокового меню и переход в раздел Button*/
    @Test(priority=2)
    public void MenuLeft(){
        leftMenuButton().click();
        leftMenu().isDisplayed();
        VisualButton().click();
        MenuButton().click();
    }

    /*Проверка наличия всех элементов на экране*/
    @Test(priority=3)
    public void ScreenButtonCheck(){
        //"Экран Button"
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

    /*Проверка функционала*/
    @Test(priority = 4)
    public void CheckMainButton(){
        //Смена текста визуального компонента
        Title2().click();
        if (mainButton().getText().equals("TITLEWORK")){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
        }

        //Возврат текста визуального компонента
        Title1().click();
        if (mainButton().getText().equals("BUTTON")){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
        }

        //Скрытие визуального компонента
        VisibilityFalse().click();
        try {
            if (mainButton().isDisplayed()){
                Assert.assertFalse(true);
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }

        //Отображение компонента
        VisibilityTrue().click();
        mainButton().isDisplayed();

        //Выравнивание по левому краю
        AlignLeft().click();
        if (mainButton().getAttribute("style").contains("left")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

        //Выравнивание по центру
        AlignCenter().click();
        if (mainButton().getAttribute("style").contains("center")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

        //Выравнивание по правому краю
        AlignRight().click();
        if (mainButton().getAttribute("style").contains("right")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

        //Проверка стилей
        if (themeStyle().getAttribute("style").contains("text-align: center")&
                themeStyle().getAttribute("style").contains("border-radius: 5px")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

        if (nameStyle().getAttribute("style").contains("text-align: left")&
                nameStyle().getAttribute("style").contains("background-color: rgb(248, 206, 204)")&
                nameStyle().getAttribute("style").contains("border: 1px solid rgb(184, 84, 80)")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }

        if (inlineStyle().getAttribute("style").contains("text-align: right")&
                inlineStyle().getAttribute("style").contains("background-color: rgb(255, 242, 204)")&
                inlineStyle().getAttribute("style").contains("border: 1px solid rgb(224, 198, 122)")&
                inlineStyle().getAttribute("style").contains("border-radius: 50px")&
                inlineStyle().findElement(By.xpath("//span[contains(text(),'inlineStyle')]")).getAttribute("style").contains("font-style: italic")&
                inlineStyle().findElement(By.xpath("//span[contains(text(),'inlineStyle')]")).getAttribute("style").contains("color: rgb(204, 0, 0)")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }
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
