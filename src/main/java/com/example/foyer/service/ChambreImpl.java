package com.example.foyer.service;

import com.example.foyer.entity.Chambre;
import com.example.foyer.repository.ChambreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChambreImpl implements IChambreService{
    private final ChambreRepo chambreRepo;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }
}
