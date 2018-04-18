package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;

public class ViewScreen {

    private WebDriver driver;

    public ViewScreen(WebDriver driver){
        this.driver = driver;
    }

    private By addBlock = By.xpath("//button[@id=\"addBlock\"]");
    private By removeBlock = By.xpath("//button[@id=\"removeBlock\"]");
    private By orientationHorizontal = By.xpath("//button[@id=\"orientationHorizontal\"]");
    private By orientationVertical = By.xpath("//button[@id=\"orientationVertical\"]");
    private By leftTop = By.xpath("//button[@id=\"left_top\"]");
    private By centerTop = By.xpath("//button[@id=\"center_top\"]");
    private By rightTop = By.xpath("//button[@id=\"right_top\"]");
    private By leftCenter = By.xpath("//button[@id=\"left_center\"]");
    private By center = By.xpath("//button[@id=\"center\"]");
    private By rightCenter = By.xpath("//button[@id=\"right_center\"]");
    private By leftBottom = By.xpath("//button[@id=\"left_bottom\"]");
    private By centerBottom = By.xpath("//button[@id=\"center_bottom\"]");
    private By rightBottom = By.xpath("//button[@id=\"right_bottom\"]");
    private By visibilityTrue = By.xpath("//button[@id=\"visibilityTrue\"]");
    private By visibilityFalse = By.xpath("//button[@id=\"visibilityFalse\"]");
    private By scrollableTrue = By.xpath("//button[@id=\"scrollableTrue\"]");
    private By scrollableFalse = By.xpath("//button[@id=\"scrollableFalse\"]");
    private By blockH1 = By.xpath("//button[@id=\"blockH_1\"]");
    private By blockH2 = By.xpath("//button[@id=\"blockH_2\"]");
    private By horizontalBlock = By.xpath("//*[@id=\"horizontalBlock\"]");


    public ViewScreen clickAddBlock(){
        driver.findElement(addBlock).click();
        return this;
    }

    public ViewScreen clickRemoveBlock(){
        driver.findElement(removeBlock).click();
        return this;
    }

    public ViewScreen clickOrientationHorizontal(){
        driver.findElement(orientationHorizontal).click();
        return this;
    }

    public ViewScreen clickOrientationVertical(){
        driver.findElement(orientationVertical).click();
        return this;
    }

    public ViewScreen clickLeftTop(){
        driver.findElement(leftTop).click();
        return this;
    }

    public ViewScreen clickCenterTop(){
        driver.findElement(centerTop).click();
        return this;
    }

    public ViewScreen clickRightTop(){
        driver.findElement(rightTop).click();
        return this;
    }

    public ViewScreen clickLeftCenter(){
        driver.findElement(leftCenter).click();
        return this;
    }

    public ViewScreen clickCenter(){
        driver.findElement(center).click();
        return this;
    }

    public ViewScreen clickRightCenter(){
        driver.findElement(rightCenter).click();
        return this;
    }

    public ViewScreen clickLeftBottom(){
        driver.findElement(leftBottom).click();
        return this;
    }

    public ViewScreen clickCenterBottom(){
        driver.findElement(centerBottom).click();
        return this;
    }

    public ViewScreen clickRightBottom(){
        driver.findElement(rightBottom).click();
        return this;
    }

    public ViewScreen clickVisibilityTrue(){
        driver.findElement(visibilityTrue).click();
        return this;
    }

    public ViewScreen clickVisibilityFalse(){
        driver.findElement(visibilityFalse).click();
        return this;
    }

    public ViewScreen clickScrollableTrue(){
        driver.findElement(scrollableTrue).click();
        return this;
    }

    public ViewScreen clickScrollableFalse(){
        driver.findElement(scrollableFalse).click();
        return this;
    }

    public String getStyleBlock1(){
        return driver.findElement(blockH1).getAttribute("style");
    }

    public String getStyleBlock2(){
        return driver.findElement(blockH2).getAttribute("style");
    }

    public String getHorizontalBlock(){
        return driver.findElement(horizontalBlock).getAttribute("style");
    }

    public Rectangle getSizeHorizontalBlock(){
        return driver.findElement(horizontalBlock).getRect();
    }

}
