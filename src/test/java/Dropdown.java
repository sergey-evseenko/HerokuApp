import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Dropdown {

    @Test
    public void dropdownClick() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/dropdown");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select drpOptions = new Select(browser.findElement(By.id("dropdown")));

        drpOptions.selectByIndex(1);
        String selectedValue = drpOptions.getFirstSelectedOption().getAttribute("innerText");
        assertEquals(selectedValue, "Option 1", "Выбрана неверная опция!");

        drpOptions.selectByIndex(2);
        selectedValue = drpOptions.getFirstSelectedOption().getAttribute("innerText");
        assertEquals(selectedValue, "Option 2", "Выбрана неверная опция!");

        browser.quit();

    }
}
