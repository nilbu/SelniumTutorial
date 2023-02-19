import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class urbancardTest {

    @Test
    public void formularz () throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String www = "https://www.urbancard.pl/wniosek-o-wydanie-karty";
        driver.get(www);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("disable-infobars");
//        options.addArguments("--disable- ");
//        WebDriver driver1 = new ChromeDriver(options);
//        driver1.get(www);



      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); - działa tylko na "findElement"

                //wait
          // WebDriverWait wait = new WebDriverWait(driver, 10);

           //driver.navigate().to(www);


        By cookie = By.cssSelector("#cookie_accept > a");
        driver.findElement(cookie).click();



            // RECAPTCHA 1 sposób AI

//        // Zlokalizowanie elementu reCAPTCHA
//        WebElement recaptcha = driver.findElement(By.cssSelector("iframe[src^='https://www.google.com/recaptcha']"));
//
//        // Przełączenie do ramki, w której znajduje się reCAPTCHA
//        driver.switchTo().frame(recaptcha);
//
//        // Zlokalizowanie elementu checkboxa reCAPTCHA
//        WebElement checkbox = driver.findElement(By.id("recaptcha-anchor"));
//
//        // Kliknięcie w checkbox reCAPTCHA
//        Actions builder = new Actions(driver);
//        builder.moveToElement(checkbox).click().build().perform();
//
//        // Przełączenie z powrotem do głównego ramki strony
//        driver.switchTo().defaultContent();


                //próby ze sctacover
        //reCaptcha
     //   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds( 15 ));
     //   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")));
     //   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#div.recaptcha-checkbox-border")));

       // new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
       // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
       // By reCaptcha = By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-checkmark");
        //driver.findElement(reCaptcha).click();

        By pesel = By.cssSelector("div + input");
        driver.findElement(pesel).sendKeys("63111061410");



        By imie = By.cssSelector("#firstnameTxt");
        driver.findElement(imie).sendKeys("Test");

        By nazwisko = By.cssSelector("#lastnameTxt");
        driver.findElement(nazwisko).sendKeys("Selenium");

        By ulica = By.cssSelector("#streetTxt");
        driver.findElement(ulica).sendKeys("Złota");

        By miasto = By.cssSelector("#cityTxt");
        driver.findElement(miasto).sendKeys("Wrocław");

        By kodpPcztowy = By.cssSelector("#postalCodeTxt");
        driver.findElement(kodpPcztowy).sendKeys("50-001");

        By nrDomu = By.cssSelector("#houseNumberTxt");
        driver.findElement(nrDomu).sendKeys("17");

        By nrMieszkania = By.cssSelector("#apartmentNumberTxt");
        driver.findElement(nrMieszkania).sendKeys("66");

        By nrTelefonu = By.cssSelector("#phoneNumberTxt");
        driver.findElement(nrTelefonu).sendKeys("666444555");

        By email = By.cssSelector("#emailTxt");
        driver.findElement(email).sendKeys("mennicatest@gmail.com");

        By checkBox = By.cssSelector("#ctl00_mainContent_ctl00_consentRepeater_ctl00_ischeckedRepeater");
        driver.findElement(checkBox).click();

        By checkBox1 = By.cssSelector("#ctl00_mainContent_ctl00_consentRepeater_ctl01_ischeckedRepeater");
        driver.findElement(checkBox1).click();

     //   driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();



        //DODAJ ZDJECIE od AI
        // Włączenie możliwości wyboru pliku z lokalnego systemu
        ((RemoteWebElement) driver.findElement(By.cssSelector("input[type='file']")))
                .setFileDetector(new LocalFileDetector());

        // Kliknięcie w przycisk "Dodaj zdjęcie"
     //   WebElement addFileButton = driver.findElement(By.cssSelector("#wrapper > span"));
     //   addFileButton.click();

        // Wybór pliku z lokalnego dysku
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys("C:\\Users\\Mennica\\Documents\\Bez nazwy2.png");

        // Zatwierdzenie wybranego pliku
//        WebElement submitButton = driver.findElement(By.cssSelector("input[name='Otwórz']"));
//        submitButton.click();

        //Zatwierdzenie ze skryptem

        // Wywołanie skryptu AutoIT do wyboru pliku
       // Runtime.getRuntime().exec("C:\\Users\\Mennica\\Documents\\Automaty\\SelOtworz.au3");

        // Oczekiwanie na przesłanie pliku
      //  Thread.sleep(2000); // czekaj 2 sekundy





        // Oczekiwanie na wczytanie reCAPTCHA
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src^='https://www.google.com/recaptcha/api2/anchor?']")));

        // Kliknięcie na pole reCAPTCHA
        WebElement captchaBox = driver.findElement(By.cssSelector("div.recaptcha-checkbox-border"));
        captchaBox.click();

        // Przełączenie na okno reCAPTCHA
       // driver.switchTo().defaultContent();
      //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src^='https://www.google.com/recaptcha/api2/bframe?']")));

        // Oczekiwanie na wyświetlenie przycisku "I'm not a robot"
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recaptcha-verify-button")));

        // Oczekiwanie na rozwiązanie reCAPTCHA przez użytkownika
       // System.out.println("Rozwiąż reCAPTCHA i wciśnij ENTER w konsoli");
        // System.in.read();

        // Powrót do głównego okna przeglądarki
        driver.switchTo().defaultContent();
        // opóżnienie na wyslij
        Thread.sleep(5000);

                //Przycisk wyslij

        By wyslij = By.cssSelector("#sendApplication");
      //  WebDriverWait wait1 = new WebDriverWait(driver, 10);                // W tym kodzie używamy klasy WebDriverWait, aby poczekać na pojawienie się elementu określonego w zmiennej wyslij. Metoda until() oczekuje na pojawienie się elementu przez 10 sekund lub aż element będzie można kliknąć (używając metody elementToBeClickable() z klasy ExpectedConditions). Następnie klikamy na element, używając sendKeys().
      // WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(wyslij));  //
      //  element.sendKeys(Keys.ENTER);
        driver.findElement(wyslij).sendKeys(Keys.ENTER);

        //wysłanie wniosku z tym samym nr PESEL
        By partialText = By.cssSelector("#cardProposal > div:nth-child(1) > div > p > span").partialLinkText("Twój wniosek nie został zarejestrowany w systemie."); //wystarczy podać jeden człon z tekstu
        WebElement testPartial = driver.findElement(partialText);
        Assert.assertTrue(testPartial.isDisplayed());


        //Przycisk Powrót
//        By powrot = By.cssSelector("#ctl00_mainContent_ctl00_panel > div > div.col-md-9 > div.col-xs-6.col-xs-offset-3.col-sm-12.col-sm-offset-0.form-group > div > div:nth-child(1) > a");
//        driver.findElement(powrot).sendKeys(Keys.ENTER);


        //Przycisk Wyczysc pole
        //By wyczysc = By.cssSelector("#clearDataBtn");
//        By wyczysc = By.xpath("//*[@id=\"clearDataBtn\"]");
//        driver.findElement(wyczysc).sendKeys(Keys.ENTER);

//        WebElement wyczysc1 = driver.findElement(By.name("ctl00$mainContent$ctl00$clearDataBtn"));
//        wyczysc1.sendKeys(Keys.ENTER);






    }
}
