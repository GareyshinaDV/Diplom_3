import Api.UserApi;
import Api.UserData;
import PageObject.LoginPage;
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

public class RegistrationTest {

    private WebDriver driver;

    private String token;

    private boolean isDeleted;

    @Before
    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(REGISTER_PAGE_URL);
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка позитивного сценария регистрации пользователя")
    public void positiveRegTest(){
        this.isDeleted = true;
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.inputNameField(name);
        objRegisterPage.inputLoginField(email);
        objRegisterPage.inputPasswordField(password);
        objRegisterPage.clickOnRegisterButton();
        LoginPage objLoginPage = new LoginPage(driver);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//button[contains(text(),'Войти')]")));
        Assert.assertTrue(driver.findElement(xpath(".//button[contains(text(),'Войти')]")).isEnabled());

    }

    @Test
    @DisplayName("Регистрация пользователя с невалидными данными")
    @Description("Проверка негативного сценария регистрации пользователя")
    public void negativeRegTest(){
        this.isDeleted = false;
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.inputNameField(name);
        objRegisterPage.inputLoginField(email);
        objRegisterPage.inputPasswordField(wrongPassword);
        objRegisterPage.clickOnRegisterButton();
        LoginPage objLoginPage = new LoginPage(driver);
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath(".//p[@class = 'input__error text_type_main-default']"))); // Проверка на появление надписи "Некорректный пароль"

    }

    @After
    public void teardown() {
        if(isDeleted == true){
            UserApi user = new UserApi (email, password, name);
            token = user.authorizationOfUser(user).as(UserData.class).getAccessToken();
            UserApi.deletingOfUser(token);
        }
        driver.quit();
    }



}
