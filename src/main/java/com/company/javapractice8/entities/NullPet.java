package com.company.javapractice8.entities;

import javafx.collections.FXCollections;

import java.io.Serializable;
import java.time.LocalDate;

public class NullPet extends Pet implements Serializable{

    public NullPet() {
        super("Твой питомец", "Вид питомца", LocalDate.of(0, 1, 1), FXCollections.observableArrayList());
    }
}
