import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class klikPPM {
    @Test
    public void klikPPM(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        Actions actions = new Actions(driver); //przekazujemy webdrivera do klasy actions
       // actions.contextClick().perform(); //klikanie randomowo na stornie/ perform = przekaż

        actions.contextClick(driver.findElement(By.id("myFile"))).perform(); //klikanie juz na ustalony element(contexClick z webelement)



    }
}
