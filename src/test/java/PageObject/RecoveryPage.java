package PageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class RecoveryPage {

    private WebDriver driver;

    private By entryOnRecoveryButton = xpath(".//a[@href = '/login']"); // Локатор кнопки "Войти"


    public RecoveryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Клик по кнопке «Войти»")
    public void clickOnEntryButton() {   // Метод клика по кнопке "Войти"
        WebElement element = driver.findElement(entryOnRecoveryButton);
        Assert.assertTrue(driver.findElement(entryOnRecoveryButton).isEnabled());
        driver.findElement(entryOnRecoveryButton).click();
    }
}
