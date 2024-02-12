package MySQL_DataBase;

import LoginFrame.LoginScreen;
import OnlineLiabry.LiabaryFrame;

import javax.swing.*;
import java.sql.*;

public class DataBaseDriver {


    public DataBaseDriver() {


    }

    public void addingBookToDatabase( String book) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

            // Verwende PreparedStatement, um SQL-Injection zu verhindern
            String sql = "INSERT INTO accounts (ausgehlihenes_buch) VALUES (?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                // Setze die Werte für die Platzhalter
                preparedStatement.setString(1, book);


                // Führe die Aktualisierung durch
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Buch wurde Erfolgreich in die Datenbank geladen");
                } else {
                    JOptionPane.showMessageDialog(null, "Buch wurde nicht in die Datenbank geladen");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void addingDataToDatabase(String email, String passwort, String username) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

            // Verwende PreparedStatement, um SQL-Injection zu verhindern
            String sql = "INSERT INTO accounts (email, passwort, username) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                // Setze die Werte für die Platzhalter
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, passwort);
                preparedStatement.setString(3, username);

                // Führe die Aktualisierung durch
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Daten wurden Erfolgreich in die Datenbank geladen");
                } else {
                    JOptionPane.showMessageDialog(null, "Daten wurden nicht in die Datenbank geladen");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean userAuthentication(String username, String passwort) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            String sql = "SELECT * FROM accounts WHERE username = ? AND passwort = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, passwort);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    JOptionPane.showMessageDialog(null, "User" + username + " Wurde Eingeloggt");
                    new LiabaryFrame().createLibaryFrame();
                    new LoginScreen().setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Login-Fehlgeschlagen , Benutzer oder falsches Passwort");
                    return false;
                }


            }

        } catch (SQLException exception) {
            exception.printStackTrace();

        }

        return false;


    }


    public boolean login(String username) {
        try {
            // Verbindung zur Datenbank
            String url = "jdbc:mysql://localhost:3306/myDB";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            // SQL-Abfrage für den Login
            String query = "SELECT * FROM accounts WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next(); // Gibt true zurück, wenn der Benutzer gefunden wurde




            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
