package com.example.foyer.service;

import com.example.foyer.entity.Foyer;
import com.example.foyer.entity.Universite;
import com.example.foyer.repository.FoyerRepo;
import com.example.foyer.repository.UniversiteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class UniversiteImpl implements IUniversiteService{
    private final UniversiteRepo universiteRepo;
    private final FoyerRepo foyerRepo;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite( String  nomFoyer ,  long iduniv) {
        Foyer foyer=foyerRepo.findByNomFoyer(nomFoyer);
        Universite universite=universiteRepo.findById(iduniv).orElse(null);
        universite.setFoyers(foyer);
        return universiteRepo.save(universite);
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyers(null);

        return universite;
    }

    @Override
    public Universite updateUniversit2(long idUniversite,Universite updatedUniversite) {
        Universite existingUniversite = universiteRepo.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("Universite not found with id: " + idUniversite));

        // Mettez à jour les champs nécessaires
        existingUniversite.setNomUniversite(updatedUniversite.getNomUniversite());
        existingUniversite.setAdresse(updatedUniversite.getAdresse());
        // Mettez à jour d'autres champs si nécessaire

        // Enregistrez la mise à jour dans la base de données
        return universiteRepo.save(existingUniversite);
    }

    @Override
    public void removeuniv(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public long getIdParNom(String nomuniv) {
        Universite universite=universiteRepo.findByNomUniversite(nomuniv);
        long id =universite.getIdUniversite();
        return id ;
    }

    @Override
    public List<Universite> getAllDispo() {
        return  universiteRepo.findByFoyersIsNull();
    }


}
