import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadTest {
    @Test
    public void UploadFile(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        WebElement upload = driver.findElement(By.id("myFile"));
        upload.sendKeys("C:\\Users\\tbielawski\\Downloads\\cacert.der");
        //alternatywny sposób za pomocą zew aplikacji "SiculliX"
    }
}
