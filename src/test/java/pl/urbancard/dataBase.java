package pl.urbancard;

import java.sql.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataBase {
    public static void main(String[] args) throws SQLException {
        WebDriverManager.chromedriver().setup();
//
//
//        // Tworzenie obiektu WebDriver
//        WebDriver driver = new ChromeDriver();
//
//        // Łączenie się z bazą danych Postgres
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:postgresql://192.168.65.153:5432/oauth", "oauth", "NSwbvKTyJ2MH3gZBM06L");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // Wykonanie zapytania SELECT
//        String query = "SELECT nazwa_pola FROM nazwa_tabeli WHERE id = '1'";
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(query);
//            rs.next();
//            String nazwa_pola = rs.getString("nazwa_pola");
//
//            // Otworzenie strony internetowej i sprawdzenie wartości w polu za pomocą CSS selector
//            driver.get("https://www.strona_internetowa.pl");
//            WebElement pole = driver.findElement(By.cssSelector("[nazwa_atrybutu='" + nazwa_pola + "']"));
//            String wartość = pole.getText();
//            System.out.println("Wartość w polu: " + wartość);
//
//        } catch (SQLException | NoSuchElementException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//                driver.quit();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        String dbUrl = "jdbc:postgresql://192.168.65.153:5432/oauth";
        String username = "oauth";
        String password = "NSwbvKTyJ2MH3gZBM06L";

        // Ustanowienie połączenia z bazą danych
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // Wykonanie zapytania SELECT
        String schemaName = "ticket";
        String tableName = "card_active";
        String query = "SELECT * FROM " + schemaName + "." + tableName;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        String expectedName = null;
        if (resultSet.next()) {
            expectedName = resultSet.getString("cardno");
            System.out.println(expectedName);
        }


        WebDriver driver = new ChromeDriver();

        // Otwarcie strony internetowej
        driver.get("http://www.example.com");

        // Sprawdzenie, czy pole z podanym selektorem CSS zawiera oczekiwany tekst
        WebElement usernameField = driver.findElement(By.cssSelector("input[type='text']"));
        String actualUsername = usernameField.getText();
        if (expectedUsername.equals(actualUsername)) {
            System.out.println("Pole zawiera oczekiwany tekst.");
        } else {
            System.out.println("Pole nie zawiera oczekiwanego tekstu.");
        }

        // Zamknięcie połączenia z bazą danych i przeglądarką
        connection.close();
        driver.quit();
    }
}

