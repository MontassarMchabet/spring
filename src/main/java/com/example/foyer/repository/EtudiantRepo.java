package com.example.foyer.repository;

import com.example.foyer.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepo extends CrudRepository<Etudiant,Long> {
}
