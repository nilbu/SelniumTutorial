import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class WebDriverTestManager {
    @Test
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('hello')");
        driver.get("https://www.google.com");

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver foxDriver = new FirefoxDriver();
//
//        WebDriverManager.iedriver().setup();
//        WebDriver ieDriver = new InternetExplorerDriver();

//        WebDriverManager.edgedriver().setup();
//        WebDriver edgeDriver = new EdgeDriver();
//
//
//       // edgeDriver.manage().window().maximize(); //max rozmiar
//      //  Dimension windowsSize = new Dimension(400,400);  //wlk okna przegladarki
//         // edgeDriver.manage().window().setSize(windowsSize);
//       //   edgeDriver.quit();
//
//        //Java script executor
//
//        JavascriptExecutor executor = (JavascriptExecutor) edgeDriver;
//        executor.executeScript("alert('hello')");
//
//        edgeDriver.get("https://google.com");
//        //  edgeDriver.quit();

    }
}
