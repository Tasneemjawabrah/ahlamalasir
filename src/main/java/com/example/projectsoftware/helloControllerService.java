package com.example.projectsoftware;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class helloControllerService {

    @FXML
    private ListView<Services> servicelist;

    @FXML
    private TextField txt2;

    private ObservableList<Services> allServices;

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1482003";

    @FXML
    public void initialize() {
        allServices = fetchAllServices();
        servicelist.setItems(allServices);

        // Listen for changes in the text field and perform search
        txt2.textProperty().addListener((observable, oldValue, newValue) -> searchServices(newValue));
    }

    private ObservableList<Services> fetchAllServices() {
        ObservableList<Services> services = FXCollections.observableArrayList();

        String query = "SELECT * FROM software.services";

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



                // You might need to handle image retrieval here if needed

                Services service = new Services(serviceId, serviceName, description, price, userId, new byte[]{imagee});
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception based on your application's needs
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

    @FXML
    private Button addser;

    @FXML
    private CheckBox deccheck;

    @FXML
    private CheckBox djcheck;

    @FXML
    private CheckBox opencheck;





}
