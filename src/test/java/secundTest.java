import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class secundTest {
    @Test
    public void findSelenium() {
        WebDriverManager.chromedriver().setup(); //spr czy na kompie jest zainst przeglad, jak nie to ja pobiera
        WebDriver driver = new ChromeDriver(); //uruchomienie przegladarki
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
        Assert.assertTrue(seleniumProduct.isDisplayed());

    }
}
