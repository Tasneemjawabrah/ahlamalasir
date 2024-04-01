package com.example.projectsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class signup  implements Initializable {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";


    static Logger logger = Logger.getLogger(signup.class.getName());
    public TextField id;
    public TextField fname;
    public TextField lname;
    public TextField username;
    public TextField email;
    public TextField passs;
    @FXML
    private TextField code1;

    public Button backsign;
    public Button sv;


    @FXML
    private ChoiceBox<String> checkbox = new ChoiceBox<>();
    private String[] pai = {"customer"};


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        checkbox.getItems().addAll(pai);
    }

    public void backsignn(ActionEvent event) {

        try {
            Parent root;

            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(ActionEvent event) {
        int idValue = Integer.parseInt(id.getText());
        String fnameValue = fname.getText();
        String lnameValue = lname.getText();
        String usernameValue = username.getText();
        String emailValue = email.getText();
        String passwordValue = passs.getText();
        String roleValue = checkbox.getValue();
        String code = code1.getText();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME,  getPasswordFromEnvironment() )) {
            String sql = "INSERT INTO software.users (userid, firstname, lastname, username, password, email, role,code) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, idValue);
                preparedStatement.setString(2, fnameValue);
                preparedStatement.setString(3, lnameValue);
                preparedStatement.setString(4, usernameValue);
                preparedStatement.setString(5, passwordValue);
                preparedStatement.setString(6, emailValue);
                preparedStatement.setString(7, roleValue);
                preparedStatement.setString(8, code);


                preparedStatement.executeUpdate();
                showAlert("User successfully inserted into the database.");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sing up");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }


    public static boolean gmailTest(String gmail) {
        if (Character.isDigit(gmail.charAt(0)) || gmail.length() < 11) return false;
        else {
            boolean flag = false;
            for (int i = 1; i < gmail.length(); i++) {
                if (gmail.charAt(i) == '@') flag = true;
            }
            return flag;
        }
    }

    public static boolean nameTest(String name) {

        return name != null && name.trim().length() >= 2;
    }


    public static boolean passwordTest(String password) {
        boolean flags = false;
        boolean flagc = false;
        boolean flagn = false;
        if (password.length() < 4) return false;
        else {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLowerCase(password.charAt(i))) flags = true;
                else if (Character.isUpperCase(password.charAt(i))) flagc = true;
                else if (Character.isDigit(password.charAt(i))) flagn = true;
            }
            return flags && flagc && flagn;
        }
    }



    public static boolean idTest(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME,  getPasswordFromEnvironment() );
            String sql = "SELECT COUNT(*) FROM software.users WHERE CAST(userid AS TEXT) = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    return false;
                }
                return id.length() > 2;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



    public static boolean selectRole(String roleName) {
        return roleName.equalsIgnoreCase("Customer");
    }



    private static boolean isEmailAlreadyRegistered(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME,  getPasswordFromEnvironment() );
            String sql = "SELECT COUNT(*) FROM software.users WHERE email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean registerWithExistingEmail(String email) {

        if (isEmailAlreadyRegistered(email)) {

            return true;
        } else {

            return false;
        }
    }
     private static String getPasswordFromEnvironment() {
        String password = System.getenv("1482003");
        if (password == null) {
            throw new IllegalStateException("Database password not found in environment variables.");
        }
        return password;
    }

}
