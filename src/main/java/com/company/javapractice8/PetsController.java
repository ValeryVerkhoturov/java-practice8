package com.company.javapractice8;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PetsController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}