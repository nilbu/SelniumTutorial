package pl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionTest {

    @Test
    public void akcje () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String www = "https://testeroprogramowania.github.io/selenium/";
        driver.get(www);

        WebElement basicPagerlink = driver.findElement(By.partialLinkText("Podstawowa"));
        basicPagerlink.click();
       // driver.findElement(By.id("clickOnMe")).click(); //klikniecie na element
        driver.findElement(By.id("fname")).sendKeys("Test");  //wpisywanie do komórki
        By username = By.name("username");
        driver.findElement(username).click();
        driver.findElement(username).sendKeys(Keys.ENTER);

        //obsługa alertu
        Alert alert = driver.switchTo().alert(); //pierwszy alert
        alert.accept();
        driver.switchTo().alert().accept(); //drugi alert


        driver.findElement(By.name("username")).clear();  //czysczenie komórki
        driver.findElement(By.name("username")).sendKeys("admin"); //wpisywanie wartości do komórki


        WebElement pass = driver.findElement(By.name("password"));
        System.out.println(pass.getAttribute("value")); //pobieranie zawartośći z pola tekstowego

        driver.findElement(By.cssSelector("[type='checkbox'")).click(); //klikniecie checkboxa
        driver.findElement(By.cssSelector("[value='male']")).click(); //klikniecie radiobutton

        //obsługa selecta - pola wyboru
        WebElement selectCar = driver.findElement(By.cssSelector("select")); //szukanie elementu i zapis do zeminnej
        Select cars = new Select(selectCar); //przypisanie metody Select do wyszukanej zmiennej i nadanie nowe (obiekt klasy select)
        cars.selectByIndex(2); //wywołanie akcji na elemencie po nr indexu na liście
        cars.selectByVisibleText("Saab"); // wywołanie akcji po widzialnym tekscie
        cars.selectByValue("volvo"); //wywołanie akcji po atrybucie value

        //pobieranie opcji z Selecta - pola wyboru
        List<WebElement> options = cars.getOptions();  //przypisanie wyniku metodoy getOptions do zmiennej - tworzymy liste

        //wypisanie wszytskich elementow za pomoca petli for
        for (WebElement option : options) {         //dla każdego elementu z kolekcji options (która zawiera obiekty typu WebElement), kod wewnątrz pętli zostanie wykonany raz. W trakcie każdej iteracji, wartość obiektu WebElement będzie przechowywana w zmiennej option, która może być używana do wykonywania różnych działań na elemencie.
            System.out.println(option.getText());
        }

        //zadanie domowe
        PracaDomowaSprSelecta SelectCheck  = new PracaDomowaSprSelecta();  //obiekt klasy PracaDomowaSprSelecta
        System.out.println(SelectCheck.check("Audi", selectCar)); //check to metoda klasy PracaDomowaSprSelecta
        System.out.println(SelectCheck.check("Jeep", selectCar));

        //pobieranie wartosci z ukrytego elementu
        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println(para.getAttribute("textContent"));
















    }
}
