package PageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class RegisterPage {

    private WebDriver driver;

    private By entryOnRegButton = xpath(".//a[@href = '/login']"); // Локатор кнопки "Войти"
    private By nameField = xpath(".//label[contains(text(),'Имя')]/../input"); // Локатор поля имя
    private By loginField = xpath(".//label[contains(text(),'Email')]/../input"); // Локатор поля логин
    private By passwordField = xpath(".//label[contains(text(),'Пароль')]/../input"); // Локатор поля пароль

    private By registerButton = xpath(".//button[contains(text(),'Зарегистрироваться')]"); // Локатор кнопки "Зарегистрироваться"

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Клик по кнопке «Войти»")
    public void clickOnEntryButton() {   // Метод клика по кнопке "Войти"
        WebElement element = driver.findElement(entryOnRegButton);
        Assert.assertTrue(driver.findElement(entryOnRegButton).isEnabled());
        driver.findElement(entryOnRegButton).click();
    }

    @Step("Заполнение поля имя")
    public void inputNameField(String name) {   // Метод заполнения имени пользователя
        WebElement element = driver.findElement(nameField);
        Assert.assertTrue(driver.findElement(nameField).isEnabled());
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнение поля логин")
    public void inputLoginField(String login) {   // Метод заполнения логина пользователя
        WebElement element = driver.findElement(loginField);
        Assert.assertTrue(driver.findElement(loginField).isEnabled());
        driver.findElement(loginField).sendKeys(login);
    }

    @Step("Заполнение поля пароль")
    public void inputPasswordField(String password) {   // Метод заполнения пароля пользователя
        WebElement element = driver.findElement(passwordField);
        Assert.assertTrue(driver.findElement(passwordField).isEnabled());
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickOnRegisterButton() {   // Метод клика по кнопке "Зарегистрироваться"
        WebElement element = driver.findElement(registerButton);
        Assert.assertTrue(driver.findElement(registerButton).isEnabled());
        driver.findElement(registerButton).click();
    }
}
