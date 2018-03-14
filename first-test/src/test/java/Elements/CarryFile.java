package Elements;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static Elements.CheckingOS.CheckingMyOS;

public class CarryFile {

    public static void Carry() throws IOException {
        String MyOS = CheckingMyOS();

        String sourse;
        String dest;



        if (MyOS.contains("\\")){
            sourse = MyOS;
            dest = "target\\allure-results\\";
        } else {
            sourse = MyOS;
            dest = "target/allure-results/";
        }

        File sourseEnvironment = new File(sourse + "environment.properties");
        File destEnvironment = new File(dest + "environment.properties");
        FileUtils.copyFile(sourseEnvironment, destEnvironment);

        File sourseCategories = new File(sourse + "categories.json");
        File destCategories = new File(dest+ "categories.json");
        FileUtils.copyFile(sourseCategories, destCategories);
    }

}
