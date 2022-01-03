package com.company.javapractice8.entities;

import javafx.collections.FXCollections;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Value
public class PetDTO implements Pet, Serializable {

    String nickname;

    String kind;

    LocalDate birthdate;

    List<Vaccination> vaccinationList;

    public static PetDTO to(PetImplementation pet) {
        return new PetDTO(pet.getNickname(),
                pet.getKind(),
                pet.getBirthdate(),
                pet.getVaccinationList().stream().toList());
    }

    public static PetImplementation from(PetDTO petDTO) {
        return new PetImplementation(petDTO.getNickname(),
                petDTO.getKind(),
                petDTO.getBirthdate(),
                FXCollections.observableArrayList(petDTO.vaccinationList));
    }
}
