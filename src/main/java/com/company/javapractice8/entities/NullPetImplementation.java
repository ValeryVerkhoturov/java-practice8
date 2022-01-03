package com.company.javapractice8.entities;

import javafx.collections.FXCollections;

import java.time.LocalDate;

public class NullPetImplementation extends PetImplementation {

    public NullPetImplementation(int id) {
        super("Твой питомец " + id, "Вид питомца", LocalDate.of(0, 1, 1), FXCollections.observableArrayList());
    }

    public NullPetImplementation() {
        super("Твой питомец", "Вид питомца", LocalDate.of(0, 1, 1), FXCollections.observableArrayList());
    }
}
