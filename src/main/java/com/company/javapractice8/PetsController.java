package com.company.javapractice8;

import com.company.javapractice8.entities.NullPet;
import com.company.javapractice8.entities.NullVaccination;
import com.company.javapractice8.entities.Pet;
import com.company.javapractice8.entities.Vaccination;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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

        savePetOnEnterPressed();
        saveVaccinationOnEnterPressed();
    }

    private Pet getSelectedPet() {
        return petListView.getSelectionModel().getSelectedItem();
    }

    private Vaccination getSelectedVaccination() {
        return selectedPetVaccinationListView.getSelectionModel().getSelectedItem();
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
            if (t1 == null)
                return;

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

    private void savePetOnEnterPressed() {
        EventHandler<KeyEvent> eventHandler = keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER))
                savePet();
        };

        selectedNickname.setOnKeyPressed(eventHandler);
        selectedKind.setOnKeyPressed(eventHandler);
        selectedPetBirthdate.setOnKeyPressed(eventHandler);
    }

    private void saveVaccinationOnEnterPressed() {
        EventHandler<KeyEvent> eventHandler = keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER))
                submitVaccination();
        };

        vaccinationType.setOnKeyPressed(eventHandler);
        vaccinationDate.setOnKeyPressed(eventHandler);
        vaccinationDrugName.setOnKeyPressed(eventHandler);
    }

    @FXML
    private void createNewPet() {
        pets.add(new NullPet());
    }

    @FXML
    private void savePet() {
        Pet selectedPet = getSelectedPet();
        if (selectedPet == null)
            return;

        selectedPet.setNickname(selectedNickname.getText());
        selectedPet.setKind(selectedKind.getText());
        selectedPet.setBirthdate(selectedPetBirthdate.getValue());

        petListView.refresh();
    }

    public void removeSelectedPet() {
        Pet selectedPet = getSelectedPet();
        if (selectedPet == null)
            return;

        pets.remove(selectedPet);

        selectedPetVaccinationListView.refresh();
    }

    @FXML
    private void addVaccination() {
        Pet selectedPet = getSelectedPet();
        if (selectedPet == null)
            return;

        selectedPet.getVaccinationList().add(new NullVaccination());
    }

    @FXML
    private void submitVaccination() {
        Vaccination selectedVaccination = getSelectedVaccination();
        if (selectedVaccination == null)
            return;

        selectedVaccination.setType(vaccinationType.getText());
        selectedVaccination.setDate(vaccinationDate.getValue());
        selectedVaccination.setDrugName(vaccinationDrugName.getText());

        selectedPetVaccinationListView.refresh();
    }

    public void removeVaccination() {
        Pet selectedPet = getSelectedPet();
        Vaccination selectedVaccination = getSelectedVaccination();
        if (selectedPet == null || selectedVaccination == null)
            return;

        selectedPet.getVaccinationList().remove(selectedVaccination);
    }
}