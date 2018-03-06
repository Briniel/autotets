package Elements;

import java.util.*;


public class CheckingOS {

    public static String CheckingMyOS(){
        String CheckOS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String OS = null;
        if(CheckOS.indexOf("win") >= 0){
            OS = "src\\test\\resourse\\";
        } else if (CheckOS.contains("nix") || CheckOS.contains("nux")
                || CheckOS.contains("aix")){
            OS = "src/test/resourse/";
        }
        return OS;
    }

    public static String GiveDriver(){
        String driverChrome;
        String MyOS = CheckingMyOS();
        if (MyOS.contains("\\")){
            driverChrome = MyOS+"chromedriver.exe";
        } else {
            driverChrome = MyOS+"chromedriver";
        }
        return driverChrome;
    }
}
