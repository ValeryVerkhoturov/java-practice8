package com.company.javapractice8;

import com.company.javapractice8.entities.Pet;
import com.company.javapractice8.entities.Vaccination;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetsController {

    @FXML
    Label selectedNickname;

    @FXML
    Label selectedAge;

    @FXML
    Label selectedDate;

    @FXML
    TableView<Pet> petListView;

    @FXML
    TableColumn<Pet, String> petList;

    @FXML
    TableView<Vaccination> selectedPetVaccinationListView;

    @FXML
    TableColumn<Vaccination, Date> dateColumn;

    @FXML
    TableColumn<Vaccination, String> typeColumn;

    @FXML
    TableColumn<Vaccination, String> drugNameColumn;

    @FXML
    private void initialize() {

    }

    @FXML
    protected void addPet() {

    }

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}