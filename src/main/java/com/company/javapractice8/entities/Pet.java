package com.company.javapractice8.entities;

import javafx.collections.ObservableList;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
