package com.company.javapractice8.entities;

import javafx.collections.FXCollections;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Value
public class PetDTO implements Serializable {

    String nickname;

    String kind;

    LocalDate birthdate;

    List<Vaccination> vaccinationList;

    public static PetDTO to(Pet pet) {
        return new PetDTO(pet.getNickname(),
                pet.getKind(),
                pet.birthdate,
                pet.vaccinationList.stream().toList());
    }

    public static Pet from(PetDTO petDTO) {
        return new Pet(petDTO.getNickname(),
                petDTO.getKind(),
                petDTO.getBirthdate(),
                FXCollections.observableArrayList(petDTO.vaccinationList));
    }
}
