import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class NewWindowTest {
    @Test
    public void testNewWindow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String currentWindow = driver.getWindowHandle();  //pobiera i przypisuje nazwe pierwotnego okna przeglądarki
        driver.findElement(By.id("newPage")).click();
        Set<String> windowsNames = driver.getWindowHandles(); //metoda zwaraca zbiór stringów nazwy okien wszyskich okien ktore sa dostepne
        // sprawdzanie czy nazwa okna jest rożna od okna w ktrym jestesmy(currenWindows), jezeli tak to przełączamy
        for(String window : windowsNames) {
            if(!window.equals(currentWindow)) {  //spr czy okno podsatwowe jest rozne od od zbioru pobranych okien
                driver.switchTo().window(window); //przelacznie na okno inego od pierwotnego
            }
        }
        driver.findElement(By.cssSelector("#L2AGLb > div")).click(); //akceptacja cookie
        driver.findElement(By.name("q")).sendKeys("Selenium");

        driver.switchTo().window(currentWindow);  //przełaczenie do pierwotnego okna
        driver.findElement(By.name("fname")).sendKeys("Tomek");

        //przechodzenie miedzy kartami w przeglądarce

        // pobierz listę kart (handles) do aktualnie otwartych kart
        Set<String> handles = driver.getWindowHandles();

        // zapisz listę kart do ArrayList
        ArrayList<String> tabs = new ArrayList<>(handles);

        // przejdź do nowej karty
        driver.switchTo().window(tabs.get(1));


    }
}
