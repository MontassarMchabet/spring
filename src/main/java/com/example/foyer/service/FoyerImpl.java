package com.example.foyer.service;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Foyer;
import com.example.foyer.entity.Universite;
import com.example.foyer.repository.BlocRepo;
import com.example.foyer.repository.FoyerRepo;
import com.example.foyer.repository.UniversiteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FoyerImpl implements IFoyerService{
    private final FoyerRepo foyerRepo;
    private final UniversiteRepo universiteRepo;
    private final BlocRepo blocRepo;


    @Override
    public List<Foyer> retrieveAllFoyers() {
        return(List<Foyer>) foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);

    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite=universiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyers(foyer);
        foyerRepo.save(foyer);
        universiteRepo.save(universite);

        return foyer ;
    }

    @Override
    public Foyer updateFoyer2(long idFoyer, Foyer f) {
        Foyer existingFoyer = foyerRepo.findById(idFoyer)
                .orElseThrow(() -> new IllegalArgumentException("Universite not found with id: " + idFoyer));

        // Mettez à jour les champs nécessaires
        existingFoyer.setNomFoyer(f.getNomFoyer());
        existingFoyer.setCapaciteFoyer(f.getCapaciteFoyer());
        // Mettez à jour d'autres champs si nécessaire

        // Enregistrez la mise à jour dans la base de données
        return foyerRepo.save(existingFoyer);
    }

    @Override
    public List<String> getnom() {
        List<Foyer> foyers = (List<Foyer>) foyerRepo.findAll();
        return foyers.stream()
                .map(Foyer::getNomFoyer)
                .collect(Collectors.toList());
    }

    @Override
    public long getIdParNom(String nomFoyer) {
        Foyer foyer=foyerRepo.findByNomFoyer(nomFoyer);
        long id =foyer.getIdFoyer();
        return id ;
    }

}
