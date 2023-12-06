package com.example.foyer.service;

import com.example.foyer.entity.Foyer;
import com.example.foyer.entity.Universite;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer (Foyer f);

    Foyer updateFoyer (Foyer f);

    Foyer retrieveFoyer (long idFoyer);

    void removeFoyer (long idFoyer);

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

    Foyer updateFoyer2(long idFoyer, Foyer f);

    List<String> getnom();

    long getIdParNom(String nomFoyer);
}
