import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static pageobject.Constants.LOGIN_PAGE_URL;
import static pageobject.Constants.MAIN_PAGE_URL;

public class BaseTest {

    public WebDriver driver;

    public String browser = "Chrome";

    @Before
    public void setUpDriver() {
        if (browser == "Chrome") {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser == "Yandex"){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver108.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\daria\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        }
    }
}
