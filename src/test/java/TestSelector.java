import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelector {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //driver.manage().window().maximize();

            //lokalizowanie z apomocą ID
        By buttonID = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonID);
      //  clickOnMeButton.click();

          //lokalizowanie za pomocą name
        By firstname = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstname);
        driver.findElement(By.name("fname")); // inny zapis bez rozkłądania na zmienne

            //lokalizowanie za pomocą class
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

            //lokalizowanie za pomocą tagu html (input) LISTA !!
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);  //jezeli jest wiecej input to zostanie odszukany pierwszy na liscie
        input.sendKeys("Pierwszy");  //wpisujemy wartosc do 1 cokatora input zeby potwierdzic ze on jest pierwszy
        List<WebElement> inputs = driver.findElements(inputLocator); // tworzenie listy wszytskich lokatoró input na stornie
        System.out.println(inputs.size()); //wypisanie ilosci inputów

            //lokalizaownie linow z tekstem
        By linkText = By.linkText("Visit W3Schools.com!"); //musiy być wpisany cały tekst
        WebElement testLink = driver.findElement(linkText);

        By partialText = By.partialLinkText("Visit"); //wystarczy podać jeden człon z tekstu
        WebElement testPartial = driver.findElement(partialText);

            //lokazlizowanie za pomocą CSS







    }
}
