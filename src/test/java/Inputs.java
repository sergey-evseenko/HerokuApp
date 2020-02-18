import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Inputs {

    @Test
    public void inputsByArrow() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/inputs");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element = webDriver.findElement(By.xpath("//*[@type='number']"));
        element.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN);

        String value = element.getAttribute("value");
        assertEquals(value, "1", "Неверное значение!");
        webDriver.quit();
    }

}
