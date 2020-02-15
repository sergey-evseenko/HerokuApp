import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements {
    @Test
    public void addTwoElements() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element1 = browser.findElement(By.xpath("//*[@onclick='addElement()']"));
        element1.click();
        element1.click();

        WebElement element2 = browser.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        element2.click();

        //зобаем список и добавляем туда список web элементов
        ArrayList<WebElement> deleteButtons = new ArrayList<WebElement>();
        deleteButtons.addAll(0, browser.findElements(By.xpath("//*[@onclick='deleteElement()']")));

        //проходим итератором по списку и считаем кол-вол элементов
        int n = 0;
        for (WebElement item : deleteButtons) {
            n++;
        }
        assertEquals(n, 1, "Кол-во кнопок не равняется единице!");
        browser.quit();

    }

}
