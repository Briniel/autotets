package Elements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Elements.CheckingOS.CheckingMyOS;
import static qa.marm.test.FirstTest.driver;

public class ScreenShot {
    public static void screen(String method) throws Exception {
        //Вычисление текущего опер. дня.
        String MyOS = CheckingMyOS();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");

        //Определение ОС и создание папки для скринов.
        if (MyOS.contains("\\")){
            MyOS = MyOS + formatForDateNow.format(dateNow)+"\\";
        } else {
            MyOS = MyOS + formatForDateNow.format(dateNow)+"/";
        }

        //Скриншот экрана
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File(MyOS + method + ".png"));
    }
}
