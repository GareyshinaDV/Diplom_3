package PageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class PersonalAccountPage {

    private WebDriver driver;


    private By constructorButton = xpath(".//p[contains(text(), 'Конструктор')]"); // Локатор кнопки "Конструктор"

    private By logoButton = xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']"); // Локатор логотипа

    private By outOfPersonalAccountButton = xpath(".//button[contains(text(), 'Выход')]"); // Локатор логотипа

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке «Конструктор»")
    public void clickOnConstructorButton() {   // Метод клика на кнопку "Конструктор" в хедере страницы
        WebElement element = driver.findElement(constructorButton);
        Assert.assertTrue(driver.findElement(constructorButton).isEnabled());
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по логотипу")
    public void clickOnLogoButton() {   // Метод клика на логотип в хедере страницы
        WebElement element = driver.findElement(logoButton);
        Assert.assertTrue(driver.findElement(logoButton).isEnabled());
        driver.findElement(logoButton).click();
    }

    @Step("Клик по кнопке «Выход»")
    public void clickOnOutOfPersonalAccountButton() {   // Метод клика на кнопку "Выход"
        WebElement element = driver.findElement(outOfPersonalAccountButton);
        Assert.assertTrue(driver.findElement(outOfPersonalAccountButton).isEnabled());
        driver.findElement(outOfPersonalAccountButton).click();
    }

}
