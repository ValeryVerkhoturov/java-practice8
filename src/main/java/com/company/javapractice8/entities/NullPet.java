package com.company.javapractice8.entities;

import javafx.collections.FXCollections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class NullPet extends Pet {

    public NullPet() {
        super("NullNickname", "NullKind", LocalDate.EPOCH, FXCollections.observableArrayList());
    }
}
