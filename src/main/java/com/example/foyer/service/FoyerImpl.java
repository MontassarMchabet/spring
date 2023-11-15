package com.example.foyer.service;

import com.example.foyer.entity.Foyer;
import com.example.foyer.repository.FoyerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoyerImpl implements IFoyerService{
    private final FoyerRepo foyerRepo;

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
}
