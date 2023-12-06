package com.example.foyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    String idReservation;

    LocalDate anneeUniversitaire;
    boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL )
    Set<Etudiant> etudiants;

}
