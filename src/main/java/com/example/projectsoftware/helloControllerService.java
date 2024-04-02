package com.example.projectsoftware;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.logging.Logger;

import java.sql.*;

public class helloControllerService {

  @FXML
    private ListView<Services> servicelist;

    @FXML
    private TextField txt2;

    private ObservableList<Services> allServices;

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = getPasswordFromEnvironment();
    private static final Logger logger = Logger.getLogger(helloControllerService.class.getName());

    @FXML
    public void initialize() {
        allServices = fetchAllServices();
        servicelist.setItems(allServices);

        txt2.textProperty().addListener((observable, oldValue, newValue) -> searchServices(newValue));
    }

    private ObservableList<Services> fetchAllServices() {
        ObservableList<Services> services = FXCollections.observableArrayList();

String query = "SELECT serviceid, servicename, description, price FROM software.services";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int serviceId = resultSet.getInt("serviceid");
                String serviceName = resultSet.getString("servicename");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int userId = resultSet.getInt("userid");
                byte imagee = resultSet.getByte("image");




                Services service = new Services(serviceId, serviceName, description, price, userId, new byte[]{imagee});
                services.add(service);
            }
        } catch (SQLException e) {
         logger.severe("Error while checking availability:");
        }

        return services;
    }

    private void searchServices(String query) {
        ObservableList<Services> filteredServices = FXCollections.observableArrayList();

        for (Services service : allServices) {
            if (service.getServiceName().toLowerCase().contains(query.toLowerCase()) ||
                    String.valueOf(service.getPrice()).equals(query)) {
                filteredServices.add(service);
            }
        }

        servicelist.setItems(filteredServices);
    }
   private static String getPasswordFromEnvironment() {
   
    return "1482003";
 }

    @FXML
    private Button addser;

    @FXML
    private CheckBox deccheck;

    @FXML
    private CheckBox djcheck;

    @FXML
    private CheckBox opencheck;






}
