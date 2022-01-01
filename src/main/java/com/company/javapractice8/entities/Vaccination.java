package com.company.javapractice8.entities;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Vaccination {

    @NonNull
    Date date;

    @NonNull
    String type;

    @NonNull
    String drugName;
}
