import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
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
        WebElement addButton = browser.findElement(By.xpath("//*[@onclick='addElement()']"));
        addButton.click();
        addButton.click();

        List<WebElement> deleteButtons = browser.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        deleteButtons.get(1).click();
        List<WebElement> deleteButtons1 = browser.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertEquals(deleteButtons1.size(), 1, "Кол-во кнопок не равняется единице!");
        browser.quit();
    }

}
