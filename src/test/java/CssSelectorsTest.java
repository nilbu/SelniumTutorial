import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
   public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");  // po id wpisyjemy #
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret"); // po class wpisujemy .
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input"); //po tag wystarczy sama nazwa -
        driver.findElement(cssTag).sendKeys("Pierwszy"); //wyszuka pierwszy element na stornie

        By cssName = By.cssSelector("[name='fname']");  //wpisujemy wartosc i atrybut np moze byc href=www..., albo class== przykłąd ponizej
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret ']"); //
        driver.findElement(cssClass2);

   }
}
