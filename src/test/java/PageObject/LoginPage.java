package PageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.xpath(".//input[@type = 'text']"); // Локатор ввода значения "Логин"
    private By passwordField = By.xpath(".//input[@type = 'password']"); // Локатор ввода значения "Пароль"
    private By entryButton = By.xpath(".//button[contains(text(),'Войти')]"); // Локатор кнопки "Войти"

    private By registrationButton = By.xpath(".//a[@href = '/register']"); // Локатор кнопки "Зарегистрироваться"

    private By recoveryButton = By.xpath(".//a[@href = '/forgot-password']"); // Локатор кнопки "Восстановить пароль"

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Ввод логина")
    public void inputLogin(String login) {   // Метод ввода логина
        WebElement element = driver.findElement(emailField);
        Assert.assertTrue(driver.findElement(emailField).isEnabled());
        driver.findElement(emailField).sendKeys(login);
    }

    @Step("Ввод пароля")
    public void inputPassword(String password) {   // Метод ввода пароля
        WebElement element = driver.findElement(passwordField);
        Assert.assertTrue(driver.findElement(passwordField).isEnabled());
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке «Войти»")
    public void clickOnEntryButton() {   // Метод клика по кнопке "Войти"
        WebElement element = driver.findElement(entryButton);
        Assert.assertTrue(driver.findElement(entryButton).isEnabled());
        driver.findElement(entryButton).click();
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickOnRegistrationButton() {   // Метод клика по кнопке "Зарегистрироваться"
        WebElement element = driver.findElement(registrationButton);
        Assert.assertTrue(driver.findElement(registrationButton).isEnabled());
        driver.findElement(registrationButton).click();
    }

    @Step("Клик по кнопке «Восстановить пароль»")
    public void clickOnRecoveryButton() {   // Метод клика по кнопке "Восстановить пароль"
        WebElement element = driver.findElement(recoveryButton);
        Assert.assertTrue(driver.findElement(recoveryButton).isEnabled());
        driver.findElement(recoveryButton).click();
    }
}
