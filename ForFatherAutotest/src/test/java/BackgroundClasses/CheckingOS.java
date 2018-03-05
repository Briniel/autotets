package BackgroundClasses;

import java.util.Locale;

public class CheckingOS {


    public static String CheckingMyOS(){
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String drive = null;
        if(OS.indexOf("win") >= 0){
            String place = System.getProperty("user.dir");
            drive = place.replace("ForFatherAutotest","chromedriver.exe");
        } else if (OS.contains("nix") || OS.contains("nux")
                || OS.contains("aix")){
            String place = System.getProperty("user.dir");
            drive = place.replace("ForFatherAutotest","chromedriver");
        }
        return drive;
    }

}
