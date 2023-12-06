package com.example.foyer.service;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Enum.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtTypeKeyWords(long idBloc, TypeChambre typeC);

    List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC);
}
