import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShotTest {
    @Test
    public void ScreenShot() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int randomNumber = (int) (Math.random()*1000); //kastowane bo math() zwaraca double, zmienna potrzebna do unikalnej nazwy pliku
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\tbielawski\\Downloads\\cacert.der");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE); //przyspianie do zmienny typu File
        //zapisywanie do pliku, ale za kazdym razem jest nadpisywany
       // FileUtils.copyFile(srcFile,new File("src/test/resources/scrennshot.png")); //trzeba stworzyc katalog i najlepiej go oznaczyc"make directory as"

        //zapisywanie do pliku o unikalnej nazwie
        String fileName = "innaNazwa" + randomNumber + ".png";
        FileUtils.copyFile(srcFile,new File("src/test/resources/" + fileName));


    }
}
