import Api.UserApi;
import Api.UserData;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RecoveryPage;
import PageObject.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.Constants.*;
import static org.openqa.selenium.By.xpath;

public class LoginTest {

    private WebDriver driver;

    private String token;

    @Before
    public void setUp(){
        UserApi user = new UserApi(email, password, name);
        user.creationOfUser(user);
        token = user.authorizationOfUser(user).as(UserData.class).getAccessToken();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(MAIN_PAGE_URL);
    }


    @Test
    @DisplayName("Вход в личный кабинет через клик по кнопке «Личный кабинет»")
    @Description("Проверка перехода в личный кабинет через кнопку «Личный кабинет» в хедере главной страницы")
    public void entryInPerAccByPersonalAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.inputLogin(email);
        objLoginPage.inputPassword(password);
        objLoginPage.clickOnEntryButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled());
    }

    @Test
    @DisplayName("Вход в личный кабинет через клик по кнопке «Войти в аккаунт»")
    @Description("Проверка перехода в личный кабинет через кнопку «Войти в аккаунт» в хедере главной страницы")
    public void entryInPerAccByEnterIntoAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnEnterIntoAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.inputLogin(email);
        objLoginPage.inputPassword(password);
        objLoginPage.clickOnEntryButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled());
    }


    @Test
    @DisplayName("Вход в личный кабинет через форму регистрации")
    @Description("Проверка перехода в личный кабинет через форму регистрации")
    public void entryInPerAccByRegistrationButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnEnterIntoAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRegistrationButton();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickOnEntryButton();
        objLoginPage.inputLogin(email);
        objLoginPage.inputPassword(password);
        objLoginPage.clickOnEntryButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled());
    }


    @Test
    @DisplayName("Вход в личный кабинет через форму восстановления пароля")
    @Description("Проверка перехода в личный кабинет через форму восстановления пароля")
    public void entryInPerAccByRecoveryButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnEnterIntoAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickOnRecoveryButton();
        RecoveryPage objRecoveryPage = new RecoveryPage(driver);
        objRecoveryPage.clickOnEntryButton();
        objLoginPage.inputLogin(email);
        objLoginPage.inputPassword(password);
        objLoginPage.clickOnEntryButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Оформить заказ')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Оформить заказ')]")).isEnabled());
    }


   @After
    public void teardown() {
       driver.quit();
       UserApi.deletingOfUser(token);
    }

}
