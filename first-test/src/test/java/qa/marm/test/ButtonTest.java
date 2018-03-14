package qa.marm.test;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.Assert;

import static Elements.elementsScreens.*;
import static qa.marm.test.Authorization.driver;

@Test(dataProviderClass = Authorization.class)
public class ButtonTest {

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    //Открытие бокового меню и переход в раздел Button
    @Test(priority = 1)
    public void MenuLeft() throws Exception {
        leftMenuButton().click();
        leftMenu().isDisplayed();

        saveScreenshot();

        VisualButton().click();
        MenuButton().click();
    }

    //Проверка наличия всех элементов на экране
    @Test(priority = 2)
    public void ScreenButtonCheck() throws InterruptedException {
        //"Экран Button"
        infoAccord().isDisplayed();
        mainButton().isDisplayed();
        Title1().isDisplayed();
        saveScreenshot();
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

        saveScreenshot();
    }


    //Проверка визуальной части элемента
    @Test (priority = 3)
    public void CorrectDisplayOfAVisualElement(){
        Assert.assertTrue(mainButton().getAttribute("style").contains("background-color: rgb(218, 232, 252)"), "Проверка цвета фона кнопки");
        Assert.assertTrue(mainButton().getAttribute("style").contains("border: 1px solid rgb(108, 142, 191)"), "Проверка цвета рамки кнопки");
        Assert.assertTrue(mainButton().getAttribute("style").contains("border-radius: 5px"), "Проверка скругления кнопки");
    }

    //Проверка визуального отображения текста кнопки
    @Test (priority = 4, enabled = false)
    public void ChangeTheTextOfTheVisualElement() {
        Title2().click();
        Assert.assertTrue(mainButton().getText().equals("TITLEWORK"), "Проверка смены названия кнопки на TITLEWORK");
        saveScreenshot();
        Title1().click();
        Assert.assertTrue(mainButton().getText().equals("BUTTON"), "Проверка смены названия кнопки на BUTTON");
        saveScreenshot();
    }

    //Проверка скрытия кнопки
    @Test (priority = 5, enabled = false)
    public void ChangeTheVisibilityOfTheVisualElement() {
        VisibilityFalse().click();
        try {
            if (mainButton().isDisplayed()){
                Assert.assertFalse(true, "Конопка не скрыта");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
        saveScreenshot();
        VisibilityTrue().click();
        mainButton().isDisplayed();
        saveScreenshot();
    }

    //Проврека выравнивания текста
    @Test (priority = 6, enabled = false)
    public void AligningTheTextOfTheVisualElement() {
        AlignLeft().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("left"), "Проверка выравнивания текста по левому краю");
        saveScreenshot();
        AlignCenter().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("center"), "Проверка выравнивания текста по центру");
        saveScreenshot();
        AlignRight().click();
        Assert.assertTrue(mainButton().getAttribute("style").contains("right"), "Проверка выравнивания текста по правому краю");
        saveScreenshot();
    }

    //Проверка функционала
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

}
