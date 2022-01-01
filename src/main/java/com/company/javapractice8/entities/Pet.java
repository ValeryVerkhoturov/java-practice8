package com.company.javapractice8.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Data
public class Pet {

    @NonNull
    String nickname;

    @NonNull
    String kind;

    @NonNull
    Date birthdate;

    @NonNull
    List<Vaccination> vaccinationList;
}
