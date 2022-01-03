package com.company.javapractice8.entities;

import java.time.LocalDate;

public class NullVaccination extends Vaccination {

    public NullVaccination() {
        super(LocalDate.EPOCH, "NullType", "NullDrugName");
    }
}
