import pageobject.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageobject.Constants.MAIN_PAGE_URL;
import static org.openqa.selenium.By.xpath;

public class ConstructorTest extends BaseTest {

    @Before
    public void setUp(){
        driver.get(MAIN_PAGE_URL);
    }


    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка перехода к разделу начинок в конструкторе на главной странице")
    public void transitionOnFillingsTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnFillingsButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Начинки')]")));
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка перехода к разделу соусов в конструкторе на главной странице")
    public void transitionOnSauceTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauceButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Соусы')]")));
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка перехода к разделу булок в конструкторе на главной странице")
    public void transitionOnBunsTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnSauceButton();
        objMainPage.clickOnBunsButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[contains(text(),'Булки')]")));
    }

   @After
    public void teardown() {
        driver.quit();
    }

}
