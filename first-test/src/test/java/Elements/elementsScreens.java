package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static qa.marm.test.FirstTest.driver;

public class elementsScreens {
    public static WebElement LoginButton() {
        return driver.findElement(By.id("login_button"));
    }

    public static WebElement elementWelcome() {
        return driver.findElement(By.id("Welcome"));
    }

    public static WebElement leftMenuButton(){
        return driver.findElement(By.xpath("//*[@id=\"toolbar_marm\"]/div[1]/button"));
    }

    public static WebElement leftMenu(){
        return driver.findElement(By.id("Menu"));
    }

    public static WebElement VisualButton(){
        return driver.findElement(By.xpath("//span[contains(text(),'Визуальные элементы')]"));
    }

    public static WebElement MenuButton(){
        return driver.findElement(By.id("ButtonMenu"));
    }

    public static WebElement infoAccord(){
        return driver.findElement(By.id("accordInfo"));
    }

    public static WebElement mainButton(){
        return driver.findElement(By.id("mainButton"));
    }

    public static WebElement Title1(){
        return driver.findElement(By.id("title1"));
    }

    public static WebElement Title2(){
        return driver.findElement(By.id("title2"));
    }

    public static WebElement VisibilityTrue(){
        return driver.findElement(By.id("visibilityTrue"));
    }

    public static WebElement VisibilityFalse(){
        return driver.findElement(By.id("visibilityFalse"));
    }

    public static WebElement AlignLeft(){
        return driver.findElement(By.id("alignLeft"));
    }

    public static WebElement AlignCenter(){
        return driver.findElement(By.id("alignCenter"));
    }

    public static WebElement AlignRight(){
        return driver.findElement(By.id("alignRight"));
    }

    public static WebElement Styles(){
        return By.xpath("//span[contains(text(),'Стили')]").findElement(driver);
    }

    public static WebElement themeStyle(){
        return By.xpath("//span[contains(text(),'themeStyle')]").findElement(driver);
    }

    public static WebElement nameStyle(){
        return By.xpath("//span[contains(text(),'nameStyle')]").findElement(driver);
    }

    public static WebElement inlineStyle(){
        return By.xpath("//span[contains(text(),'inlineStyle')]").findElement(driver);
    }

}
