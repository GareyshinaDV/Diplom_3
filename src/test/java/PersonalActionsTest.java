import api.UserApi;
import api.UserData;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PersonalAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageobject.Constants.*;
import static org.openqa.selenium.By.xpath;

public class PersonalActionsTest extends BaseTest {

    private String token;

    @Before
    public void setUp(){
        UserApi user = new UserApi(email, password, name);
        user.creationOfUser(user);
        token = user.authorizationOfUser(user).as(UserData.class).getAccessToken();
        System.out.println(token);
        driver.get(MAIN_PAGE_URL);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.inputLogin(email);
        objLoginPage.inputPassword(password);
        objLoginPage.clickOnEntryButton();
    }

    @Test
    @DisplayName("Переход из главной страницы в личный кабинет")
    @Description("Проверка перехода из главной страницы в личный кабинет авторизованного пользователя")
    public void transitionFromMainPageToPersonalAccountTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//a[contains(text(), 'Профиль')]")));
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile",driver.getCurrentUrl());
    }



    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через кнопку «Конструктор»")
    @Description("Проверка перехода из личного кабинета авторизованного пользователя на главную страницу через клик по кнопку «Конструктор»")
    public void transitionFromPersonalAccountToMainPageByConstructorButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickOnConstructorButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//h1[contains(text(), 'Соберите бургер')]")));
        Assert.assertEquals(MAIN_PAGE_AUTHORIZED_USER_URL,driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через клик по логотипу")
    @Description("Проверка перехода из личного кабинета авторизованного пользователя на главную страницу через клик по логотипу")
    public void transitionFromPersonalAccountToMainPageByLogoButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickOnLogoButton();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//h1[contains(text(), 'Соберите бургер')]")));
        Assert.assertEquals(MAIN_PAGE_AUTHORIZED_USER_URL,driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта")
    public void checkOutFromPersonalAccountTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(), 'Выход')]")));
        objPersonalAccountPage.clickOnOutOfPersonalAccountButton();
        WebElement dynamicElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//h2[contains(text(), 'Вход')]")));
        Assert.assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
        UserApi.deletingOfUser(token);
    }
}
