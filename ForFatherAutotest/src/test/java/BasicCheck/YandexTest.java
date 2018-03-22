package BasicCheck;


import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static BackgroundClasses.ElementsScreens.*;
import static BasicCheck.Authorization.driver;

public class YandexTest {

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(priority = 6)
    public void Login(){
        driver.get("https://yandex.ru/");
        saveScreenshot();
        Search().sendKeys("Selenium");
        ButtonSearch().click();
        int resul = ResultSearch().getSize().height;
        saveScreenshot();
        Assert.assertFalse(resul == 0, "По запросу ничего не найдено");
    }

    @Test(dependsOnMethods = "Login")
    public void ErrorYandex(){
        SoftAssert s = new SoftAssert();
        s.assertTrue(driver.findElements(By.xpath("//div[contains(text(), 'НАШЕ')]]")).size() == 1, "Элемент не найден");
        int resul = ResultSearch().getSize().height;
        s.assertFalse(resul == 0, "По запросу ничего не найдено");
        s.assertAll();
    }


}
