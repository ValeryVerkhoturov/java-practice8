package com.company.javapractice8.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;
import java.util.Date;

@Data
@FieldNameConstants
public class Vaccination {

    @NonNull
    LocalDate date;

    @NonNull
    String type;

    @NonNull
    String drugName;
}
