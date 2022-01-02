package com.company.javapractice8.entities;

import java.util.ArrayList;
import java.util.Date;

public class NullPet extends Pet {

    public NullPet() {
        super("NullNickname", "NullKind", new Date(), new ArrayList<>());
    }
}
