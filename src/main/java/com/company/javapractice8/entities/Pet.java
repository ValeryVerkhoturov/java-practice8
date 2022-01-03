package com.company.javapractice8.entities;

import java.time.LocalDate;
import java.util.List;

public interface Pet {

    String getNickname();

    String getKind();

    LocalDate getBirthdate();

    List<Vaccination> getVaccinationList();
}
