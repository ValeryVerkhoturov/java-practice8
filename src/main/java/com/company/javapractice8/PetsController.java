package com.company.javapractice8;

import com.company.javapractice8.entities.NullPet;
import com.company.javapractice8.entities.NullVaccination;
import com.company.javapractice8.entities.Pet;
import com.company.javapractice8.entities.Vaccination;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        setPetListViewCellsValue();
        setSelectedPetVaccinationListViewCellsValue();

        petListView.setItems(pets);

        addPetListViewListener();
        addSelectedPetVaccinationListViewListener();
    }

    private void setPetListViewCellsValue() {
        petList.setCellValueFactory(new PropertyValueFactory<>(Pet.Fields.nickname));
    }

    private void setSelectedPetVaccinationListViewCellsValue() {
        vaccinationDateColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.date));
        vaccinationTypeColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.type));
        vaccinationDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.drugName));
    }

    private void addPetListViewListener() {
        petListView.getSelectionModel().selectedItemProperty().addListener((observableValue, pet, t1) -> {
            selectedNickname.setText(t1.getNickname());
            selectedKind.setText(t1.getKind());
            selectedPetBirthdate.setValue(t1.getBirthdate());

            selectedPetVaccinationListView.setItems(t1.getVaccinationList());
        });
    }

    private void addSelectedPetVaccinationListViewListener() {
        selectedPetVaccinationListView.getSelectionModel().selectedItemProperty().addListener((observableValue, pet, t1) -> {
            if (t1 == null)
                return;

            vaccinationType.setText(t1.getType());
            vaccinationDate.setValue(t1.getDate());
            vaccinationDrugName.setText(t1.getDrugName());
        });
    }

    @FXML
    private void createNewPet(ActionEvent actionEvent) {
        pets.add(new NullPet());
    }

    @FXML
    private void savePet(ActionEvent actionEvent) {
        Pet selectedPet = petListView.getSelectionModel().getSelectedItem();
        if (selectedPet == null)
            return;

        selectedPet.setNickname(selectedNickname.getText());
        selectedPet.setKind(selectedKind.getText());
        selectedPet.setBirthdate(selectedPetBirthdate.getValue());
    }

    @FXML
    private void addVaccination(ActionEvent actionEvent) {
        Pet selectedPet = petListView.getSelectionModel().getSelectedItem();
        if (selectedPet == null)
            return;

        selectedPet.getVaccinationList().add(new NullVaccination());
    }

    @FXML
    private void submitVaccination(ActionEvent actionEvent) {
        Vaccination selectedVaccination = selectedPetVaccinationListView.getSelectionModel().getSelectedItem();
        if (selectedVaccination == null)
            return;

        selectedVaccination.setType(vaccinationType.getText());
        selectedVaccination.setDate(vaccinationDate.getValue());
        selectedVaccination.setDrugName(vaccinationDrugName.getText());
    }
}