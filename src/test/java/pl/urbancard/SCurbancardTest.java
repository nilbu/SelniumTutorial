package pl.urbancard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

public class SCurbancardTest {

    @Test
    public void logowanie () throws InterruptedException, SQLException, ClassNotFoundException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    String www = "http://sc-wroclaw.aws.mennica.net/";
   // driver.get(www);
      WebDriverWait wait = new WebDriverWait(driver,10);
  //  String defwindow = driver.getWindowHandle(); //zmienna na defaultowe okno

        //ASERCJA Z DANYMI W BAZIE

        String dbUrl = "jdbc:mysql://192.168.65.153:5432/oauth";
        String username = "oauth";
        String password = "NSwbvKTyJ2MH3gZBM06L";



    //logowanie
        By userNAme = By.cssSelector("#_username");
        driver.findElement(userNAme).sendKeys("tbielawski");

        By pass = By.cssSelector("#_password");
        driver.findElement(pass).sendKeys("Bulinek34!");
        driver.findElement(pass).sendKeys(Keys.ENTER);



        //spr raportu

       //Thread.sleep(8000);

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu > li.nav-item.item-44.last.deeper.parent > a > span")));
       By raport = By.cssSelector("#menu > li.nav-item.item-44.last.deeper.parent > a > span");
       driver.findElement(raport).click();
        //raport sprzedaży

        //trzy te same zapisy
    //    By raportSprz = By.xpath("//*[@id=\'sub-item-44\']/li[1]/a"); //alternatywny zapis ze zmienna
    //    driver.findElement(raportSprz).click();

   //     WebElement raportSprz = driver.findElement(By.xpath("//*[@id=\'sub-item-44\']/li[1]/a"));  //alternatywny zapis ze zmienną
   //     raportSprz.click();

        driver.findElement(By.xpath("//*[@id=\'sub-item-44\']/li[1]/a")).click(); //zapis w jednej linijce



        //Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'sub-item-45\']/li[1]/a")));

        By raportSprz1 = By.xpath("//*[@id=\'sub-item-45\']/li[1]/a");
        driver.findElement(raportSprz1).click();

        By raportSprz2 = By.xpath("//*[@id=\'report_form_dateRange_range_3\']");
        driver.findElement(raportSprz2).click();

        By raportSprz3 = By.cssSelector("#report_form_submit_reportSubmit");
        driver.findElement(raportSprz3).click();

        // pobierz listę kart (handles) do aktualnie otwartych kart
        Set<String> handles = driver.getWindowHandles();

        // zapisz listę kart do ArrayList
        ArrayList<String> tabs = new ArrayList<>(handles);

        // przejdź do nowej karty
        driver.switchTo().window(tabs.get(1));


      //  By newraport = By.cssSelector("body > div > div > div > div > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)");

        //lokalizowanie z apomocą selektora
        WebElement displayRaport = driver.findElement(By.cssSelector("body > div > div > div > div > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)"));
        System.out.println(displayRaport.getText()); // inny zapis dla pobrania tekstu
        // pobierz tekst z elementu
        String elementText = displayRaport.getText();
        //wyswietlanie
        System.out.println(elementText);

        //asseracja
        Assert.assertTrue(displayRaport.isDisplayed());

        // przejdź poprzedniej karty (atrybut w nawiasie okresla liczbe kolejnosci kart)
        driver.switchTo().window(tabs.get(0));

        //kliknij w miesiace
        By raportSprz4 = By.cssSelector("#report_form_dateRange_range_1");
        driver.findElement(raportSprz4).click();

//
//
//        // Sprawdzenie, czy pole z podanym selektorem CSS zawiera oczekiwany tekst
//        WebElement usernameField = driver.findElement(By.cssSelector("input[type='text']"));
//        String actualUsername = usernameField.getText();
//        if (expectedUsername.equals(actualUsername)) {
//            System.out.println("Pole zawiera oczekiwany tekst.");
//        } else {
//            System.out.println("Pole nie zawiera oczekiwanego tekstu.");
//        }









    }
}
