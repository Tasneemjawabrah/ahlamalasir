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
    private static final String PASSWORD = getPasswordFromEnvironment();
      private static final Logger logger = Logger.getLogger(signup.class.getName());
    
    private static String getPasswordFromEnvironment() {
    String password = System.getenv("1482003");
    if (password == null) {
        throw new IllegalStateException("Database password not found in environment variables.");
    }
    return password;
    }
  
   private TextField id;

public TextField getId() {
    return id;
}

public void setId(TextField id) {
    this.id = id;
}
 
    @FXML
    private TextField code1;

      private TextField fname;
    private TextField lname;
    private TextField username;
    private TextField email;
    private TextField passs;
    private Button backsign;
    private Button sv;

    public TextField getFname() {
        return fname;
    }

    public void setFname(TextField fname) {
        this.fname = fname;
    }

    public TextField getLname() {
        return lname;
    }

    public void setLname(TextField lname) {
        this.lname = lname;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getPasss() {
        return passs;
    }

    public void setPasss(TextField passs) {
        this.passs = passs;
    }

    public Button getBacksign() {
        return backsign;
    }

    public void setBacksign(Button backsign) {
        this.backsign = backsign;
    }

    public Button getSv() {
        return sv;
    }

    public void setSv(Button sv) {
        this.sv = sv;
    }


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
         throw new FileOperationException("Error while performing file operation", e);
}
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

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
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
            logger.severe("Error while checking availability:");
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
    boolean hasLowercase = false;
    boolean hasUppercase = false;
    boolean hasDigit = false;

    if (password.length() < 4) {
        return false;
    }

    for (char c : password.toCharArray()) {
        if (Character.isLowerCase(c)) {
            hasLowercase = true;
        } else if (Character.isUpperCase(c)) {
            hasUppercase = true;
        } else if (Character.isDigit(c)) {
            hasDigit = true;
        }
    }

    return hasLowercase && hasUppercase && hasDigit;
}


    public static boolean idTest(String id) {
     try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
         PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM software.users WHERE CAST(userid AS TEXT) = ?");
    ) {
        statement.setString(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    return false;
                }
                return id.length() > 2;
            }
        }
    } catch (SQLException e) {
       throw new FileOperationException("Error while performing file operation", e);
    }
    return false; 
    }



    public static boolean selectRole(String roleName) {
        return roleName.equalsIgnoreCase("Customer");
    }



    private static boolean isEmailAlreadyRegistered(String email) {
     try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
         PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM software.users WHERE email = ?");
    ) {
        statement.setString(1, email);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    } catch (SQLException e) {
      logger.severe("Error while checking availability:");
    }
    return false;
    }
    public static boolean registerWithExistingEmail(String email) {

     return isEmailAlreadyRegistered(email);
    }
}
