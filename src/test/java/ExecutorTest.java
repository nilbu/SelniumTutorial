import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutorTest {
    @Test
    public void executeJavaScript(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPagelink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        //symulacja klikniecia z apomocą JavaScripetExecutor (click)
        JavascriptExecutor executor = (JavascriptExecutor) driver; //kastoawnie drivera do java script egzekutora
        executor.executeScript("arguments[0].click();",basicPagelink);
        //wprowadzenie wartosci za pomocą JavaScriptExecutor(Sendkeys)
        WebElement firstName = driver.findElement(By.name("fname"));
        executor.executeScript("arguments[0].setAttribute('value','Tomek');",firstName);





    }
}
