package com.company.javapractice8;

import com.company.javapractice8.entities.Pet;
import com.company.javapractice8.entities.Vaccination;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetsController {

    final ObservableList<Pet> pets = FXCollections.observableArrayList();

    @FXML
    TextField selectedNickname;

    @FXML
    TextField selectedAge;

    @FXML
    TextField selectedDate;

    @FXML
    TableView<Pet> petListView;

    @FXML
    TableColumn<Pet, String> petList;

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
    protected void addPet() {
        Vaccination vaccination = new Vaccination(new Date(234512), "wefr", "sdfg");
        pets.add(new Pet("wdfegnh", "sdfg", new Date(12345432), List.of(vaccination)));
    }
}