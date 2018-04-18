package Elements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Elements.CheckingOS.CheckingMyOS;
import static qa.marm.test.Authorization.driver;

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

        File Environment = new File(dest + "environment.properties");
        FileWriter writer = new FileWriter(Environment);
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion().toString();


        writer.write(
                "Browser=" + browserName + "\n" +
                        "Browser.Version=" + v +"\n" +
                        "OS=" + os + "\n" +
                        "Stand=QA"+ "\n" +
                        "URL=dev.client-3.1.0-blackhole-v1d3.marm.altarix.org" + "\n" +
                        "NameProject=PoligonAutotest"+"\n"+
                        "Application.Version=0.1");

        writer.flush();
        writer.close();

        File sourseCategories = new File(sourse + "categories.json");
        File destCategories = new File(dest+ "categories.json");
        FileUtils.copyFile(sourseCategories, destCategories);
    }

}
