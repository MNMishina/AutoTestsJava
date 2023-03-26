package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BaseTest {
    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs() {
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();

        //for(int i = 0; i <hrefs.size(); i++) {            //1й вариант перебора элементов href из коллекции
        //links.add(hrefs.get(i).getAttribute("href"));
        //}
        //for (SelenideElement element : hrefs) {             //2й вариант перебора элементов href из коллекции
        //  links.add(element.getAttribute("href"));
        //}
        hrefs.forEach(x -> links.add(x.getAttribute("href"))); //3й вариант перебора элементов href из коллекции

        //1й вариант
        //links.forEach(Selenide::open);  //ссылочный метод открытия всех ссылок (href)
        //links.forEach(x->Selenide::open); // с использованием лямбды
/*
        for(int i = 0; i<links.size(); i++) {
            String listUrl = links.get(i);
            Selenide.open(listUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl(); // получение текущей ссылки из браузера
            Assert.assertEquals(currentUrl, listUrl);
        }

       //2й вариант
        while (links.size() > 0) {
            int randomNumber = new Random().nextInt(links.size());
            Selenide.open(links.get(randomNumber));
            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());  //удаляет текущую ссылку, чтобы она не повторялась при выдаче ссылок в рандомном порядке
        }

 */
        //3й вариант
        List<Integer> linksLenght = hrefs.stream().map(x -> x.getAttribute("href").length()).collect(Collectors.toList());
        int a = 0;
    }
}
