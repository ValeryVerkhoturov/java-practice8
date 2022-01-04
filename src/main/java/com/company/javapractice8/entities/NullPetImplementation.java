package com.company.javapractice8.entities;

import com.company.javapractice8.utlis.IdUtils;
import javafx.collections.FXCollections;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NullPetImplementation extends PetImplementation {

    static String DEFAULT_NICKNAME = "Твой питомец";

    static String DEFAULT_KIND = "Вид питомца";

    static LocalDate DEFAULT_DATE = LocalDate.of(0, 1, 1);

    public NullPetImplementation() {
        super(DEFAULT_NICKNAME, DEFAULT_KIND, DEFAULT_DATE, FXCollections.observableArrayList());
    }

    public NullPetImplementation(List<String> existentNicknames) {
        super(DEFAULT_NICKNAME + ' ' + IdUtils.newId(DEFAULT_NICKNAME, existentNicknames), DEFAULT_KIND, DEFAULT_DATE, FXCollections.observableArrayList());
    }
}
