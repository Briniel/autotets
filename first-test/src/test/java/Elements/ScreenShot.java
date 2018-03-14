package Elements;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static Elements.CheckingOS.CheckingMyOS;
import static qa.marm.test.Authorization.driver;

public class ScreenShot {
    public static void screen() throws Exception {
        //Вычисление текущего опер. дня.
        String MyOS = CheckingMyOS();
//        Date dateNow = new Date();
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");

        //Определение ОС и создание папки для скринов.
        if (MyOS.contains("\\")){
            MyOS = "target\\allure-results\\";
        } else {
            MyOS = "target/allure-results/";
        }


        //Скриншот экрана
        byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(screen);
    }

    @Attachment(value = "{method}")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
