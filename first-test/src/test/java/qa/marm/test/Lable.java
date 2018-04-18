package qa.marm.test;

import TestClass.LabelScreen;
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

@Feature("Test Lable")
public class Lable {

    private MainScreen mainScreen;
    private LabelScreen labelScreen;

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(groups = "lable")
    @Description("Go to screen Lable")
    public void MenuLeft(){
        WebDriverWait wait = (new WebDriverWait(driver, 25));
        mainScreen = new MainScreen(driver);
        mainScreen.clickLeftMenu();
        driver.findElement(mainScreen.visualElements).isDisplayed();
        mainScreen.clickVisualElements();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainScreen.labelMenu));
        saveScreenshot();
        mainScreen.clickLabelMenu();
    }

    @Test(dependsOnMethods = "MenuLeft", groups = "lable")
    @Description("Check Text")
    public void CheckMainText(){
        labelScreen = new LabelScreen(driver);
        SoftAssert s = new SoftAssert();
        s.assertTrue(labelScreen.getMainText().equals("Lorem ipsum dolor sit amet, consectetur adipisicing elit..."), "Проверка текста");
        s.assertTrue(labelScreen.getTitleText().equals("ПОДСКАЗКА!"), "Проверка подсказки");
        s.assertTrue(labelScreen.getStyleText().contains("text-align: center"), "Проверка выравнивания");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckMainText", priority = 1, groups = "lable")
    @Description("Check Value")
    public void CheckValue(){
        SoftAssert s = new SoftAssert();
        labelScreen.clickValue2Button();
        s.assertTrue(labelScreen.getMainText().equals("Duis aute irure dolor in reprehenderit in voluptate..."), "Проверка текста 2");
        saveScreenshot();
        labelScreen.clickValue1Button();
        s.assertTrue(labelScreen.getMainText().equals("Lorem ipsum dolor sit amet, consectetur adipisicing elit..."), "Проверка текста");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckMainText", priority = 2, groups = "lable")
    @Description("Checking the text's display")
    public void CheckDisplayText(){
        SoftAssert s = new SoftAssert();
        labelScreen.clickVisibilityFalseButton();
        saveScreenshot();
        s.assertTrue(labelScreen.getSizeLable() == 0, "Проверка что текст исчез");
        labelScreen.clickVisibilityTrueButton();
        saveScreenshot();
        s.assertTrue(labelScreen.getSizeLable() > 0, "Проверка что текст появился");
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckMainText", priority = 3, groups = "lable")
    @Description("Check for changing the text alignment")
    public void CheckTextAlignment(){
        SoftAssert s = new SoftAssert();
        labelScreen.clickAlignLeftButton();
        s.assertTrue(labelScreen.getStyleText().contains("left"), "Проверка выравнивания текста по левому краю");
        saveScreenshot();
        labelScreen.clickAlignCenterButton();
        s.assertTrue(labelScreen.getStyleText().contains("center"), "Проверка выравнивания текста по центру");
        saveScreenshot();
        labelScreen.clickAlignRightButton();
        s.assertTrue(labelScreen.getStyleText().contains("right"), "Проверка выравнивания текста по правому краю");
        saveScreenshot();
        s.assertAll();
    }

    @Test(dependsOnMethods = "CheckMainText", priority = 4, groups = "lable")
    @Description("Checking onClick")
    public void CheckOnClick() throws InterruptedException {
        labelScreen.clickText();
        WebDriverWait wait = (new WebDriverWait(driver, 60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelScreen.onClick));
        driver.findElement(labelScreen.onClick).isDisplayed();
        Thread.sleep(1000);
        Assert.assertTrue(labelScreen.getTextOnClick().contains("onClick"), "Проверка onClick");
    }

}
