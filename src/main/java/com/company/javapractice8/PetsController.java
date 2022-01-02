package com.company.javapractice8;

import com.company.javapractice8.entities.NullPet;
import com.company.javapractice8.entities.Pet;
import com.company.javapractice8.entities.Vaccination;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetsController {

    final ObservableList<Pet> pets = FXCollections.observableArrayList();
    @FXML
    TableView<Pet> petListView;
    @FXML
    TableColumn<Pet, String> petList;
    @FXML
    TextField selectedNickname;
    @FXML
    TextField selectedKind;
    @FXML
    DatePicker selectedPetBirthdate;
    @FXML
    TextField vaccinationType;
    @FXML
    DatePicker vaccinationDate;
    @FXML
    TextField vaccinationDrugName;
    @FXML
    FlowPane vaccinations;
    @FXML
    TableView<Vaccination> selectedPetVaccinationListView;
    @FXML
    TableColumn<Vaccination, Date> vaccinationDateColumn;
    @FXML
    TableColumn<Vaccination, String> vaccinationTypeColumn;
    @FXML
    TableColumn<Vaccination, String> vaccinationDrugNameColumn;

    @FXML
    private void initialize() {
        petList.setCellValueFactory(new PropertyValueFactory<>("nickname"));

        vaccinationDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        vaccinationTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        vaccinationDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>("drugName"));

        petListView.setItems(pets);
    }

    @FXML
    private void createNewPet(ActionEvent actionEvent) {
        pets.add(new NullPet());
    }

    @FXML
    private void savePet(ActionEvent actionEvent) {
    }

    @FXML
    private void addVaccination(ActionEvent actionEvent) {
    }

    @FXML
    private void submitVaccination(ActionEvent actionEvent) {
    }
}