package BasicCheck;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import static BackgroundClasses.ElementsScreens.*;
import static BasicCheck.Authorization.driver;

public class YandexTest {

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(priority = 5)
    public void Login(){
        driver.get("https://yandex.ru/");
        saveScreenshot();
        Search().sendKeys("Selenium");
        ButtonSearch().click();
        int resul = ResultSearch().getSize().height;
        saveScreenshot();
        Assert.assertFalse(resul == 0, "По запросу ничего не найдено");
    }


}
