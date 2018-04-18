package qa.marm.test;

import TestClass.MainScreen;
import TestClass.ViewScreen;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static qa.marm.test.Authorization.driver;

@Feature("Test View")
public class View {
    private ViewScreen viewScreen;
    private MainScreen mainScreen;

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test(groups = "lable")
    @Description("Go to screen View")
    public void MenuLeft(){
        WebDriverWait wait = (new WebDriverWait(driver, 25));
        mainScreen = new MainScreen(driver);
        mainScreen.clickLeftMenu();
        driver.findElement(mainScreen.visualElements).isDisplayed();
        mainScreen.clickVisualElements();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mainScreen.labelMenu));
        saveScreenshot();
        mainScreen.clickViewMenu();
    }

    @Test(dependsOnMethods = "MenuLeft")
    @Description("Check View")
    public void CheckView(){
        viewScreen = new ViewScreen(driver);
        SoftAssert s = new SoftAssert();
        s.assertTrue(viewScreen.getHorizontalBlock().contains("justify-content: flex-start"),"По горизонтали");
        s.assertTrue(viewScreen.getHorizontalBlock().contains("align-items: flex-start"),"По вертикали");
        saveScreenshot();
        System.out.println(viewScreen.getSizeHorizontalBlock());
        s.assertAll();
    }

}
