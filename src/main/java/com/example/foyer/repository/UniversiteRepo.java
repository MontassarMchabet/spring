package com.example.foyer.repository;

import com.example.foyer.entity.Universite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UniversiteRepo extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
    List<Universite> findByFoyersIsNull();


}
