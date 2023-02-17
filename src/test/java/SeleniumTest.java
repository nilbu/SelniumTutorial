import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class SeleniumTest {

    @Test

    public void openGooglePage() {
        //CHROME start
//        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\chromedriver_win32\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", path);
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
        // FIREFOX start
//        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\geckodriver-v0.32.2-win64\\geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", path);
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://google.com");
        //IE start
//        String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\IEDriverServer_x64_4.8.0\\IEDriverServer.exe";
//        System.setProperty("webdriver.ie.driver", path);
//        WebDriver driver = new InternetExplorerDriver();
//        driver.get("https://google.com");

    WebDriver driver = getDriver("chrome");
    driver.get("https://google.com");
    driver.manage().window().maximize();
    // przechodzimy do wew okienka z plikami cookie
  //  driver.switchTo().frame(0);
    //znajdowanie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();
        // pole do wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium");
        searchField.sendKeys(Keys.ENTER);
        //znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());




    }

    public WebDriver getDriver(String browser){

       // String Path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\chromedriver.exe";  // nie potrzebna jest sciezka bo zostala dodana do zmiennych srodowiskowych

        if(browser == "chrome")   {
           // String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\chromedriver_win32\\chromedriver.exe";
        //    System.setProperty("webdriver.chrome.driver");
            return new ChromeDriver();

            //driver.get("https://google.com");
        }else if(browser == "firefox"){
           // String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\geckodriver.exe";
          //  System.setProperty("webdriver.gecko.driver", path);
            return new FirefoxDriver();
        } else if (browser == "ie") {
            // String path = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\IEDriverServer.exe";
           //  System.setProperty("webdriver.ie.driver", path);
             return new InternetExplorerDriver();
        }  else throw new InvalidArgumentException("Podaj prawidłową nazwę");

        //przykład drugi
//            switch (browser){
//                case "chrome":
//                    String chromePath = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\chromedriver_win32\\chromedriver.exe";
//                    System.setProperty("webdriver.chrome.driver", chromePath);
//                    return new ChromeDriver();
//                case "firefox":
//                    String firefoxPath = "C:\\Users\\Mennica\\Documents\\Automaty\\WebDriver\\geckodriver-v0.32.2-win64\\geckodriver.exe";
//                    System.setProperty("webdriver.gecko.driver", firefoxPath);
//                    return new FirefoxDriver();
//                default:
//                    throw new InvalidArgumentException("Bledna dana");
//            }


    }

}
