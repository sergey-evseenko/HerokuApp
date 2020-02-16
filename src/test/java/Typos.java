import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Typos {
    @Test
    public void checkTypos() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/typos");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element = webDriver.findElement(By.className("example"));
        String value = element.getAttribute("innerText");
        assertEquals(value, "Typos\n" +
                "\n" +
                "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                "\n" +
                "Sometimes you'll see a typo, other times you won't.", "Ошибка в написании!");
        webDriver.quit();
    }
}
