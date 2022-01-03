package com.company.javapractice8.entities;

import javafx.collections.FXCollections;

import java.time.LocalDate;

public class NullPet extends Pet {

    public NullPet() {
        super("Твой питомец", "Вид питомца", LocalDate.of(0, 1, 1), FXCollections.observableArrayList());
    }
}
