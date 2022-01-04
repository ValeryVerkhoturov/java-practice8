package com.company.javapractice8.entities;

import com.company.javapractice8.utlis.IdUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NullVaccination extends Vaccination implements Serializable {

    static LocalDate DEFAULT_DATE = LocalDate.of(1, 1, 1);

    static String DEFAULT_TYPE = "Вид прививки";

    static String DEFAULT_DRUG_NAME = "Название прививки";

    public NullVaccination() {
        super(DEFAULT_DATE, DEFAULT_TYPE, DEFAULT_DRUG_NAME);
    }

    public NullVaccination(List<String> existentDrugNames) {
        super(DEFAULT_DATE, DEFAULT_TYPE, DEFAULT_DRUG_NAME + ' ' + IdUtils.newId(DEFAULT_DRUG_NAME, existentDrugNames));
    }
}
