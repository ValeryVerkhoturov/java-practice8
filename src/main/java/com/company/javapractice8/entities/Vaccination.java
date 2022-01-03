package com.company.javapractice8.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@FieldNameConstants
public class Vaccination implements Serializable {

    @NonNull
    LocalDate date;

    @NonNull
    String type;

    @NonNull
    String drugName;
}
