import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void iframe() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        //iframe przyjmujący wartosć Webelement
        WebElement iframe = driver.findElement(By.cssSelector("[src=basic.html])");
        driver.switchTo().frame(iframe);

        //iframe przyjumjący "int" przełączanie do iframe wedlug numeracji od "0"
        driver.switchTo().frame(0);
        driver.findElement(By.id("fname")).sendKeys("Tomek");

        driver.switchTo().defaultContent(); //przełaczenie do głownej strony
        System.out.println(driver.findElement(By.tagName("h1")).getText()); //wypisanie wartosci ze strony glownej


    }
}
