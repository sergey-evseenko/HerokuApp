import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HTML {

    @Test
    public void openHTML() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("file://C:\\Users\\syaus\\IdeaProjects\\HerokuApp2\\src\\main\\resources\\Lesson7.html");
    }
}
