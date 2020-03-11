import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControls {
    @Test
    public void dynamicControls() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        assertEquals(driver.findElements(By.id("checkbox")).size(), 1, "CheckBox is not displayed!");
        driver.findElement(By.cssSelector("*[onclick='swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertEquals(driver.findElements(By.id("checkbox")).size(), 0, "CheckBox is displayed!");

        assertFalse(driver.findElement(By.cssSelector("input[type='text']")).isEnabled(), "The field is not disabled");
        driver.findElement(By.cssSelector("*[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(driver.findElement(By.cssSelector("input[type='text']")).isEnabled(), "The field is disabled");

        driver.quit();
    }
}
