package com.example.projectsoftware;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RoseController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label capacityLabel;

    public void setHallInformation(Halls hall) {
        nameLabel.setText(hall.getName());
        priceLabel.setText(String.valueOf(hall.getPrice()));
        capacityLabel.setText(String.valueOf(hall.getCapacity()));
    }
}
