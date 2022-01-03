package com.company.javapractice8.entities;

import javafx.collections.FXCollections;

import java.time.LocalDate;

public class NullPet extends Pet {

    public NullPet() {
        super("NullNickname", "NullKind", LocalDate.EPOCH, FXCollections.observableArrayList());
    }
}
