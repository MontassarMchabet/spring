package com.example.foyer.repository;

import com.example.foyer.entity.Foyer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoyerRepo extends CrudRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nomFoyer);

}
