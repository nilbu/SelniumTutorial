package pl;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PracaDomowaSprSelecta {

    // metoda ktora przyjmuje String jak paramter i zwraca typ boolean(drugi parametr po t zeby mozna bylo korzystac z tej metody w innych elementach)
    // metoda sprawdza czy parametr String jest jedna z opcji Select

    public boolean check(String optionText, WebElement element) {  //metoda zwaraca boolean


        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for(WebElement option : options) {
            if(option.getText().equals(optionText))
                return true;
        }
        return false;




    }
}
