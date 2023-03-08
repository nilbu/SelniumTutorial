import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {

    WebDriver driver;   //pole ktore dziala we wszytskich metodach
    @Test
    public void elementExistTest (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExistSecound(By.tagName("p")));
        System.out.println(elementExistSecound(By.id("topSecret")));



    }
    //sprawdzanie czy element istnieje w strukturze(html) storny, jezeli nie to test sie nie przerwie bo zainicjujemy go jako wyjatek

    //metoda ktora spr czy element istnieje i tworzy wyjatek
    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }
    //druga metoda, wyszykuje listy elementow i elementu nei bedzie na stornie bedzie rowna 0, jezeli cos znajdzie to bedzie rozna od 0
    public boolean elementExistSecound (By locator){
        return driver.findElements(locator).size() > 0;  //zwaraca listę bo jest findElement"s"

    }


}
