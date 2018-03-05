package Elements;

import java.util.*;

public class CheckingOS {

    public static String CheckingMyOS(){
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String drive = null;
        if(OS.indexOf("win") >= 0){

            drive = "";
        } else if (OS.contains("nix") || OS.contains("nux")
                || OS.contains("aix")){
            drive = "src/test/resourse/chromedriver";
        }
        return drive;
    }

}
