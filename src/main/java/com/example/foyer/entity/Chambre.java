package com.example.foyer.entity;

import com.example.foyer.entity.Enum.TypeChambre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;
    @ManyToOne
    Bloc blocs;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Reservation>reservations;
}
