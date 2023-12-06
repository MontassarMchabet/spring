package com.example.foyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;
    @ManyToOne
    @JsonIgnore
    Foyer foyer;
    @OneToMany(mappedBy = "blocs",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Chambre> chambres;
}
