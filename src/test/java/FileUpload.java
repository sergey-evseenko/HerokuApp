import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUpload {
    @Test
    public void fileUpload() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.findElement(By.id("file-upload"));
        String url = File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "my_file.pdf";
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + url);
        driver.findElement(By.id("file-submit")).click();
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(fileName, "my_file.pdf", "File upload error!");
        driver.quit();
    }
}
