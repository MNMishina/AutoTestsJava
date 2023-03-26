package pages;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class BasePage2 {
    public void clickButton(String text) {
        $(By.xpath("//a[text()='" + text + "']")).click();
    }
    public static long pollingInterval;

    public void clickSecondButton(String text) {
        $(By.xpath("//button[text()='" + text + "']")).click();
    }
}

