package com.company.javapractice8.entities;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Pet {

    String nickname;

    String kind;

    Date birthdate;

    List<Vaccination> vaccinationList;
}
