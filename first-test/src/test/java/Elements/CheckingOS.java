package Elements;

import java.util.*;

public class CheckingOS {

    public static String CheckingMyOS(){
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String drive = null;
        if(OS.indexOf("win") >= 0){
            String place = System.getProperty("user.dir");
            drive = place.replace("first-test","chromedriver.exe");
        } else if (OS.contains("nix") || OS.contains("nux")
                || OS.contains("aix")){
            String place = System.getProperty("user.dir");
            drive = place.replace("first-test","chromedriver");
        }
        return drive;
    }

}
