import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Frames {
    @Test
    public void frame() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String text = driver.findElement(By.id("tinymce")).getText();
        assertEquals(text, "Your content goes here.", "Invalid text!");
        driver.quit();
    }
}
