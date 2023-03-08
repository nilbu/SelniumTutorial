import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {
    @Test
    public void ImageTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        WebElement image = driver.findElement(By.tagName("img"));
        //sprawdzanie czy obrazek sie wyweitlił
        //pobiermay jego arybut np wysokosc, jezeli obraze jest na stornie to wyswietli sie jego rozmiar, jezeli nei to nei istnieje
        System.out.println(image.getAttribute("naturalHeight"));

        //pobieranie danych an temat obrazka ze storny na ktorej nie jest on wczytany
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement image1 = driver.findElement(By.tagName("img"));
        String height = image1.getAttribute("naturalHeight");

        Assert.assertEquals("0",height);   //spr za pomocą asercji



    }
}
