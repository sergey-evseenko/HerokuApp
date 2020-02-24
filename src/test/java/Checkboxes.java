import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes {

    @Test
    public void checkboxesClicks() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement checkBox1 = browser.findElement(By.xpath("//*[@type='checkbox']"));

        boolean isSelect = checkBox1.isSelected();
        assertFalse(isSelect, "Error. CheckBox1: Элемент выбран!");
        checkBox1.click();
        isSelect = checkBox1.isSelected();
        assertTrue(isSelect, "Error. CheckBox1: Элемент не выбран!");

        List<WebElement> checkBoxes = browser.findElements(By.xpath("//*[@type='checkbox']"));
        WebElement checkBox2 = checkBoxes.get(1);

        isSelect = checkBox2.isSelected();
        assertTrue(isSelect, "Error. CheckBox2: Элемент не выбран!");
        checkBox2.click();
        isSelect = checkBox2.isSelected();
        assertFalse(isSelect, "Error. CheckBox2: Элемент выбран!");
        browser.quit();
    }

}
