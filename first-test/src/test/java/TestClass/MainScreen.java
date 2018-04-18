package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainScreen {
    private WebDriver driver;

    public MainScreen(WebDriver driver){
        this.driver = driver;
    }

    private By rightMenu = By.xpath("//span[text()='more_vert']");
    private By leftMenu = By.xpath("//span[text()='menu']");
    public By visualElements = By.xpath("//*[contains(text(),'Визуальные элементы')]");
    public By buttonMenu = By.xpath("//*[@id=\"ButtonMenu\"]");
    public By labelMenu = By.xpath("//*[@id=\"LabelMenu\"]");
    public By viewMenu = By.xpath("//*[@id=\"ViewMenu\"]");
    public By welcome = By.xpath("//span[text()='Добро пожаловать в']");

    public void clickRightMenu(){
        driver.findElement(rightMenu).click();
    }

    public MainScreen clickLeftMenu(){
        driver.findElement(leftMenu).click();
        return this;
    }

    public void clickVisualElements(){
        driver.findElement(visualElements).click();
    }

    public void clickButtonMenu(){
        driver.findElement(buttonMenu).click();
    }

    public void clickLabelMenu(){
        driver.findElement(labelMenu).click();
    }

    public void clickViewMenu() {
        driver.findElement(viewMenu).click();
    }

//    public String nameScreen = driver.findElement(By.xpath("//*[@id=\"toolbar_marm\"]/div[2]/span")).getText();
}