/**
 * Объявление драйвера Хромдрайвер. Предусловие открытие браузера Хром и постусловие закрытие браузера.
 */

package ru.DeliveryClub;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

        public ChromeDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @After
        public void close() {
            driver.quit();
        }
}
