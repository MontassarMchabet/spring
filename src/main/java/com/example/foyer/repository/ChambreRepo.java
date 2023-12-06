package com.example.foyer.repository;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Enum.TypeChambre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChambreRepo extends CrudRepository<Chambre,Long> {
    Chambre findByNumeroChambre(long numeroChambre);
    List<Chambre>findByBlocsFoyerUniversiteNomUniversite(String blocs_foyer_universite_nomUniversite);
    List<Chambre>findByBlocsIdBlocAndTypeChambre(long blocs_idBloc, TypeChambre typeChambre);
    @Query(value = "select c from Chambre c where c.blocs.idBloc= :idBloc AND c.typeChambre= :typeC")
     List<Chambre> getChambresParBlocEtTypeJPQL (@Param("idBloc") long idBloc,@Param("typeC") TypeChambre typeC) ;


}
