package qa.marm.test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Elements.CarryFile.Carry;
import static Elements.CheckingOS.GiveDriver;
import static Elements.ScreenShot.screen;
import static Elements.elementsScreens.*;


public class FirstTest {

    public static WebDriver driver;


    @BeforeSuite
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", GiveDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://dev.client-3.1.0-blackhole-v1d3.marm.altarix.org/Login");
    }

    /*Авторизация*/
    @Test(priority = 1)
    public void Login() throws Exception {
            screen("AuthorizationScreen");
            LoginButton().click();
            elementWelcome().isDisplayed();
    }

    /*Открытие бокового меню и переход в раздел Button*/
    @Test(priority = 2)
    public void MenuLeft() throws Exception {
            screen("MainScreen");
            leftMenuButton().click();
            leftMenu().isDisplayed();
            VisualButton().click();
            screen("leftMenuButtonScreen");
            MenuButton().click();
    }

    /*Проверка наличия всех элементов на экране*/
    @Test(priority = 3)
    public void ScreenButtonCheck() throws Exception {
        //"Экран Button"
        screen("MainButtonScreenBefore");
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
        screen("MainButtonScreenBeforeAfter");
    }

    //Проверка визуальной части элемента
    @Test (priority = 4)
    public void CorrectDisplayOfAVisualElement() {
            Assert.assertTrue(mainButton().getAttribute("style").contains("background-color: rgb(218, 232, 252)"), "Проверка цвета фона кнопки");
            Assert.assertTrue(mainButton().getAttribute("style").contains("border: 1px solid rgb(108, 142, 191)"), "Проверка цвета рамки кнопки");
            Assert.assertTrue(mainButton().getAttribute("style").contains("border-radius: 5px"), "Проверка скругления кнопки");
    }

    //Проверка визуального отображения текста кнопки
    @Test (priority = 5)
    public void ChangeTheTextOfTheVisualElement() {
        Title2().click();
        Assert.assertTrue(mainButton().getText().equals("TITLEWORK"), "Проверка смены названия кнопки на TITLEWORK");
        Title1().click();
        Assert.assertTrue(mainButton().getText().equals("BUTTON"), "Проверка смены названия кнопки на BUTTON");
    }

    //Проверка скрытия кнопки
    @Test (priority = 6)
    public void ChangeTheVisibilityOfTheVisualElement() {
        VisibilityFalse().click();
        try {
            if (mainButton().isDisplayed()){
                Assert.assertFalse(true, "Конопка не скрыта");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
        VisibilityTrue().click();
        mainButton().isDisplayed();
    }

    //Проврека выравнивания текста
    @Test (priority = 7)
    public void AligningTheTextOfTheVisualElement() {
        AlignLeft().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("left"), "Проверка выравнивания текста по левому краю");
        AlignCenter().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("center"), "Проверка выравнивания текста по центру");
        AlignRight().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("right"), "Проверка выравнивания текста по правому краю");
    }

    /*Проверка функционала*/
    @Test(enabled = false)
    public void CheckMainButton() throws Exception {
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

        //Проверка всплывающего сообщения "onClick() Сработал!"
        mainButton().click();
        Thread.sleep(1000);
        if (onClick().getText().equals("onClick() Сработал!")){
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(true);
        }


    }

    @AfterSuite
    public static void tearDown() throws IOException {
        Carry();
        driver.quit();
    }
}
