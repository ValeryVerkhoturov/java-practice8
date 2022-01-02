package com.company.javapractice8.entities;

import java.util.Date;

public class NullVaccination extends Vaccination {

    public NullVaccination() {
        super(new Date(), "NullType", "NullDrugName");
    }
}
