package com.example.foyer.service;

import com.example.foyer.entity.Universite;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (long idUniversite);

    Universite affecterFoyerAUniversite( String  nomFoyer ,   long iduniv);

    Universite desaffecterFoyerAUniversite(long idUniversite);

    Universite updateUniversit2(long idUniversite,Universite updatedUniversite);


    void removeuniv(long idUniversite);

    long getIdParNom(String nomuniv);

    List<Universite> getAllDispo();
}
