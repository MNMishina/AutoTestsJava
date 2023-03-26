/**
 * Черновик автотеста
 */

/*
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SearchTest {
    @Test
    // void - ничего не возвращает
    public void openGoogleComInChromeTest() {
        //Путь к драйверу
        File file = new File("src/test/resources/chromedriver.exe");

        //Сохраняем путь в системную переменную
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //Пример локального web драйвера для Хрома
        WebDriver driver = new ChromeDriver();
        //метод navigate и to или get переводят на url
        driver.get("https://www.youtube.com/"); // или driver.get("https://www.google.com/");
        */
        /*
        driver.navigate().to - переход на url
        driver.navigate().refresh - обновить
        driver.navigate().back - назад
        driver.navigate().forward - вперед
         */
        /*
        Закрытие браузера
        driver.quit - закрытие браузера со всеми окнами
        driver.close - закрывает текущее окно


        System.out.println(driver.getTitle());
        //WebElement searchField = driver.findElement(By.name("q"));
        //searchField.click();
        //WebElement googleAppsButton = driver.findElement(By.cssSelector("div#gbwa a"));
        //googleAppsButton.click();
        WebElement youtubeSearch = driver.findElement(By.xpath("//div/input[@placeholder='Введите запрос']"));
        youtubeSearch.click();
        driver.quit();

        /*
        //Пример локального web драйвера для ИЕ
        import org.openqa.selenium.ie.InternetExplorerDriver;
        WebDriver driver = new InternetExplorerDriver();
        */
        /*
        //метод navigate и to переводят на url
        driver.navigate().to("https://www.microsoft.com/");
        */
        /*
        //Пример удаленного web драйвера
        import org.openqa.selenium.remote.RemoteWebDriver;
        WebDriver driver = new RemoteWebDriver(remoteURL, desiredCapabilities);
        */
//    }
/*
    // Второй тест
    @Test
    public void openGoogleComInChromeTest2() throws InterruptedException {

        //File file = new File("src/test/resources/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        //put 'selenium java' text to text field
        searchField.sendKeys("selenium java");
        //press ENTER
        searchField.sendKeys(Keys.RETURN);
        // добавление задержки
        Thread.sleep(2000);
        WebElement resultRow = driver.findElement(By.xpath("//div[@class='yuRUbf']//h3"));

        assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text!").contains("LC20lb");

        //assertTrue(resultRow.isDisplayed(), "Element has not been displayed!");
        //assertEquals(resultRow.getText(), "Пишем автотест с использованием Selenium Webdriver ...", "Wrong text has been displayed!");
        //assertEquals(resultRow.getAttribute("class"), "LC20lb MBeuO DKV0Md", "Wrong attribute text!");
        //driver.quit();

    }

    @Test()
    public void checkYandexStartPage() {
        System.out.println(resultRow.getText());
        File file = new File("src/test/resources/chromedriver.exe");   System.out.println(resultRow.getAttribute("class"));   LC20l
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yandex.ru");
        driver.findElement(By.xpath("//input[contains(@class, 'input__input')]")).sendKeys("Привет");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();
    }

    @Test()
    public void checkWasdStartPage() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://wasd.tv/");
        driver.findElement(By.cssSelector("div.header__random-stream-btn")).click();
        driver.findElement(By.cssSelector("div.footer.footer__disabled")).click();
        //driver.findElement(By.cssSelector("div.header__search-btn")).click();
        //driver.findElement(By.cssSelector(".has-button")).sendKeys("Привет");
        //driver.findElement(By.cssSelector("wasd-button.header__login-btn.flat-btn")).click();
        //driver.findElement(By.cssSelector("input.ng-pristine.ng-valid.is-error.ng-touched")).sendKeys("bestfar@mail.ru");
        //driver.findElement(By.cssSelector("button.primary.extra-large ???")).click();
        //driver.findElement(By.cssSelector("//div/button")).click();
        driver.quit();
    }

*/
//wasd-button[class='header__login-btn flat-btn']
//div.footer.footer__disabled
//wasd-button.header__login-btn.flat-btn
//input.ng-pristine.ng-valid.is-error.ng-touched
//button.primary.extra-large
//WebElement searchButton = driver.findElement(By.name("btnK"));
//press on search button   WebElement searchButton =
//searchButton.click();
//div/input

    /* private WebDriver driver;

    @BeforeClass
    public void setUp() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    // возврат на исходную страницу браузера
    public void goBack() {
        driver.navigate() .back();
    }
    */
//}