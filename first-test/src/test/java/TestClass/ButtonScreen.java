package TestClass;

/*
 Это класс для работы с Button.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ButtonScreen  {
    private WebDriver driver;

    public ButtonScreen(WebDriver driver){
        this.driver = driver;
    }

    /*
    Тут описан поиск элементов на экране.
     */
    private By mainButton = By.xpath("//*[@id='mainButton']");
    private By title1Button = By.xpath("//*[@id='title1']");
    private By title2Button= By.xpath("//*[@id='title2']");
    private By visibilityTrue = By.xpath("//*[@id='visibilityTrue']");
    private By visibilityFalse = By.xpath("//*[@id='visibilityFalse']");
    private By alignLeft = By.xpath("//*[@id='alignLeft']");
    private By alignCenter = By.xpath("//*[@id='alignCenter']");
    private By alignRight = By.xpath("//*[@id='alignRight']");
    private By acordStyle = By.xpath("//*[text()='Стили']");
    private By themeStyleMore = By.xpath("//*[text()='themeStyle']/../../..");
    private By themeStyle = By.xpath("//*[text()='themeStyle']");
    private By nameStyle = By.xpath("//*[text()='nameStyle']");
    private By nameStyleMore = By.xpath("//*[text()='nameStyle']/../../..");
    private By inlineStyle = By.xpath("//*[text()='inlineStyle']");
    private By inlineStyleMore = By.xpath("//*[text()='inlineStyle']/../../..");
    public By onClick = By.xpath("//*[text()='onClick() Сработал!']");

    /*
    Нажатие на кнопку "Button". Происходит onClick.
     */
    public ButtonScreen clickMainButton(){
        driver.findElement(mainButton).click();
        return this;
    }

    /*
    Получение текста onClick.
     */
    public String getTextOnClick(){
        return driver.findElement(onClick).getText();
    }

    /*
    Эти кнопки нужны для изменения назнания кнопки "Button".
     */
    public ButtonScreen clickTitle1Button(){
        driver.findElement(title1Button).click();
        return this;
    }

    public ButtonScreen clickTitle2Button(){
        driver.findElement(title2Button).click();
        return this;
    }

    /*
    Изменение визуального отображения кнопки.
     */
    public ButtonScreen clickVisibilityTrue(){
        driver.findElement(visibilityTrue).click();
        return this;
    }

    public ButtonScreen clickVisibilityFalse(){
        driver.findElement(visibilityFalse).click();
        return this;
    }

    /*
    Изменение выравнивание текста кнопки.
     */
    public ButtonScreen clickAlignLeft(){
        driver.findElement(alignLeft).click();
        return this;
    }

    public ButtonScreen clickAlignCenter(){
        driver.findElement(alignCenter).click();
        return this;
    }

    public ButtonScreen clickAlignRight(){
        driver.findElement(alignRight).click();
        return this;
    }

    /*
    Получение информации по кнопке Button.
     */
    public String getNameButton(){
        return driver.findElement(mainButton).getText();
    }

    public String getStyleButton(){
        return driver.findElement(mainButton).getAttribute("style");
    }

    public int getSizeButton(){
        return driver.findElements(mainButton).size();
    }

    /*
    Открытие акардиона
     */
    public ButtonScreen clickAcord(){
        driver.findElement(acordStyle).click();
        return this;
    }

    /*
    Получение информации по кнопке ThemeStyle.
     */
    public String getNameThemeStyle(){
        return driver.findElement(themeStyle).getText();
    }

    public String getStyleThemeStyle(){
        return driver.findElement(themeStyleMore).getAttribute("style");
    }

    public String getTextThemeStyle(){
        return driver.findElement(themeStyle).getAttribute("style");
    }

    /*
    Получение информации по кнопке NameStyle.
     */
    public String getNameNameStyle(){
        return driver.findElement(nameStyle).getText();
    }

    public String getStyleNameStyle(){
        return driver.findElement(nameStyleMore).getAttribute("style");
    }

    public String getTextNameStyle(){
        return driver.findElement(nameStyle).getAttribute("style");
    }

    /*
    Получение информации по кнопке InlineStyle.
     */
    public String getNameInlineStyle(){
        return driver.findElement(inlineStyle).getText();
    }

    public String getStyleInlineStyle(){
        return driver.findElement(inlineStyleMore).getAttribute("style");
    }

    public String getTextInlineStyle(){
        return driver.findElement(inlineStyle).getAttribute("style");
    }
}
