package com.company.javapractice8.entities;

import javafx.collections.ObservableList;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@FieldNameConstants
public class Pet {

    @NonNull
    String nickname;

    @NonNull
    String kind;

    @NonNull
    LocalDate birthdate;

    @NonNull
    ObservableList<Vaccination> vaccinationList;
}
