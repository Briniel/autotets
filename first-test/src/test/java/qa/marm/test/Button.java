package qa.marm.test;

import TestClass.ButtonScreen;
import TestClass.MainScreen;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static qa.marm.test.Authorization.driver;


@Feature("Test Button")
public class Button {

    private MainScreen mainScreen;
    private ButtonScreen buttonScreen;


    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(groups = "button")
    @Description("Go to screen Button")
    public void MenuLeft(){
        WebDriverWait wait = (new WebDriverWait(driver, 60));
        mainScreen = new MainScreen(driver);
        mainScreen.clickLeftMenu();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainScreen.visualElements));
        driver.findElement(mainScreen.visualElements).isDisplayed();
//        mainScreen.clickVisualElements();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainScreen.buttonMenu));
        driver.findElement(mainScreen.buttonMenu).isDisplayed();
        saveScreenshot();
        mainScreen.clickButtonMenu();
    }

    @Test(dependsOnMethods = "MenuLeft", groups = "button")
    @Description("Check Button")
    public void CheckButton(){
        buttonScreen = new ButtonScreen(driver);
        SoftAssert s = new SoftAssert();
        buttonScreen.clickMainButton();
        s.assertTrue(buttonScreen.getNameButton().equals("BUTTON"), "Проверка название кнопки");
        s.assertTrue(buttonScreen.getStyleButton().contains("background-color: rgb(218, 232, 252)"), "Проверка цвета фона кнопки");
        s.assertTrue(buttonScreen.getStyleButton().contains("border: 1px solid rgb(108, 142, 191)"), "Проверка цвета рамки кнопки");
        s.assertTrue(buttonScreen.getStyleButton().contains("border-radius: 5px"), "Проверка скругления кнопки");
        s.assertTrue(buttonScreen.getStyleButton().contains("center"), "Проверка выравнивания текста по центру");
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckButton", priority = 1, groups = "button")
    @Description("Checking onClick")
    public void ChecfOnClick(){
        WebDriverWait wait = (new WebDriverWait(driver, 60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(buttonScreen.onClick));
        buttonScreen.clickMainButton();
        Assert.assertTrue(buttonScreen.getTextOnClick().contains("onClick"), "Проверка onClick");
        saveScreenshot();
    }

    @Test(dependsOnMethods = "CheckButton", priority = 2, groups = "button")
    @Description("Checking the change of the name of the button")
    public void CheckTitle2(){
        SoftAssert s = new SoftAssert();
        buttonScreen.clickTitle2Button();
        s.assertTrue(buttonScreen.getNameButton().equals("TITLEWORK"), "Проверка изменении название кнопки на TITLEWORK");
        saveScreenshot();
        buttonScreen.clickTitle1Button();
        s.assertTrue(buttonScreen.getNameButton().equals("BUTTON"), "Проверка изменении название кнопки на BUTTON");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckButton", priority = 3, groups = "button")
    @Description("Checking the button's display")
    public void CheckDisplayButton(){
        SoftAssert s = new SoftAssert();
        buttonScreen.clickVisibilityFalse();
        s.assertTrue(buttonScreen.getSizeButton() == 0, "Проверка что кнопка исчезла");
        saveScreenshot();
        buttonScreen.clickVisibilityTrue();
        s.assertTrue(buttonScreen.getSizeButton() > 0, "Проверка что кнопка появилась");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckButton", priority = 4, groups = "button")
    @Description("Check for changing the button name alignment")
    public void CheckButtonNameAlignment(){
        SoftAssert s = new SoftAssert();
        buttonScreen.clickAlignLeft();
        s.assertTrue(buttonScreen.getStyleButton().contains("left"), "Проверка выравнивания текста по левому краю");
        saveScreenshot();
        buttonScreen.clickAlignCenter();
        s.assertTrue(buttonScreen.getStyleButton().contains("center"), "Проверка выравнивания текста по центру");
        saveScreenshot();
        buttonScreen.clickAlignRight();
        s.assertTrue(buttonScreen.getStyleButton().contains("right"), "Проверка выравнивания текста по правому краю");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckButton", priority = 5, groups = "button")
    @Description("Check acord")
    public void CheckAcord(){
        SoftAssert s = new SoftAssert();
        buttonScreen.clickAcord();
        s.assertTrue(buttonScreen.getNameThemeStyle().equals("THEMESTYLE"), "Проверка название кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getStyleThemeStyle().contains("background-color: rgb(218, 232, 252)"), "Проверка цвета фона кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getStyleThemeStyle().contains("border: 1px solid rgb(108, 142, 191)"), "Проверка цвета рамки кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getStyleThemeStyle().contains("border-radius: 5px"), "Проверка скругления кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getStyleThemeStyle().contains("center"), "Проверка выравнивания текста по центру кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getTextThemeStyle().contains("font-style: normal"), "Проверка стиль текста кнопки THEMESTYLE");
        s.assertTrue(buttonScreen.getTextThemeStyle().contains("color: black"), "Проверка цвет текста кнопки THEMESTYLE");

        s.assertTrue(buttonScreen.getNameNameStyle().equals("NAMESTYLE"), "Проверка название кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getStyleNameStyle().contains("background-color: rgb(248, 206, 204)"), "Проверка цвета фона кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getStyleNameStyle().contains("border: 1px solid rgb(184, 84, 80)"), "Проверка цвета рамки кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getStyleNameStyle().contains("border-radius: 0px"), "Проверка скругления кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getStyleNameStyle().contains("left"), "Проверка выравнивания текста по левому краю кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getTextNameStyle().contains("font-style: normal"), "Проверка стиль текста кнопки NAMESTYLE");
        s.assertTrue(buttonScreen.getTextNameStyle().contains("color: black"), "Проверка цвет текста кнопки NAMESTYLE");

        s.assertTrue(buttonScreen.getNameInlineStyle().equals("INLINESTYLE"), "Проверка название кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getStyleInlineStyle().contains("background-color: rgb(255, 242, 204)"), "Проверка цвета фона кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getStyleInlineStyle().contains("border: 1px solid rgb(224, 198, 122)"), "Проверка цвета рамки кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getStyleInlineStyle().contains("border-radius: 50px"), "Проверка скругления кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getStyleInlineStyle().contains("right"), "Проверка выравнивания текста по правому краю кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getTextInlineStyle().contains("font-style: italic"), "Проверка стиль текста кнопки INLINESTYLE");
        s.assertTrue(buttonScreen.getTextInlineStyle().contains("color: rgb(204, 0, 0)"), "Проверка цвет текста кнопки INLINESTYLE");
        s.assertAll();
    }

}
