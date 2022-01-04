package com.company.javapractice8.controller;

import com.company.javapractice8.entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetsController {

    ObservableList<PetImplementation> pets;

    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    final String pathToSaveFile = "src/main/resources/com/company/javapractice8/save/";
    final String saveFileName = "save.obj";
    final File saveFile = new File(pathToSaveFile + saveFileName);

    @FXML
    TableView<PetImplementation> petListView;
    @FXML
    TableColumn<PetImplementation, String> petList;
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
    TableView<Vaccination> selectedPetVaccinationListView;
    @FXML
    TableColumn<Vaccination, LocalDate> vaccinationDateColumn;
    @FXML
    TableColumn<Vaccination, String> vaccinationTypeColumn;
    @FXML
    TableColumn<Vaccination, String> vaccinationDrugNameColumn;

    @FXML
    private void initialize() {
        pets = FXCollections.observableArrayList(readSaveFile());

        setPetListViewCellsValue();
        setSelectedPetVaccinationListViewCellsValue();

        petListView.setItems(pets);

        addPetListViewListener();
        addSelectedPetVaccinationListViewListener();

        savePetOnEnterPressed();
        saveVaccinationOnEnterPressed();

        setDatePickerConverters();
        setCellFactoryForTablesWithDates();
    }

    private Optional<PetImplementation> getSelectedPet() {
        return Optional.ofNullable(petListView.getSelectionModel().getSelectedItem());
    }

    private Optional<Vaccination> getSelectedVaccination() {
        return Optional.ofNullable(selectedPetVaccinationListView.getSelectionModel().getSelectedItem());
    }

    private void setPetListViewCellsValue() {
        petList.setCellValueFactory(new PropertyValueFactory<>(PetImplementation.Fields.nickname));
    }

    private void setSelectedPetVaccinationListViewCellsValue() {
        vaccinationDateColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.date));
        vaccinationTypeColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.type));
        vaccinationDrugNameColumn.setCellValueFactory(new PropertyValueFactory<>(Vaccination.Fields.drugName));
    }

    private void addPetListViewListener() {
        petListView.getSelectionModel().selectedItemProperty().addListener((observableValue, pet, t1) -> {
            if (t1 == null) {
                selectedNickname.setText("");
                selectedKind.setText("");
                selectedPetBirthdate.setValue(null);
                selectedPetVaccinationListView.setItems(FXCollections.observableArrayList());
                return;
            }

            selectedNickname.setText(t1.getNickname());
            selectedKind.setText(t1.getKind());
            selectedPetBirthdate.setValue(t1.getBirthdate());
            selectedPetVaccinationListView.setItems(t1.getVaccinationList());
        });
    }

    private void addSelectedPetVaccinationListViewListener() {
        selectedPetVaccinationListView.getSelectionModel().selectedItemProperty().addListener((observableValue, pet, t1) -> {
            if (t1 == null) {
                vaccinationType.setText("");
                vaccinationDate.setValue(null);
                vaccinationDrugName.setText("");
                return;
            }

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

    private void setDatePickerConverters() {
        StringConverter<LocalDate> stringConverter = new StringConverter<>() {
            @Override
            public String toString(LocalDate localDate) {
                if (localDate != null)
                    return dateTimeFormatter.format(localDate);
                return "";
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty())
                    return LocalDate.parse(string, dateTimeFormatter);
                return null;
            }
        };

        selectedPetBirthdate.setConverter(stringConverter);
        vaccinationDate.setConverter(stringConverter);
    }

    private void setCellFactoryForTablesWithDates() {
        vaccinationDateColumn.setCellFactory(vaccinationDateTableColumn -> new TableCell<>() {
            @Override
            protected void updateItem(LocalDate localDate, boolean empty) {
                super.updateItem(localDate, empty);
                if (empty)
                    setText(null);
                else
                    setText(dateTimeFormatter.format(localDate));
            }
        });
    }

    @FXML
    private void createNewPet() {
        pets.add(new NullPetImplementation(pets.stream().map(PetImplementation::getNickname).toList()));
    }

    @FXML
    private void savePet() {
        getSelectedPet().ifPresent(pet -> {
            pet.setNickname(selectedNickname.getText());
            pet.setKind(selectedKind.getText());
            pet.setBirthdate(selectedPetBirthdate.getValue());

            petListView.refresh();
        });
    }

    @FXML
    private void removeSelectedPet() {
        getSelectedPet().ifPresent(pet -> {
            pets.remove(pet);
            selectedPetVaccinationListView.refresh();
        });
    }

    @FXML
    private void addVaccination() {
        getSelectedPet().ifPresent(pet -> {
            List<Vaccination> vaccinationList = pet.getVaccinationList();
            vaccinationList.add(new NullVaccination(vaccinationList.stream().map(Vaccination::getDrugName).toList()));
        });
    }

    @FXML
    private void submitVaccination() {
        getSelectedVaccination().ifPresent(vaccination -> {
            vaccination.setType(vaccinationType.getText());
            vaccination.setDate(vaccinationDate.getValue());
            vaccination.setDrugName(vaccinationDrugName.getText());

            selectedPetVaccinationListView.refresh();
        });
    }

    @FXML
    private void removeVaccination() {
        getSelectedPet().ifPresent(
                pet -> getSelectedVaccination().ifPresent(
                        vaccination -> pet.getVaccinationList().remove(vaccination)));
    }

    public void shutdown() {
        writeSaveFile();
    }

//    @SuppressWarnings("unchecked")
    @SneakyThrows
    private List<PetImplementation> readSaveFile() {
        List<PetImplementation> pets = null;
        if (saveFile.exists()) {
            @Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(saveFile));
            pets = ((List<PetDTO>) objectInputStream.readObject()).stream().map(PetDTO::from).toList();
        }
        return pets != null ? pets : List.of();
    }

    @SneakyThrows
    private void writeSaveFile() {
        File saveFolder = new File(pathToSaveFile);
        if (!saveFile.delete() && !saveFolder.mkdirs() && !saveFile.createNewFile())
            return;

        @Cleanup ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(saveFile, false));
        objectOutputStream.writeObject(pets.stream().map(PetDTO::to).toList());
    }
}