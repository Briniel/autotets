package Elements;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static Elements.CheckingOS.CheckingMyOS;

public class CarryFile {

    public static void Carry() throws IOException {
        String MyOS = CheckingMyOS();
        String sourseWay;
        String destWay;

        if (MyOS.contains("\\")){
            sourseWay = MyOS + "environment.properties";
            destWay = "target\\allure-results\\environment.properties";
        } else {
            sourseWay = MyOS + "environment.properties";
            destWay = "target/allure-results/environment.properties";
        }

        File sourse = new File(sourseWay);
        File dest = new File(destWay);
        FileUtils.copyFile(sourse, dest);
    }

}
