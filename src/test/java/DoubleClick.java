import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);
        actions.doubleClick().perform(); //podwojne klikniecie w randomowym miejscu, zazwyczaj prawy gorny rog strony

        actions.doubleClick(driver.findElement(By.id("bottom"))).perform(); //podwojne klikniecie w wybranym miejscu

    }
}
