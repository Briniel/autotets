package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LabelScreen {
    private WebDriver driver;

    public LabelScreen(WebDriver driver){
        this.driver = driver;
    }

    private By textMain = By.xpath("//span[@id=\"mainLabel\"]");
    private By value1Button = By.xpath("//*[@id=\"value1\"]");
    private By value2Button = By.xpath("//*[@id=\"value2\"]");
    private By visibilityTrueButton = By.xpath("//*[@id=\"visibilityTrue\"]");
    private By visibilityFalseButton = By.xpath("//*[@id=\"visibilityFalse\"]");
    private By alignLeftButton = By.xpath("//*[@id=\"alignLeft\"]");
    private By alignCenterButton = By.xpath("//*[@id=\"alignCenter\"]");
    private By alignRightButton = By.xpath("//*[@id=\"alignRight\"]");
    public By onClick = By.xpath("//*[text()='onClick() Сработал!']");


    public String getMainText(){
        return driver.findElement(textMain).getText();
    }

    public String getStyleText(){
        return driver.findElement(textMain).getAttribute("style");
    }

    public String getTitleText(){
        return driver.findElement(textMain).getAttribute("title");
    }

    public int getSizeLable(){
        return driver.findElements(textMain).size();
    }

    public LabelScreen clickText(){
        driver.findElement(textMain).click();
        return this;
    }

    public LabelScreen clickValue1Button(){
        driver.findElement(value1Button).click();
        return this;
    }

    public LabelScreen clickValue2Button(){
        driver.findElement(value2Button).click();
        return this;
    }

    public LabelScreen clickVisibilityFalseButton(){
        driver.findElement(visibilityFalseButton).click();
        return this;
    }

    public LabelScreen clickVisibilityTrueButton(){
        driver.findElement(visibilityTrueButton).click();
        return this;
    }

    public LabelScreen clickAlignCenterButton(){
        driver.findElement(alignCenterButton).click();
        return this;
    }

    public LabelScreen clickAlignLeftButton(){
        driver.findElement(alignLeftButton).click();
        return this;
    }

    public LabelScreen clickAlignRightButton(){
        driver.findElement(alignRightButton).click();
        return this;
    }

    public String getTextOnClick(){
        return driver.findElement(onClick).getText();
    }

}
