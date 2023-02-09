import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test

    public void openGooglePage() {
             //CHROME start
//        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\chromedriver_win32\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", path);
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
        // FIREFOX start
//        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\geckodriver-v0.32.2-win64\\geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", path);
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://google.com");
        //IE start
        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\IEDriverServer_x64_4.8.0\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", path);
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://google.com");




    }
}
