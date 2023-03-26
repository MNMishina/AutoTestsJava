package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;           //скачает самую актуальную версию хромдрайвера и сверит с нашим браузером
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    /**
     * инициализация Selenide с настройками
     */
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() {setUp();}

    @After
    public void tearDown() {Selenide.closeWebDriver();}
}
