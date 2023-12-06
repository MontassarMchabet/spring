package com.example.foyer.service;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;
import com.example.foyer.repository.BlocRepo;
import com.example.foyer.repository.ChambreRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor

public class BlocImpl implements IBlocService{
   private final BlocRepo blocRepo;
   private final ChambreRepo chambreRepo;

    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc=blocRepo.findById(idBloc).orElse(null);
        for (long num:numChambre){
            Chambre chambre=chambreRepo.findByNumeroChambre(num);
            chambre.setBlocs(bloc);
            chambreRepo.save(chambre);
        }

        return blocRepo.save(bloc);
    }
}
