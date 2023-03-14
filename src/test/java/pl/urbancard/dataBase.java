package pl.urbancard;

import java.sql.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataBase {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();


        // Tworzenie obiektu WebDriver
        WebDriver driver = new ChromeDriver();

        // Łączenie się z bazą danych Postgres
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.153:5432/oauth", "oauth", "NSwbvKTyJ2MH3gZBM06L");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Wykonanie zapytania SELECT
        String query = "SELECT nazwa_pola FROM nazwa_tabeli WHERE id = '1'";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            String nazwa_pola = rs.getString("nazwa_pola");

            // Otworzenie strony internetowej i sprawdzenie wartości w polu za pomocą CSS selector
            driver.get("https://www.strona_internetowa.pl");
            WebElement pole = driver.findElement(By.cssSelector("[nazwa_atrybutu='" + nazwa_pola + "']"));
            String wartość = pole.getText();
            System.out.println("Wartość w polu: " + wartość);

        } catch (SQLException | NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                driver.quit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
