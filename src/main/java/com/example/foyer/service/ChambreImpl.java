package com.example.foyer.service;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Enum.TypeChambre;
import com.example.foyer.repository.ChambreRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
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

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepo.findByBlocsFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeKeyWords(long idBloc, TypeChambre typeC) {
        return chambreRepo.findByBlocsIdBlocAndTypeChambre(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) {
        return chambreRepo.getChambresParBlocEtTypeJPQL(idBloc,typeC);
    }
}
