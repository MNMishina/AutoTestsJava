/**
 * Created by Rita on 27.03.22
 *
 * Тест проверяет тайтл (название рядом с фавикон) сайта деливери-клуб, 2й тест ищет кнопку Акции
 */

package ru.DeliveryClub;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.IAssert;
import pages.SearchResultsPage;
import steps.SearchResultsSteps;


public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() throws InterruptedException {

        driver.get("https://www.delivery-club.ru/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Delivery Club — Доставка еды и продуктов"));
        Thread.sleep(2000);
    }

    @Test
    public void firstTest2() throws InterruptedException {
        driver.get("https://www.delivery-club.ru/moscow");

        WebElement profitButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div[4]/label"));          //выполняем поиск по локатору (кнопка "Акции")
        Thread.sleep(2000);
        //profitButton.click();

        //WebElement resultRow = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div/div/div[2]/div/div/ul/li[4]/a/span[2]/span[1]/span/h3"));

        //assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        //assertThat(resultRow.getText()).as("Wrong text has been displayed!").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");

        //Assert.assertTrue(resultRow.equals("ФИЛАДЕЛЬФИЯ"));
    }


}


////*[@id="content"]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/div[4]/label
////*[@id="content"]/div/div[2]/div[2]/div/div/div[2]/div/div/ul/li[4]/a/span[2]/span[1]/span/h3