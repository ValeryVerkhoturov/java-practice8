package com.company.javapractice8.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class NullVaccination extends Vaccination implements Serializable {

    public NullVaccination() {
        super(LocalDate.of(0, 1, 1), "Вид прививки", "Название прививки");
    }
}
