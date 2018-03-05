package BackgroundClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementsScreens {
    public static WebDriver driver;

    public static WebElement Search() {
        return driver.findElement(By.id("text"));
    }

    public static WebElement ButtonSearch() {
        return driver.findElement(By.className("search2__button"));
    }

    public static WebElement ResultSearch() {
        return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[1]/ul"));
    }

    public static WebElement CharchButton() {
        return driver.findElement(By.xpath("//span[contains(text(),'Последние 10 песен')]"));
    }

    public static WebElement Stick(){
        return driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ol"));
    }
}
