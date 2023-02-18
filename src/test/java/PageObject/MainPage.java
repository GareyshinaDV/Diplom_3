package PageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.openqa.selenium.By.xpath;

public class MainPage {

    private WebDriver driver;

    private By personalAccountButton = xpath(".//p[contains(text(), 'Личный Кабинет')]"); // Локатор кнопки "Личный кабинет"

    private By enterIntoAccountButton = xpath(".//button[contains(text(),'Войти в аккаунт')]"); // Локатор кнопки "Войти в аккаунт"

    private By bunsButton = xpath(".//span[@class = 'text text_type_main-default' and contains(text(), 'Булки')]"); // Локатор кнопки "Булки"

    private By sauceButton = xpath(".//span[@class = 'text text_type_main-default' and contains(text(), 'Соусы')]"); // Локатор кнопки "Соусы"

    private By fillingsButton = xpath(".//span[@class = 'text text_type_main-default' and contains(text(), 'Начинки')]"); // Локатор кнопки "Начинки"
    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Клик по кнопке «Личный кабинет» в хедере главной страницы")
    public void clickOnPersonalAccountButton() {   // Метод клика на кнопку "Личный кабинет" в хедере страницы
        WebElement element = driver.findElement(personalAccountButton);
        Assert.assertTrue(driver.findElement(personalAccountButton).isEnabled());
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public void clickOnEnterIntoAccountButton() {   // Метод клика на кнопку "Войти в аккаунт" в середине страницы
        WebElement element = driver.findElement(enterIntoAccountButton);
        Assert.assertTrue(driver.findElement(enterIntoAccountButton).isEnabled());
        driver.findElement(enterIntoAccountButton).click();
    }

    @Step("Клик по кнопке «Булки»")
    public void clickOnBunsButton() {   // Метод клика на кнопку "Булки" в конструкторе бургера
        WebElement element = driver.findElement(bunsButton);
        Assert.assertTrue(driver.findElement(bunsButton).isEnabled());
        driver.findElement(bunsButton).click();
    }

    @Step("Клик по кнопке «Соусы»")
    public void clickOnSauceButton() {   // Метод клика на кнопку "Соусы" в конструкторе бургера
        WebElement element = driver.findElement(sauceButton);
        Assert.assertTrue(driver.findElement(sauceButton).isEnabled());
        driver.findElement(sauceButton).click();
    }

    @Step("Клик по кнопке «Начинки»")
    public void clickOnFillingsButton() {   // Метод клика на кнопку "Начинки" в конструкторе бургера
        WebElement element = driver.findElement(fillingsButton);
        Assert.assertTrue(driver.findElement(fillingsButton).isEnabled());
        driver.findElement(fillingsButton).click();
    }

}
