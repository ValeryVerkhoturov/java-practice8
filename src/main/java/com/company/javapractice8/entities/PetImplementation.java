package com.company.javapractice8.entities;

import javafx.collections.ObservableList;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetImplementation implements Pet {

    @NonNull
    String nickname;

    @NonNull
    String kind;

    @NonNull
    LocalDate birthdate;

    @NonNull
    ObservableList<Vaccination> vaccinationList;
}
